
package org.domino.html

sealed trait Node
case class Text(value: String) extends Node
sealed trait Element[A <: Attribute] extends Node {
  def name: String
  def attributes: Seq[A]
  def children: Seq[Node]
}

abstract class AbstractElement[A <: Attribute](val name: String) extends Element[A]


case class AnchorElement(attributes: Seq[AnchorAttribute],
  children: Seq[Node]) extends AbstractElement[AnchorAttribute]("a")

case class AbbrElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("abbr")

case class AddressElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("address")

case class AreaElement(attributes: Seq[AreaAttribute],
  children: Seq[Node]) extends AbstractElement[AreaAttribute]("area")

case class ArticleElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("article")

case class AsideElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("aside")

case class AudioElement(attributes: Seq[AudioAttribute],
  children: Seq[Node]) extends AbstractElement[AudioAttribute]("audio")

case class BElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("b")

case class BaseElement(attributes: Seq[BaseAttribute],
  children: Seq[Node]) extends AbstractElement[BaseAttribute]("base")

case class BDIElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("bdi")

case class BDOElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("bdo")

case class BlockQuoteElement(attributes: Seq[BlockQuoteAttribute],
  children: Seq[Node]) extends AbstractElement[BlockQuoteAttribute]("blockquote")

case class BodyElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("body")

case class BRElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("br")

case class ButtonElement(attributes: Seq[ButtonAttribute],
  children: Seq[Node]) extends AbstractElement[ButtonAttribute]("button")

case class CanvasElement(attributes: Seq[CanvasAttribute],
  children: Seq[Node]) extends AbstractElement[CanvasAttribute]("canvas")

case class CaptionElement(attributes: Seq[CaptionAttribute],
  children: Seq[Node]) extends AbstractElement[CaptionAttribute]("caption")

case class CiteElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("cite")

case class CodeElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("code")

case class ColElement(attributes: Seq[ColAttribute],
  children: Seq[Node]) extends AbstractElement[ColAttribute]("col")

case class ColGroupElement(attributes: Seq[ColGroupAttribute],
  children: Seq[Node]) extends AbstractElement[ColGroupAttribute]("colgroup")

case class DataListElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("datalist")

case class DDElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dd")

case class DelElement(attributes: Seq[DelAttribute],
  children: Seq[Node]) extends AbstractElement[DelAttribute]("del")

case class DetailsElement(attributes: Seq[DetailsAttribute],
  children: Seq[Node]) extends AbstractElement[DetailsAttribute]("details")

case class DFNElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dfn")

case class DialogElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dialog")

case class DivElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("div")

case class DLElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dl")

case class DTElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("dt")

case class EMElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("em")

case class EmbedElement(attributes: Seq[EmbedAttribute],
  children: Seq[Node]) extends AbstractElement[EmbedAttribute]("embed")

case class FieldSetElement(attributes: Seq[FieldSetAttribute],
  children: Seq[Node]) extends AbstractElement[FieldSetAttribute]("fieldset")

case class FigCaptionElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("figcaption")

case class FigureElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("figure")

case class FooterElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("footer")

case class FormElement(attributes: Seq[FormAttribute],
  children: Seq[Node]) extends AbstractElement[FormAttribute]("form")

case class H1Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h1")

case class H2Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h2")

case class H3Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h3")

case class H4Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h4")

case class H5Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h5")

case class H6Element(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("h6")

case class HeadElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("head")

case class HeaderElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("header")

case class HRElement(attributes: Seq[HRAttribute],
  children: Seq[Node]) extends AbstractElement[HRAttribute]("hr")

case class HTMLElement(attributes: Seq[HTMLAttribute],
  children: Seq[Node]) extends AbstractElement[HTMLAttribute]("html")

case class IElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("i")

case class IFrameElement(attributes: Seq[IFrameAttribute],
  children: Seq[Node]) extends AbstractElement[IFrameAttribute]("iframe")

case class ImageElement(attributes: Seq[ImageAttribute],
  children: Seq[Node]) extends AbstractElement[ImageAttribute]("img")

case class InputElement(attributes: Seq[InputAttribute],
  children: Seq[Node]) extends AbstractElement[InputAttribute]("input")

case class InsElement(attributes: Seq[InsAttribute],
  children: Seq[Node]) extends AbstractElement[InsAttribute]("ins")

case class KBDElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("kbd")

case class LabelElement(attributes: Seq[LabelAttribute],
  children: Seq[Node]) extends AbstractElement[LabelAttribute]("label")

case class LegendElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("legend")

case class LIElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("li")

case class LinkElement(attributes: Seq[LinkAttribute],
  children: Seq[Node]) extends AbstractElement[LinkAttribute]("link")

case class MainElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("main")

case class MapElement(attributes: Seq[MapAttribute],
  children: Seq[Node]) extends AbstractElement[MapAttribute]("map")

case class MarkElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("mark")

case class MetaElement(attributes: Seq[MetaAttribute],
  children: Seq[Node]) extends AbstractElement[MetaAttribute]("meta")

case class MeterElement(attributes: Seq[MeterAttribute],
  children: Seq[Node]) extends AbstractElement[MeterAttribute]("meter")

case class NavElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("nav")

case class NoScriptElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("noscript")

case class ObjectElement(attributes: Seq[ObjectAttribute],
  children: Seq[Node]) extends AbstractElement[ObjectAttribute]("`object`")

case class OLElement(attributes: Seq[OLAttribute],
  children: Seq[Node]) extends AbstractElement[OLAttribute]("ol")

case class OptGroupElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("optgroup")

case class OptionElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("option")

case class OutputElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("output")

case class ParagraphElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("p")

case class ParamElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("param")

case class PictureElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("picture")

case class PreElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("pre")

case class ProgressElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("progress")

case class QElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("q")

case class RPElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("rp")

case class RTElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("rt")

case class RubyElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("ruby")

case class SElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("s")

case class SampElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("samp")

case class ScriptElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("script")

case class SectionElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("section")

case class SelectElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("select")

case class SmallElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("small")

case class SourceElement(attributes: Seq[SourceAttribute],
  children: Seq[Node]) extends AbstractElement[SourceAttribute]("source")

case class SpanElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("span")

case class StrongElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("strong")

case class StyleElement(attributes: Seq[StyleAttribute],
  children: Seq[Node]) extends AbstractElement[StyleAttribute]("style")

case class SubElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("sub")

case class SummaryElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("summary")

case class SupElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("sup")

case class TableElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("table")

case class TBodyElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("tbody")

case class TDElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("td")

case class TemplateElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("template")

case class TextAreaElement(attributes: Seq[TextAreaAttribute],
  children: Seq[Node]) extends AbstractElement[TextAreaAttribute]("textarea")

case class TFootElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("tfoot")

case class THElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("th")

case class THeadElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("thead")

case class TimeElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("time")

case class TitleElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("title")

case class TRElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("tr")

case class TrackElement(attributes: Seq[TrackAttribute],
  children: Seq[Node]) extends AbstractElement[TrackAttribute]("track")

case class UElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("u")

case class ULElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("ul")

case class VarElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("`var`")

case class VideoElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("video")

case class WBRElement(attributes: Seq[GlobalAttribute],
  children: Seq[Node]) extends AbstractElement[GlobalAttribute]("wbr")