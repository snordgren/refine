package domino

class ElementSpec extends UnitSpec {

  /**
   * The best way to start a test suite, ain't it?
   */
  "An element" should "be easy to construct" in {
    import domino.html._

    html(lang := "en", manifest := "yes")(
      head(
        title(title := "no")("Welcome to Domino!")),
      body(
        h1("Welcome to Domino!"),
        p(data("home") := "where the heart is")("")))
  }
}
