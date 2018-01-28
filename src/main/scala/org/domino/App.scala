package org.domino

import org.domino.html.HTML
import org.scalajs.dom.document

object App {
  import HTML._

  def page() =
    div()(
      h1()("Hello, world!"),
      p(id := "description")(
        "This page was rendered with the Domino library for Scala.js."),
      p()("Enjoy!"))

  def main(args: Array[String]): Unit = {
    val root = document.getElementById("root")
    Domino.render(page(), root)
  }
}