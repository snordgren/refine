package org.domino

import org.domino.html.HTML
import org.scalajs.dom
import org.scalajs.dom.document

object Domino {
  def main(args: Array[String]): Unit = {
    import HTML._
    
    val source =
      div()(
        h1(id := "header-1")("Welcome to Domino!"),
        p(data("home") := "where the heart is")("This text was rendered using the Domino library."),
        p()("This paragraph was added."))
    
    val root = document.getElementById("root")
    val result = VirtualDOM.render(source, root)
    result match {
      case Left(msg) => println(msg)
      case _ =>
    }
    
    dom.window.setTimeout(() => {
      val renderStart = System.currentTimeMillis()
      val source =
        div()(
          h1(id := "header-2")("Welcome to Domino! This was re-rendered!"),
          p()("This text was rendered using the Domino library."),
          p()("This paragraph was changed too."))
      val root = document.getElementById("root")
      val result = VirtualDOM.render(source, root)
      val renderEnd = System.currentTimeMillis()
      result match {
        case Left(msg) => println(msg)
        case _ =>
      }
    }, 500)
  }
}
