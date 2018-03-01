package refine

class ElementSpec extends UnitSpec {

  /**
   * The best way to start a test suite, ain't it?
   */
  "An element" should "be easy to construct" in {
    import refine.html._

    html(lang := "en", manifest := "yes")(
      head(
        title(title := "no")("Welcome to Refine!")),
      body(
        h1("Welcome to Refine!"),
        p(data("home") := "where the heart is")("")))
  }
}
