package refine.dom

import org.scalajs.dom.raw
import refine.{Component, Node}

import scala.scalajs.js

private[dom] object RenderComponent {
  private def isComponentDirty(c: Component, e: raw.Node): Boolean =
    if (js.isUndefined(e.asInstanceOf[js.Dynamic].previousRefineComp))
      true
    else {
      val prevComp = e.asInstanceOf[js.Dynamic].previousRefineComp
      val dynamicComp = c.asInstanceOf[js.Dynamic]
      !dynamicComp.equals(prevComp)
    }

  def apply(c: Component, e: raw.Node,
    render: (Node, raw.Node) => RenderResult): RenderResult = {
    val dynElement = e.asInstanceOf[js.Dynamic]

    val toReturn = if (isComponentDirty(c, e)) {
      if (js.isUndefined(dynElement.previousRefineComp)) {
        dynElement.refineRenderCount = 1
      } else {
        // This roundabout wrangling is supposed to increment the render count,
        // without upsetting the Scala.js compiler. The cast *should* be safe.
        val lastRenderCount = dynElement.refineRenderCount
        val newRenderCount = lastRenderCount + 1.asInstanceOf[js.Dynamic]
        dynElement.refineRenderCount = newRenderCount
      }
      render(c.render, e)
    } else RenderResult.Success

    dynElement.previousRefineComp = c.asInstanceOf[js.Dynamic]
    toReturn
  }
}
