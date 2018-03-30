package refine

trait HTML extends Elements with Attributes with Conversions {

  lazy val cite = OverloadedFactory(CiteElement, Attribute.Cite)
  lazy val form = OverloadedFactory(FormElement, Attribute.Form)
  lazy val label = OverloadedFactory(LabelElement, Attribute.Label)
  lazy val span = OverloadedFactory(SpanElement, Attribute.Span)
  lazy val style = OverloadedFactory(StyleElement, Attribute.Style)
  lazy val summary = OverloadedFactory(SummaryElement, Attribute.Summary)
  lazy val title = OverloadedFactory(TitleElement, Attribute.Title)

}


/**
 * The HTML object aggregates the factories for elements and attributes. It also
 * provides implicit conversions from objects into nodes.
 *
 * Import the members of this object in functions that are intended to return an
 * HTML tree. Do not import it as a top-level import as that may lead to namespace
 * collisions.
 */
object HTML extends HTML
