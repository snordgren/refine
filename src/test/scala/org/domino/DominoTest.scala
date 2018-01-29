package org.domino

import org.domino.html.{DivElement, HTML}
import org.scalajs.dom.document
import org.scalajs.dom.raw.MouseEvent

class DominoTest extends UnitTest {
  before {
    if (document.getElementById("root") == null) {
      val body = document.querySelector("body")
      val root = document.createElement("div")
      root.id = "root"
      body.appendChild(root)
    }
  }

  test("A simple page") {
    import HTML._

    def page() =
      div(id := "div")(
        h1(id := "h1")("Hello, world!"),
        p(id := "description", title := "These are attributes.")(
          "This page was rendered with the Domino library for Scala.js."),
        p(id := "enjoy")("Enjoy!"))

    val root = document.getElementById("root")
    root should not be null
    Domino.render(page(), root)

    document.getElementById("div") should not be null
    document.getElementById("h1") should not be null
    document.getElementById("description") should not be null
    document.getElementById("enjoy") should not be null
  }

  // TODO Add more assertions here.
  test("Adding and removing event handlers") {
    import HTML._

    var clicked = false

    def page(): DivElement =
      if (clicked) {
        div(
          h1("Hello, world!"),
          p(id := "description", title := "These are attributes.")(
            "This page was rendered with the Domino library for Scala.js."),
          p(onClick := ((_: MouseEvent) => {
            println("This is state 2.")
            clicked = false
            render()
          }))("Enjoy!"))
      } else
        div(
          h1("Hello, world!"),
          p(id := "description", title := "These are attributes.")(
            "This page was rendered with the Domino library for Scala.js."),
          p(onClick := ((_: MouseEvent) => {
            println("This is state 1.")
            clicked = true
            render()
          }))("Enjoy!"))

    def render(): Unit = {
      val root = document.getElementById("root")
      root should not be null
      Domino.render(page(), root)
    }

    render()
  }
}
