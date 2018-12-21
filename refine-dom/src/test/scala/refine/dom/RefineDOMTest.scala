package refine.dom

import org.scalajs.dom.{Element, document}
import org.scalatest._
import refine._

import scala.scalajs.js

class RefineDOMTest extends FunSuite with Matchers with BeforeAndAfter {
  def root: Element = document.getElementById("root")

  before {
    if (document == null || js.isUndefined(document)) ???

    if (root == null) {
      val body = document.querySelector("body")
      val root = document.createElement("div")
      root.id = "root"
      body.appendChild(root)
    }
  }

  test("a simple page") {
    import DSL._

    val page: Node.Element[Unit] =
      div(id("div"))(
        h1(id("h1"))(text("Hello, world!")),
        p(id("description"), title("These are attributes."))(
          text("This page was rendered with the Refine library for Scala.js.")),
        p(id("enjoy"))(text("Enjoy!")))

    root should not be null
    RefineDOM.render[Unit]((_, _) => {}, page, root)

    document.getElementById("div") should not be null
    document.getElementById("h1") should not be null
    document.getElementById("description") should not be null
    document.getElementById("enjoy") should not be null
  }

  test("adding and removing event handlers") {
    import DSL._

    var upperClicks = 0
    var lowerClicks = 0

    def page(upper: Boolean): Node.Element[Int] =
      if (upper) div[Int]()(
        h1()(text("Hello, world!")),
        p(id("description"), title("These are attributes."))(
          text("This page was rendered with the Refine library for Scala.js.")),
        p(id("click-listener"), onClick(1))(text("Enjoy!")))
      else
        div[Int]()(
          h1()(text("Hello, world!")),
          p(id("description"), title("These are attributes."))(
            text("This page was rendered with the Refine library for Scala.js.")),
          p(id("click-listener"), onClick(0))(text("Enjoy!")))

    def render(upper: Boolean): Unit = {
      root should not be null
      RefineDOM.render[Int]((msg, _) => {
        if (msg == 1) upperClicks += 1
        if (msg == 0) lowerClicks += 1
      }, page(upper), root)
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


  test("render a required attribute") {
    import DSL._

    RefineDOM.render[Unit]((_, _) => (), input[Unit](required)(), root)
    root.firstChild.attributes.getNamedItem("required") should not be null
  }

  test("render autocomplete") {
    import DSL._

    RefineDOM.render[Unit]((_, _) => (), input[Unit](autoComplete(true))(), root)
    root.firstChild.attributes.getNamedItem("autocomplete").value should be("on")

    RefineDOM.render[Unit]((_, _) => (), input[Unit](autoComplete(false))(), root)
    root.firstChild.attributes.getNamedItem("autocomplete").value should be("off")
  }
}
