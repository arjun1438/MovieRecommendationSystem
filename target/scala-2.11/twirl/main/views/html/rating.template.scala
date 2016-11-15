
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
object rating extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[model.AmazonProduct,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(item: model.AmazonProduct):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.29*/("""

"""),_display_(/*3.2*/main(item.title, "rating")/*3.28*/ {_display_(Seq[Any](format.raw/*3.30*/("""
    """),format.raw/*4.5*/("""<div class="jumbotron">
        <h2 class="text-center">
            <span>Your rating:</span>
            <button type="button" class="btn btn-lg btn-danger" onclick="location.href='/rating?item="""),_display_(/*7.103*/item/*7.107*/.itemId),format.raw/*7.114*/("""&rating=1'">Very Bad</button>
            <button type="button" class="btn btn-lg btn-warning" onclick="location.href='/rating?item="""),_display_(/*8.104*/item/*8.108*/.itemId),format.raw/*8.115*/("""&rating=2'">Bad</button>
            <button type="button" class="btn btn-lg btn-info" onclick="location.href='/rating?item="""),_display_(/*9.101*/item/*9.105*/.itemId),format.raw/*9.112*/("""&rating=3'">Average</button>
            <button type="button" class="btn btn-lg btn-primary" onclick="location.href='/rating?item="""),_display_(/*10.104*/item/*10.108*/.itemId),format.raw/*10.115*/("""&rating=4'">Good</button>
            <button type="button" class="btn btn-lg btn-success" onclick="location.href='/rating?item="""),_display_(/*11.104*/item/*11.108*/.itemId),format.raw/*11.115*/("""&rating=5'">Excellent</button>
            or <a href="/rating">Skip</a>
        </h2>
    </div>
    <h3>"""),_display_(/*15.10*/item/*15.14*/.title),format.raw/*15.20*/("""</h3>
    <div class="row">
        <div class="col-md-4">
            <img src=""""),_display_(/*18.24*/item/*18.28*/.img),format.raw/*18.32*/(""""/>
            <br/>
            <a href=""""),_display_(/*20.23*/item/*20.27*/.url),format.raw/*20.31*/("""" target="_blank">See item on Amazon</a>
        </div>
        <div class="col-md-6">
        """),_display_(/*23.10*/Html(item.description)),format.raw/*23.32*/("""
        """),format.raw/*24.9*/("""</div>
    </div>

""")))}))}
  }

  def render(item:model.AmazonProduct): play.twirl.api.HtmlFormat.Appendable = apply(item)

  def f:((model.AmazonProduct) => play.twirl.api.HtmlFormat.Appendable) = (item) => apply(item)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Nov 14 17:49:25 CST 2016
                  SOURCE: /home/hadoop/movierecommender/app/views/rating.scala.html
                  HASH: 3c60ae3a09e69066130cfe7c307a140cf8566a56
                  MATRIX: 519->1|634->28|662->31|696->57|735->59|766->64|990->261|1003->265|1031->272|1191->405|1204->409|1232->416|1384->541|1397->545|1425->552|1585->684|1599->688|1628->695|1785->824|1799->828|1828->835|1962->942|1975->946|2002->952|2111->1034|2124->1038|2149->1042|2220->1086|2233->1090|2258->1094|2381->1190|2424->1212|2460->1221
                  LINES: 19->1|22->1|24->3|24->3|24->3|25->4|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|36->15|36->15|36->15|39->18|39->18|39->18|41->20|41->20|41->20|44->23|44->23|45->24
                  -- GENERATED --
              */
          