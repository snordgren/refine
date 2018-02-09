package domino.dom

import domino.{Component, Node}
import org.scalajs.dom.document

/**
 * A styled component appends its style to the head of the HTML document. Use
 * a unique and constant style name, as it is used by Domino to keep track of
 * which styles have already been added.
 *
 * @param styleName The name of this styled component.
 */
abstract class StyledComponent(styleName: String) extends Component {
  final override def render = {
    val styleId = s"style-$styleName"
    val fetched = document.getElementById(styleId)
    if (scalajs.js.isUndefined(fetched) || fetched == null) {
      val head = document.querySelector("head")
      val css = document.createElement("style")
      css.id = styleId
      css.textContent = style
      head.appendChild(css)
    }

    renderStyled
  }

  def renderStyled: Node

  /**
   * The style of this component. This value should be constant, as Domino will not
   * update the style after it has been added to the document.
   *
   * @return
   */
  def style: String
}
