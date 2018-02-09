package domino

class HTMLEscapeSpec extends UnitSpec {
  "HTML escaping" should "escape all necessary characters" in {
    val source = "&<>\"'`,!@$%()=+-{}[]/"
    val expected = "&amp;&lt;&gt;&quot;&#39;&#96;&#44;&#33;&#64;&#36;" +
      "&#37;&#40;&#41;&#61;&#43;&#45;&#123;&#125;&#91;&#93;&#47;"

    HTMLEscape(source) should be(expected)
  }
}
