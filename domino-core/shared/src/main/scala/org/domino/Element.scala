package org.domino

sealed trait Node {
  private[domino] def acceptStringBuilder(builder: StringBuilder): Unit

  final def renderToString(): String = {
    val builder = new StringBuilder()
    acceptStringBuilder(builder)
    builder.toString()
  }
}

final case class Text(value: String) extends Node {
  private[domino] override def acceptStringBuilder(builder: StringBuilder): Unit =
    builder.append(HTMLEscape(value))
}

trait Component extends Node {
  def render: Node

  private[domino] final override def acceptStringBuilder(builder: StringBuilder): Unit =
    render.acceptStringBuilder(builder)
}

sealed trait Element[A <: Attribute] extends Node {
  def name: String
  def attributes: Seq[A]
  def children: Seq[Node]

  def nonErasedAttr: Seq[Attribute] = attributes

  private[domino] final override def acceptStringBuilder(builder: StringBuilder): Unit = {
    builder.append('<')
    builder.append(name)

    if (this.nonErasedAttr.nonEmpty) {
      val attributes = this.nonErasedAttr
      var index = 0

      while (index < attributes.length) {
        builder.append(' ')
        builder.append(attributes(index).renderToString())
        index += 1
      }
    }

    builder.append('>')

    if (this.children.nonEmpty) {
      var index = 0
      while (index < children.length) {
        builder.append(children(index).renderToString())
        index += 1
      }
    }

    builder.append("</")
    builder.append(name)
    builder.append('>')
    builder.toString()
  }
}

abstract class AbstractElement[A <: Attribute](val name: String) extends Element[A]

final case class AnchorElement(attributes: Seq[AnchorAttribute],
  children: Seq[Node]) extends AbstractElement[AnchorAttribute]("a")

final case class AbbrElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("abbr")

final case class AddressElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("address")

final case class AreaElement(attributes: Seq[AreaAttribute],
  children: Seq[Node]) extends AbstractElement[AreaAttribute]("area")

final case class ArticleElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("article")

final case class AsideElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("aside")

final case class AudioElement(attributes: Seq[AudioAttribute],
  children: Seq[Node]) extends AbstractElement[AudioAttribute]("audio")

final case class BElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("b")

final case class BaseElement(attributes: Seq[BaseAttribute],
  children: Seq[Node]) extends AbstractElement[BaseAttribute]("base")

final case class BDIElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("bdi")

final case class BDOElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("bdo")

final case class BlockQuoteElement(attributes: Seq[BlockQuoteAttribute],
  children: Seq[Node]) extends AbstractElement[BlockQuoteAttribute]("blockquote")

final case class BodyElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("body")

final case class BRElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("br")

final case class ButtonElement(attributes: Seq[ButtonAttribute],
  children: Seq[Node]) extends AbstractElement[ButtonAttribute]("button")

final case class CanvasElement(attributes: Seq[CanvasAttribute],
  children: Seq[Node]) extends AbstractElement[CanvasAttribute]("canvas")

final case class CaptionElement(attributes: Seq[CaptionAttribute],
  children: Seq[Node]) extends AbstractElement[CaptionAttribute]("caption")

final case class CiteElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("cite")

final case class CodeElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("code")

final case class ColElement(attributes: Seq[ColAttribute],
  children: Seq[Node]) extends AbstractElement[ColAttribute]("col")

final case class ColGroupElement(attributes: Seq[ColGroupAttribute],
  children: Seq[Node]) extends AbstractElement[ColGroupAttribute]("colgroup")

final case class DataListElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("datalist")

final case class DDElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dd")

final case class DelElement(attributes: Seq[DelAttribute],
  children: Seq[Node]) extends AbstractElement[DelAttribute]("del")

final case class DetailsElement(attributes: Seq[DetailsAttribute],
  children: Seq[Node]) extends AbstractElement[DetailsAttribute]("details")

final case class DFNElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dfn")

final case class DialogElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dialog")

final case class DivElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("div")

final case class DLElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dl")

final case class DTElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dt")

final case class EMElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("em")

final case class EmbedElement(attributes: Seq[EmbedAttribute],
  children: Seq[Node]) extends AbstractElement[EmbedAttribute]("embed")

final case class FieldSetElement(attributes: Seq[FieldSetAttribute],
  children: Seq[Node]) extends AbstractElement[FieldSetAttribute]("fieldset")

final case class FigCaptionElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("figcaption")

