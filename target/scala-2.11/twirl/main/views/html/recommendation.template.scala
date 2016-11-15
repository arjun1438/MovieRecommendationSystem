
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
object recommendation extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Seq[model.AmazonProduct],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(products: Seq[model.AmazonProduct]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.38*/("""

"""),_display_(/*3.2*/main("Your Recommendations", "recommendation")/*3.48*/ {_display_(Seq[Any](format.raw/*3.50*/("""
    """),format.raw/*4.5*/("""<div class="jumbotron">
        <h2 class="text-center">
            <span>Your recommendations</span>
        </h2>
    </div>
    """),_display_(/*9.6*/for(product <- products) yield /*9.30*/ {_display_(Seq[Any](format.raw/*9.32*/("""
        """),format.raw/*10.9*/("""<div class="jumbotron">
            <h4 class="text-center">
                <span>"""),_display_(/*12.24*/product/*12.31*/.title),format.raw/*12.37*/("""</span>
            </h4>
            <div class="row">
                <div class="col-md-4">
                    <img src=""""),_display_(/*16.32*/product/*16.39*/.img),format.raw/*16.43*/(""""/>
                    <br/><br>
                    <a href=""""),_display_(/*18.31*/product/*18.38*/.url),format.raw/*18.42*/("""">View on Amazon</a>
                </div>
                <div class="col-md-6">
                    """),_display_(/*21.22*/Html(product.description)),format.raw/*21.47*/("""
                """),format.raw/*22.17*/("""</div>
            </div>
        </div>
    """)))}),format.raw/*25.6*/("""
""")))}))}
  }

  def render(products:Seq[model.AmazonProduct]): play.twirl.api.HtmlFormat.Appendable = apply(products)

  def f:((Seq[model.AmazonProduct]) => play.twirl.api.HtmlFormat.Appendable) = (products) => apply(products)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Nov 14 17:49:25 CST 2016
                  SOURCE: /home/hadoop/movierecommender/app/views/recommendation.scala.html
                  HASH: beab544461015790e29f660a59b69aed5f747233
                  MATRIX: 532->1|656->37|684->40|738->86|777->88|808->93|966->226|1005->250|1044->252|1080->261|1191->345|1207->352|1234->358|1387->484|1403->491|1428->495|1519->559|1535->566|1560->570|1691->674|1737->699|1782->716|1858->762
                  LINES: 19->1|22->1|24->3|24->3|24->3|25->4|30->9|30->9|30->9|31->10|33->12|33->12|33->12|37->16|37->16|37->16|39->18|39->18|39->18|42->21|42->21|43->22|46->25
                  -- GENERATED --
              */
          