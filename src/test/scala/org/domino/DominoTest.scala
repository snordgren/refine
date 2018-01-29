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
          p(id := "click-listener",
            onClick := ((_: MouseEvent) => {
              clicked = false
            }))("Enjoy!"))
      } else
        div(
          h1("Hello, world!"),
          p(id := "description", title := "These are attributes.")(
            "This page was rendered with the Domino library for Scala.js."),
          p(id := "click-listener",
            onClick := ((_: MouseEvent) => {
              clicked = true
            }))("Enjoy!"))

    def render(): Unit = {
      val root = document.getElementById("root")
      root should not be null
      Domino.render(page(), root)
    }

    def click(): Unit = {
      val p = document.getElementById("click-listener")
      val event = document.createEvent("HTMLEvents")
      event.initEvent("click", canBubbleArg = false, cancelableArg = true)
      p.dispatchEvent(event)
    }

    clicked should be(false)
    render()
    click()
    clicked should be(true)
    render()
    click()
    clicked should be(false)
  }
}
