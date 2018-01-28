# Domino

Domino is a Scala.js library for declarative HTML rendering using a virtual DOM.
It is a minimal alternative to React for Scala.js, with the added benefit of
type safety.

## Example

```scala
package org.domino

import org.domino.html.HTML
import org.scalajs.dom.document

object App {
  import HTML._

  def page() =
    div(
      h1("Hello, world!"),
      p(id := "description", title := "These are attributes.")(
        "This page was rendered with the Domino library for Scala.js."),
      p("Enjoy!"))

  def main(args: Array[String]): Unit = {
    val root = document.getElementById("root")
    Domino.render(page(), root)
  }
}
```
