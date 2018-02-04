package org.domino

class TextRendererSpec extends UnitSpec {
  "An HTML text renderer" should "render a paragraph element" in {
    import HTML._
    val text = "Hello, world!"
    val source = p(text)
    val expected = s"<p>${HTMLEscape(text)}</p>"
    val result = source.renderToString()
    result should be(expected)
  }

  it should "render an attribute" in {
    import HTML._
    val source = p(id := "my-paragraph")("This is my paragraph.")
    val result = source.renderToString()
    val expected = """<p id="my-paragraph">This is my paragraph.</p>"""
    result should be(expected)
  }

  it should "render a child element" in {
    import HTML._
    val text = "I'm a child node."
    val source = div(p(text))
    val result = source.renderToString()
    val expected = s"<div><p>${HTMLEscape(text)}</p></div>"
    result should be(expected)
  }

  it should "handle a data attribute" in {
    import HTML._
    val source = div(data("my-data") := "good")()
    val result = source.renderToString()
    result should be("""<div data-my-data="good"></div>""")
  }

  it should "render a component" in {
    import HTML._

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
        .renderToString()

    val result = source.renderToString()
    result should be(expected)
  }
  
  it should "properly handle boolean attributes" in {
    import HTML._
    div(contenteditable := true)().renderToString() should be("<div contenteditable=\"true\"></div>")
    div(contenteditable := false)().renderToString() should be("<div contenteditable=\"false\"></div>")
    div(hidden := true)().renderToString() should be(s"<div hidden></div>")
    div(hidden := false)().renderToString() should be(s"<div ></div>")
    div(spellcheck := true)().renderToString() should be("<div spellcheck=\"true\"></div>")
    div(spellcheck := false)().renderToString() should be("<div spellcheck=\"false\"></div>")
  }
}
