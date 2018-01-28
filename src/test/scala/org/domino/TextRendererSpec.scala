package org.domino

class TextRendererSpec extends UnitSpec {
  "An HTML text renderer" should "render a paragraph element" in {
    import org.domino.html.HTML._
    val source = p("Hello, world!")
    val result = TextRenderer(source)
    result should be("<p>Hello, world!</p>")
  }

  it should "render an attribute" in {
    import org.domino.html.HTML._
    val source = p(id := "my-paragraph")("This is my paragraph.")
    val result = TextRenderer(source)
    val expected = """<p id="#my-paragraph">This is my paragraph.</p>"""
    result should be(expected)
  }

  it should "render a child element" in {
    import org.domino.html.HTML._
    val source = div(p("I'm a child node."))
    val result = TextRenderer(source)
    result should be("""<div><p>I'm a child node.</p></div>""")
  }

  it should "handle a data attribute" in {
    import org.domino.html.HTML._
    val source = div(data("my-data") := "good")()
    val result = TextRenderer(source)
    result should be("""<div data-my-data="good"></div>""")
  }
}
