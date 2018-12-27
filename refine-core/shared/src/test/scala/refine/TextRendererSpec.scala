package refine

class TextRendererSpec extends UnitSpec {
  "An HTML text renderer" should "render a paragraph element" in {
    import DSL._
    val source = p()(text("Hello, world!"))
    val expected = s"<p>Hello, world!</p>"
    val result = source.renderToString
    result should be(expected)
  }

  it should "render an attribute" in {
    import DSL._
    val source = p(id("my-paragraph"))(text("This is my paragraph."))
    val result = source.renderToString
    val expected = """<p id="my-paragraph">This is my paragraph.</p>"""
    result should be(expected)
  }

  it should "render a child element" in {
    import DSL._
    val str = "I'm a child node."
    val source = div()(p()(text(str)))
    val result = source.renderToString
    val expected = s"<div><p>$str</p></div>"
    result should be(expected)
  }

  it should "handle a data attribute" in {
    import DSL._
    val source = div(data("my-data", "good"))()
    val result = source.renderToString
    result should be("""<div data-my-data="good"></div>""")
  }

  it should "properly handle boolean attributes" in {
    import DSL._
    div(contenteditable(true))().renderToString should be(
      "<div contenteditable=\"true\"></div>")

    div(contenteditable(false))().renderToString should be(
      "<div contenteditable=\"false\"></div>")

    div(hidden)().renderToString should be("<div hidden=\"\"></div>")
    div(spellcheck(true))().renderToString should be(
      "<div spellcheck=\"true\"></div>")

    div(spellcheck(false))().renderToString should be(
      "<div spellcheck=\"false\"></div>")
  }

  it should "render autocomplete as on-off" in {
    import DSL._

    input(autoComplete(true))().renderToString should be(
      "<input autocomplete=\"on\"></input>")

    input(autoComplete(false))().renderToString should be(
      "<input autocomplete=\"off\"></input>")
  }

  it should "render a doctype" in {
    import DSL._

    html()().renderToString should be("<!DOCTYPE html><html></html>")
  }

  it should "render a meta charset tag" in {
    import DSL._

    meta(charset("UTF-8"))().renderToString should be("<meta charset=\"UTF-8\">")
  }

  it should "render an anchor link" in {
    import DSL._

    anchor(href("/"))(text("link")).renderToString should be("<a href=\"/\">link</a>")
  }

  it should "render a cite" in {
    import DSL._

    cite[Unit](id[Unit]("test"))(text("cite")).renderToString should be("<cite id=\"test\">cite</cite>")

    blockquote[Unit](cite("someone"))(text("content")).renderToString should be(
      "<blockquote cite=\"someone\">content</blockquote>")
  }

  it should "render the README example" in {
    import DSL._

    def render(userName: String) = div()(
      h1()(text(s"Hello, $userName!")),
      p(id("description"))(text("Welcome to Refine!"))
    ).renderToString

    val rendered = render("me")

    rendered should be({
      import DSL._

      div()(
        h1()(text("Hello, me!")),
        p(id("description"))(text("Welcome to Refine!"))
      ).renderToString
    })
  }

  it should "escape necessary characters" in {
    import DSL._

    val ast = p(id("""&<>"'"""))(text("""&<>"""))
    ast.renderToString should be("<p id=\"&amp;&lt;&gt;&quot;&#39;\">&amp;&lt;&gt;</p>")
  }
}
