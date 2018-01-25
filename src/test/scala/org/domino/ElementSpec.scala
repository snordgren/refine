package org.domino

import org.domino.Domino._

class ElementSpec extends UnitSpec {
  "An element" should "be easy to construct" in {
    import Attribute._

    val source = html(lang := "en", manifest := "yes")(
      head()(
        title()("Welcome to Domino!")
      ),
      body()(
        h1()("Welcome to Domino!"),
        p(data("Why") := "")("")
      ))
  }
}
