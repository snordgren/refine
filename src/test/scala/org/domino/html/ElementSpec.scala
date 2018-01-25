package org.domino.html

import org.domino.UnitSpec

class ElementSpec extends UnitSpec {

  /**
   * The best way to start a test suite, ain't it?
   */
  "An element" should "be easy to construct" in {
    import HTML._

    val source =
      html(lang := "en", manifest := "yes")(
        head()(
          title(title := "no")("Welcome to Domino!")),
        body()(
          h1()("Welcome to Domino!"),
          p(data("home") := "where the heart is")("")))
  }
}
