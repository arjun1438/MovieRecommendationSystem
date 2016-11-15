
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, tab: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.45*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*8.54*/routes/*8.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*8.101*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*9.54*/routes/*9.60*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*9.110*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*10.54*/routes/*10.60*/.Assets.versioned("stylesheets/bootstrap-theme.min.css")),format.raw/*10.116*/("""">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*12.59*/routes/*12.65*/.Assets.versioned("images/favicon.png")),format.raw/*12.104*/("""">
        <script src=""""),_display_(/*13.23*/routes/*13.29*/.Assets.versioned("javascripts/bootstrap.min.js")),format.raw/*13.78*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*14.23*/routes/*14.29*/.Assets.versioned("javascripts/jquery-1.9.0.min.js")),format.raw/*14.81*/("""" type="text/javascript"></script>
    </head>
    <body data-spy="scroll" data-twttr-rendered="true">
            <!-- Fixed navbar -->
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/">Movie recommender</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class=""""),_display_(/*25.37*/("active".when(tab == "rating"))),format.raw/*25.69*/(""""><a href="/">Ratings</a></li>
                        <li class=""""),_display_(/*26.37*/("active".when(tab == "recommendation"))),format.raw/*26.77*/(""""><a href="/recommendation">Recommendations</a></li>
                        <li><a href="//localhost:4040" target="_blank">Spark</a></li>
                    </ul>
                </div> <!--/.nav-collapse -->
            </div>
        </div> <!-- /container -->
        <div class="container theme-showcase" role="main">
        """),_display_(/*33.10*/content),format.raw/*33.17*/("""
        """),format.raw/*34.9*/("""</div>
        <footer class="footer">
            <div class="container">
                <p>Designed and built with love somewhere on Earth</p>
            </div>
        </footer>
    </body>
</html>
"""))}
  }

  def render(title:String,tab:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,tab)(content)

  def f:((String,String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title,tab) => (content) => apply(title,tab)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Nov 14 17:49:25 CST 2016
                  SOURCE: /home/hadoop/movierecommender/app/views/main.scala.html
                  HASH: 28af133cfc5fd662232dfea71a0a91cff4fcb6cb
                  MATRIX: 516->1|647->44|675->46|752->97|777->102|865->164|879->170|941->211|1023->267|1037->273|1108->323|1191->379|1206->385|1284->441|1451->581|1466->587|1527->626|1579->651|1594->657|1664->706|1748->763|1763->769|1836->821|2396->1354|2449->1386|2543->1453|2604->1493|2964->1826|2992->1833|3028->1842
                  LINES: 19->1|22->1|24->3|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|46->25|46->25|47->26|47->26|54->33|54->33|55->34
                  -- GENERATED --
              */
          