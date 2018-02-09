package domino.dom

import domino.{Component, Node}
import org.scalajs.dom.raw

import scala.scalajs.js

private[dom] object VirtualDOM {
  private def isComponentDirty(c: Component, e: raw.Node): Boolean =
    if (js.isUndefined(e.asInstanceOf[js.Dynamic].previousDominoComp))
      true
    else {
      val prevComp = e.asInstanceOf[js.Dynamic].previousDominoComp
      val dynamicComp = c.asInstanceOf[js.Dynamic]
      !dynamicComp.equals(prevComp)
    }

  def renderComponent(c: Component, e: raw.Node,
    render: (Node, raw.Node) => Either[String, Unit]): Either[String, Unit] = {
    val dynElement = e.asInstanceOf[js.Dynamic]

    val toReturn = if (isComponentDirty(c, e)) {
      if (js.isUndefined(dynElement.previousDominoComp)) {
        dynElement.dominoRenderCount = 1
      } else {
        // This roundabout wrangling is supposed to increment the render count,
        // without upsetting the Scala.js compiler. The cast *should* be safe.
        val lastRenderCount = dynElement.dominoRenderCount
        val newRenderCount = lastRenderCount + 1.asInstanceOf[js.Dynamic]
        dynElement.dominoRenderCount = newRenderCount
      }
      render(c.render, e)
    } else Right()

    dynElement.previousDominoComp = c.asInstanceOf[js.Dynamic]
    toReturn
  }
}
