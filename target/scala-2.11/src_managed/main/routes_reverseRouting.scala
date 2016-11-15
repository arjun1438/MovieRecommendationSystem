// @SOURCE:/home/hadoop/movierecommender/conf/routes
// @HASH:16b1cacad5079e6d59775c0b60e0c4276900be72
// @DATE:Mon Nov 14 17:49:24 CST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:11
class ReverseAssets {


// @LINE:11
def versioned(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def recommendation(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "recommendation")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:7
def rating(item:Option[String], rating:Option[Double]): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "rating" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("item", item)), Some(implicitly[QueryStringBindable[Option[Double]]].unbind("rating", rating)))))
}
                        

}
                          
}
                  


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:11
class ReverseAssets {


// @LINE:11
def versioned : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.versioned",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def recommendation : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.recommendation",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recommendation"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:7
def rating : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.rating",
   """
      function(item,rating) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rating" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("item", item), (""" + implicitly[QueryStringBindable[Option[Double]]].javascriptUnbind + """)("rating", rating)])})
      }
   """
)
                        

}
              
}
        


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:11
class ReverseAssets {


// @LINE:11
def versioned(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.versioned(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:8
def recommendation(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.recommendation(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "recommendation", Seq(), "GET", """""", _prefix + """recommendation""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:7
def rating(item:Option[String], rating:Option[Double]): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.rating(item, rating), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "rating", Seq(classOf[Option[String]], classOf[Option[Double]]), "GET", """""", _prefix + """rating""")
)
                      

}
                          
}
        
    