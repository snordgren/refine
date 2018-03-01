package refine

class EscapeHTMLSpec extends UnitSpec {
  "HTML escaping" should "escape necessary characters" in {
    EscapeHTML.attribute("""&<>"'""") should be("&amp;&lt;&gt;&quot;&#39;")
    EscapeHTML.element("""&<>""") should be("&amp;&lt;&gt;")
  }
}
