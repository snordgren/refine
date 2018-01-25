package org.domino

import org.domino.Domino._

class ElementSpec extends UnitSpec {
  "An element" should "be easy to construct" in {
    import Attribute._

    val source = html(lang := "en", manifest := "yes")(
      div(lang := "en")()
    )
  }
}
