package refine.dom

import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.{Element, document}
import org.scalatest._
import refine._

class RefineDOMTest extends FunSuite with Matchers with BeforeAndAfter {
  def root: Element = document.getElementById("root")

  before {
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
    RefineDOM.renderStatic[Unit](page, root)

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

    RefineDOM.renderStatic[Unit](input[Unit](required)(), root)
    root.firstChild.attributes.getNamedItem("required") should not be null
  }

  test("render autocomplete") {
    import DSL._

    RefineDOM.renderStatic[Unit](input[Unit](autoComplete(true))(), root)
    root.firstChild.attributes.getNamedItem("autocomplete").value should be("on")

    RefineDOM.renderStatic[Unit](input[Unit](autoComplete(false))(), root)
    root.firstChild.attributes.getNamedItem("autocomplete").value should be("off")
  }

  test("replace an element") {
    import DSL._

    val first = button()(p()(text("hello!")))
    val second = p()(text("hello!"))

    RefineDOM.renderStatic(first, root)
    root.firstChild.asInstanceOf[HTMLElement].tagName.toLowerCase should be("button")

    RefineDOM.renderStatic(second, root)
    root.firstChild.asInstanceOf[HTMLElement].tagName.toLowerCase should be("p")
  }

  test("remove a child") {
    import DSL._

    val first = div()(p()(text("hey!")))
    val second = div()()

    RefineDOM.renderStatic(first, root)
    root.firstChild.firstChild should not be null

    RefineDOM.renderStatic(second, root)
    root.firstChild.hasChildNodes() should be(false)
  }
}
