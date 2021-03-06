package controllers

import play.api.mvc._
import model.AmazonRating._
import model.{AmazonProduct, AmazonProductAndRating, AmazonRating}
import org.apache.spark.SparkContext
import reactivemongo.api.MongoDriver
import reactivemongo.api.collections.bson.BSONCollection
import reactivemongo.bson.BSONDocument
import util.{AmazonPageParser, Recommender}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


object Application extends Controller {
		
  val NumRetries = 3
  val MaxRecommendations = 5

  val driver = new MongoDriver
  val connection = driver.connection(List("127.0.0.1"))

  val db = connection("amazon_recommendation")
  val ratingCollection = db[BSONCollection]("ratings")

  val RatingFile = "ratings.csv"

  val sc = new SparkContext("local[4]", "recommender")
  sc.addJar("target/scala-2.11/movie_recommender_2.11-1.0-SNAPSHOT.jar")
  val recommender = new Recommender(sc, RatingFile)

  // return random amazon page and retry multiple times (in case a page is buggy, we try another one)
  private def parseRandomAmazonPageWithRetries(numRetries: Int): Future[AmazonProduct] = {
    val productId = recommender.getRandomProductId
    AmazonPageParser.parse(productId).recoverWith {
      case e: Exception if numRetries >= 0 =>
        parseRandomAmazonPageWithRetries(numRetries - 1)
    }
  }

  def rating(productIdOpt: Option[String], ratingOpt: Option[Double]) = Action.async {
    val fut = (productIdOpt, ratingOpt) match {
      case (Some(productId), Some(rating)) =>
         ratingCollection.update(AmazonRating("myself", productId, rating), AmazonRating("myself", productId, rating), upsert = true)

      case _ => Future.successful()
    }

    fut.flatMap {
      _ => parseRandomAmazonPageWithRetries(NumRetries).map(
        item => Ok(views.html.rating(item))
      ) recover {
        case e: Exception => sys.error(s"Cannot load Amazon page after $NumRetries attempts. Please reload the page")
      }
    }
  }

  def index() = Action {
    Redirect("/rating")
  }

  def recommendation = Action.async {
    ratingCollection.find(BSONDocument.empty).cursor[AmazonRating].collect[Seq]().flatMap {
      ratings =>
        val amazonRatings = recommender.predict(ratings.take(MaxRecommendations)).toSeq
        val productsFut = Future.traverse(amazonRatings) (
          amazonRating => {
            println("Rating:" + amazonRating)
            // remove errored product pages
            AmazonPageParser.parse(amazonRating.productId).map(Option(_)).recover {case _: Exception => None}
          }
        )
        productsFut.map {
          products => Ok(views.html.recommendation(products.flatten))
        }
    }
  }
}
