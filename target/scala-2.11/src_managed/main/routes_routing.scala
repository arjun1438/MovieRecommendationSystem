// @SOURCE:/home/hadoop/movierecommender/conf/routes
// @HASH:16b1cacad5079e6d59775c0b60e0c4276900be72
// @DATE:Mon Nov 14 17:49:24 CST 2016


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_rating1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rating"))))
private[this] lazy val controllers_Application_rating1_invoker = createInvoker(
controllers.Application.rating(fakeValue[Option[String]], fakeValue[Option[Double]]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "rating", Seq(classOf[Option[String]], classOf[Option[Double]]),"GET", """""", Routes.prefix + """rating"""))
        

// @LINE:8
private[this] lazy val controllers_Application_recommendation2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recommendation"))))
private[this] lazy val controllers_Application_recommendation2_invoker = createInvoker(
controllers.Application.recommendation,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "recommendation", Nil,"GET", """""", Routes.prefix + """recommendation"""))
        

// @LINE:11
private[this] lazy val controllers_Assets_versioned3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
controllers.Assets.versioned(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rating""","""controllers.Application.rating(item:Option[String], rating:Option[Double])"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recommendation""","""controllers.Application.recommendation"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.versioned(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:7
case controllers_Application_rating1_route(params) => {
   call(params.fromQuery[Option[String]]("item", None), params.fromQuery[Option[Double]]("rating", None)) { (item, rating) =>
        controllers_Application_rating1_invoker.call(controllers.Application.rating(item, rating))
   }
}
        

// @LINE:8
case controllers_Application_recommendation2_route(params) => {
   call { 
        controllers_Application_recommendation2_invoker.call(controllers.Application.recommendation)
   }
}
        

// @LINE:11
case controllers_Assets_versioned3_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(controllers.Assets.versioned(path, file))
   }
}
        
}

}
     