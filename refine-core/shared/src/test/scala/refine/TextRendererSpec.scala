package refine

class TextRendererSpec extends UnitSpec {
  "An HTML text renderer" should "render a paragraph element" in {
    import refine.html._
    val text = "Hello, world!"
    val source = p(text)
    val expected = s"<p>${EscapeHTML.element(text)}</p>"
    val result = source.renderToString
    result should be(expected)
  }

  it should "render an attribute" in {
    import refine.html._
    val source = p(id := "my-paragraph")("This is my paragraph.")
    val result = source.renderToString
    val expected = """<p id="my-paragraph">This is my paragraph.</p>"""
    result should be(expected)
  }

  it should "render a child element" in {
    import refine.html._
    val text = "I'm a child node."
    val source = div(p(text))
    val result = source.renderToString
    val expected = s"<div><p>${EscapeHTML.element(text)}</p></div>"
    result should be(expected)
  }

  it should "handle a data attribute" in {
    import refine.html._
    val source = div(data("my-data") := "good")()
    val result = source.renderToString
    result should be("""<div data-my-data="good"></div>""")
  }

  it should "render a component" in {
    import refine.html._

    case class Article(title: String, body: String) extends Component {
      override def render =
        div(
          h1(title),
          p(body))
    }

    val title = "Swiss university unveils yodeling degree"
    val body = "Yodellers in Switzerland have something to sing about after a " +
      "university revealed it will offer degrees in the alpine art-form."
    val readMore = "France demands UN protection for baguette"
    val source = div(Article(title, body), p(readMore))

    val expected =
      div(
        div(
          h1(title),
          p(body)),
        p(readMore))
        .renderToString

    val result = source.renderToString
    result should be(expected)
  }

  it should "properly handle boolean attributes" in {
    import refine.html._
    div(contenteditable := true)().renderToString should be(
      "<div contenteditable=\"true\"></div>")

    div(contenteditable := false)().renderToString should be(
      "<div contenteditable=\"false\"></div>")

    div(hidden := true)().renderToString should be(s"<div hidden></div>")
    div(hidden := false)().renderToString should be(s"<div></div>")
    div(spellcheck := true)().renderToString should be(
      "<div spellcheck=\"true\"></div>")

    div(spellcheck := false)().renderToString should be(
      "<div spellcheck=\"false\"></div>")
  }

  it should "render autocomplete as on-off" in {
    import html._

    input(autoComplete := true)().renderToString should be(
      "<input autocomplete=\"on\"></input>")

    input(autoComplete := false)().renderToString should be(
      "<input autocomplete=\"off\"></input>")
  }

  it should "render a doctype" in {
    import html._

    html().renderToString should be("<!DOCTYPE html><html></html>")
  }

  it should "render a meta charset tag" in {
    import html._

    meta(charset := "UTF-8")().renderToString should be("<meta charset=\"UTF-8\">")
  }

  it should "render an anchor link" in {
    import html._

    anchor(href := "/")("link").renderToString should be("<a href=\"/\">link</a>")
  }

  it should "render a cite" in {
    import html._

    cite(id := "test")("cite").renderToString should be("<cite id=\"test\">cite</cite>")
    blockquote(cite := "someone")("content").renderToString should be(
      "<blockquote cite=\"someone\">content</blockquote>")
  }
}
