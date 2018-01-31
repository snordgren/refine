package org.domino.dom

import org.scalajs.dom.document
import org.scalajs.dom.raw.MouseEvent
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class DominoDOMTest extends FunSuite with Matchers with BeforeAndAfter {
  before {
    if (document.getElementById("root") == null) {
      val body = document.querySelector("body")
      val root = document.createElement("div")
      root.id = "root"
      body.appendChild(root)
    }
  }

  test("A simple page") {
    import org.domino.HTML._

    def page() =
      div(id := "div")(
        h1(id := "h1")("Hello, world!"),
        p(id := "description", title := "These are attributes.")(
          "This page was rendered with the Domino library for Scala.js."),
        p(id := "enjoy")("Enjoy!"))

    val root = document.getElementById("root")
    root should not be null
    DominoDOM.render(page(), root)

    document.getElementById("div") should not be null
    document.getElementById("h1") should not be null
    document.getElementById("description") should not be null
    document.getElementById("enjoy") should not be null
  }

  // TODO Add more assertions here.
  test("Adding and removing event handlers") {
    import Events._
    import org.domino.HTML._

    var upperClicks = 0
    var lowerClicks = 0

    def page(upper: Boolean) =
      if (upper) {
        div(
          h1("Hello, world!"),
          p(id := "description", title := "These are attributes.")(
            "This page was rendered with the Domino library for Scala.js."),
          p(id := "click-listener",
            onClick := ((_: MouseEvent) => {
              upperClicks += 1
            }))("Enjoy!"))
      } else
        div(
          h1("Hello, world!"),
          p(id := "description", title := "These are attributes.")(
            "This page was rendered with the Domino library for Scala.js."),
          p(id := "click-listener",
            onClick := ((_: MouseEvent) => {
              lowerClicks += 1
            }))("Enjoy!"))

    def render(upper: Boolean): Unit = {
      val root = document.getElementById("root")
      root should not be null
      DominoDOM.render(page(upper), root)
    }

    def click(): Unit = {
      val p = document.getElementById("click-listener")
      val event = document.createEvent("HTMLEvents")
      event.initEvent("click", canBubbleArg = false, cancelableArg = true)
      p.dispatchEvent(event)
    }

    render(false)
    click()
    lowerClicks should be(1)
    upperClicks should be(0)
    render(true)
    click()
    // if the event handlers work as they should, each side should have received
    // only one click.
    lowerClicks should be(1)
    upperClicks should be(1)
  }
}