final case class FigureElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("figure")

final case class FooterElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("footer")

final case class FormElement(attributes: Seq[FormAttribute],
  children: Seq[Node]) extends AbstractElement[FormAttribute]("form")

final case class H1Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h1")

final case class H2Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h2")

final case class H3Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h3")

final case class H4Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h4")

final case class H5Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h5")

final case class H6Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h6")

final case class HeadElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("head")

final case class HeaderElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("header")

final case class HRElement(attributes: Seq[HRAttribute],
  children: Seq[Node]) extends AbstractElement[HRAttribute]("hr")

final case class HTMLElement(attributes: Seq[HTMLAttribute],
  children: Seq[Node]) extends AbstractElement[HTMLAttribute]("html")

final case class IElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("i")

final case class IFrameElement(attributes: Seq[IFrameAttribute],
  children: Seq[Node]) extends AbstractElement[IFrameAttribute]("iframe")

final case class ImageElement(attributes: Seq[ImageAttribute],
  children: Seq[Node]) extends AbstractElement[ImageAttribute]("img")

final case class InputElement(attributes: Seq[InputAttribute],
  children: Seq[Node]) extends AbstractElement[InputAttribute]("input")

final case class InsElement(attributes: Seq[InsAttribute],
  children: Seq[Node]) extends AbstractElement[InsAttribute]("ins")

final case class KBDElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("kbd")

final case class LabelElement(attributes: Seq[LabelAttribute],
  children: Seq[Node]) extends AbstractElement[LabelAttribute]("label")

final case class LegendElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("legend")

final case class LIElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("li")

final case class LinkElement(attributes: Seq[LinkAttribute],
  children: Seq[Node]) extends AbstractElement[LinkAttribute]("link")

final case class MainElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("main")

final case class MapElement(attributes: Seq[MapAttribute],
  children: Seq[Node]) extends AbstractElement[MapAttribute]("map")

final case class MarkElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("mark")

final case class MetaElement(attributes: Seq[MetaAttribute],
  children: Seq[Node]) extends AbstractElement[MetaAttribute]("meta")

final case class MeterElement(attributes: Seq[MeterAttribute],
  children: Seq[Node]) extends AbstractElement[MeterAttribute]("meter")

final case class NavElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("nav")

final case class NoScriptElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("noscript")

final case class ObjectElement(attributes: Seq[ObjectAttribute],
  children: Seq[Node]) extends AbstractElement[ObjectAttribute]("`object`")

final case class OLElement(attributes: Seq[OLAttribute],
  children: Seq[Node]) extends AbstractElement[OLAttribute]("ol")

final case class OptGroupElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("optgroup")

final case class OptionElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("option")

final case class OutputElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("output")

final case class ParagraphElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("p")

final case class ParamElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("param")

final case class PictureElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("picture")

final case class PreElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("pre")

final case class ProgressElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("progress")

final case class QElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("q")

final case class RPElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("rp")

final case class RTElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("rt")

final case class RubyElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("ruby")

final case class SElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("s")

final case class SampElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("samp")

final case class ScriptElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("script")

final case class SectionElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("section")

final case class SelectElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("select")

final case class SmallElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("small")

final case class SourceElement(attributes: Seq[SourceAttribute],
  children: Seq[Node]) extends AbstractElement[SourceAttribute]("source")

final case class SpanElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("span")

final case class StrongElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("strong")

final case class StyleElement(attributes: Seq[StyleAttribute],
  children: Seq[Node]) extends AbstractElement[StyleAttribute]("style")

final case class SubElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("sub")

final case class SummaryElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("summary")

final case class SupElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("sup")

final case class TableElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("table")

final case class TBodyElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("tbody")

final case class TDElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("td")

final case class TemplateElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("template")

final case class TextAreaElement(attributes: Seq[TextAreaAttribute],
  children: Seq[Node]) extends AbstractElement[TextAreaAttribute]("textarea")

final case class TFootElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("tfoot")

final case class THElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("th")

final case class THeadElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("thead")

final case class TimeElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("time")

final case class TitleElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("title")

final case class TRElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("tr")

final case class TrackElement(attributes: Seq[TrackAttribute],
  children: Seq[Node]) extends AbstractElement[TrackAttribute]("track")

final case class UElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("u")

final case class ULElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("ul")

final case class VarElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("`var`")

final case class VideoElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("video")

final case class WBRElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("wbr")