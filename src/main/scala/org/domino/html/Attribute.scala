package org.domino.html

import org.scalajs.dom.raw.{DragEvent, Event, FocusEvent, KeyboardEvent, MouseEvent, UIEvent, WheelEvent}

sealed trait Attribute {
  val name: String

  def render: String
}

/**
 * Most attributes have no special behavior, and only need a name and a value that
 * can be transformed into a string (any object).
 */
sealed abstract class SimpleAttribute[T](val name: String) extends Attribute {
  val value: T

  override def render =
    name + "=\"" + value + "\""
}

sealed abstract class EventAttribute[T](val name: String) extends GlobalAttribute {
  val f: (T => _)

  override def render =
    name + "=\"" + f.toString() + "\""
}

sealed trait AnchorAttribute extends Attribute

sealed trait AreaAttribute extends Attribute

sealed trait AudioAttribute extends Attribute

sealed trait BaseAttribute extends Attribute

sealed trait BlockQuoteAttribute extends Attribute

sealed trait ButtonAttribute extends Attribute

sealed trait CanvasAttribute extends Attribute

sealed trait CaptionAttribute extends Attribute

sealed trait ColAttribute extends Attribute

sealed trait ColGroupAttribute extends Attribute

sealed trait CommandAttribute extends Attribute

sealed trait DelAttribute extends Attribute

sealed trait DetailsAttribute extends Attribute

sealed trait EmbedAttribute extends Attribute

sealed trait FieldSetAttribute extends Attribute

sealed trait FormAttribute extends Attribute

sealed trait HRAttribute extends Attribute

sealed trait HTMLAttribute extends Attribute

sealed trait IFrameAttribute extends Attribute

sealed trait ImageAttribute extends Attribute

sealed trait InputAttribute extends Attribute

sealed trait InsAttribute extends Attribute

sealed trait LabelAttribute extends Attribute

sealed trait LinkAttribute extends Attribute

sealed trait LIAttribute extends Attribute

sealed trait MapAttribute extends Attribute

sealed trait MetaAttribute extends Attribute

sealed trait MeterAttribute extends Attribute

sealed trait ObjectAttribute extends Attribute

sealed trait OLAttribute extends Attribute

sealed trait OptGroupAttribute extends Attribute

sealed trait OptionAttribute extends Attribute

sealed trait OutputAttribute extends Attribute

sealed trait ParamAttribute extends Attribute

sealed trait ProgressAttribute extends Attribute

sealed trait QAttribute extends Attribute

sealed trait ScriptAttribute extends Attribute

sealed trait SelectAttribute extends Attribute

sealed trait SourceAttribute extends Attribute

sealed trait StyleAttribute extends Attribute

sealed trait TableAttribute extends Attribute

sealed trait TBodyAttribute extends Attribute

sealed trait TDAttribute extends Attribute

sealed trait TextAreaAttribute extends Attribute

sealed trait TFootAttribute extends Attribute

sealed trait THAttribute extends Attribute

sealed trait THeadAttribute extends Attribute

sealed trait TimeAttribute extends Attribute

sealed trait TRAttribute extends Attribute

sealed trait TrackAttribute extends Attribute

sealed trait VideoAttribute extends Attribute

/**
 * The bottom type, a subtype of any potential type of attribute. This means that
 * attributes that are defined as instances of this trait are applicable to any
 * kind of element.
 */
sealed trait GlobalAttribute extends Attribute
  with AnchorAttribute
  with AreaAttribute
  with AudioAttribute
  with BlockQuoteAttribute
  with ButtonAttribute
  with CanvasAttribute
  with CaptionAttribute
  with ColAttribute
  with ColGroupAttribute
  with CommandAttribute
  with DelAttribute
  with DetailsAttribute
  with EmbedAttribute
  with FieldSetAttribute
  with FormAttribute
  with HRAttribute
  with HTMLAttribute
  with IFrameAttribute
  with ImageAttribute
  with InputAttribute
  with InsAttribute
  with LabelAttribute
  with LinkAttribute
  with LIAttribute
  with MapAttribute
  with MetaAttribute
  with MeterAttribute
  with ObjectAttribute
  with OLAttribute
  with OptGroupAttribute
  with OptionAttribute
  with OutputAttribute
  with ParamAttribute
  with ProgressAttribute
  with QAttribute
  with ScriptAttribute
  with SelectAttribute
  with SourceAttribute
  with StyleAttribute
  with TableAttribute
  with TBodyAttribute
  with TDAttribute
  with TextAreaAttribute
  with TFootAttribute
  with THAttribute
  with THeadAttribute
  with TimeAttribute
  with TRAttribute
  with TrackAttribute
  with VideoAttribute

object Attribute {

  final case class Accept(value: String) extends SimpleAttribute[String]("accept")
    with FormAttribute
    with InputAttribute

  final case class AcceptCharset(value: String) extends SimpleAttribute[String]("accept-charset")
    with FormAttribute

  final case class AccessKey(value: String) extends SimpleAttribute[String]("accesskey")
    with GlobalAttribute

  final case class Action(value: String) extends SimpleAttribute[String]("action")
    with FormAttribute

  final case class Align(value: String) extends SimpleAttribute[String]("align")
    with CaptionAttribute
    with ColAttribute
    with ColGroupAttribute
    with HRAttribute
    with IFrameAttribute
    with ImageAttribute
    with TableAttribute
    with TBodyAttribute
    with TDAttribute
    with TFootAttribute
    with THAttribute
    with THeadAttribute
    with TRAttribute

  final case class Alternative(value: String) extends SimpleAttribute[String]("alt")
    with AreaAttribute
    with ImageAttribute
    with InputAttribute

  final case class Async(value: Boolean) extends SimpleAttribute[Boolean]("async")
    with ScriptAttribute

  final case class AutoComplete(value: Boolean) extends SimpleAttribute[Boolean]("autocomplete")
    with FormAttribute
    with InputAttribute

  final case class AutoFocus(value: Boolean) extends SimpleAttribute[Boolean]("autofocus")
    with ButtonAttribute
    with InputAttribute
    with SelectAttribute
    with TextAreaAttribute

  final case class AutoPlay(value: Boolean) extends SimpleAttribute[Boolean]("autoplay")
    with AudioAttribute
    with VideoAttribute

  final case class Buffered(value: String) extends SimpleAttribute[String]("buffered")
    with AudioAttribute
    with VideoAttribute

  final case class Charset(value: String) extends SimpleAttribute[String]("charset")
    with MetaAttribute

  final case class Checked(value: String) extends SimpleAttribute[String]("checked")
    with CommandAttribute
    with InputAttribute

  final case class Cite(value: String) extends SimpleAttribute[String]("cite")
    with BlockQuoteAttribute
    with DelAttribute
    with InsAttribute
    with QAttribute

  final case class ClassName(value: String) extends SimpleAttribute[String]("class")
    with GlobalAttribute

  final case class Cols(value: String) extends SimpleAttribute[String]("cols")
    with TextAreaAttribute

  final case class ColSpan(value: String) extends SimpleAttribute[String]("colspan")
    with TDAttribute
    with THAttribute

  final case class Content(value: String) extends SimpleAttribute[String]("content")
    with MetaAttribute

  final case class ContentEditable(value: String) extends SimpleAttribute[String]("contenteditable")
    with GlobalAttribute

  final case class Controls(value: String) extends SimpleAttribute[String]("controls")
    with AudioAttribute
    with VideoAttribute

  final case class CrossOrigin(value: String) extends SimpleAttribute[String]("crossorigin")
    with AudioAttribute
    with ImageAttribute
    with LinkAttribute
    with ScriptAttribute
    with VideoAttribute

  final case class Data(value: String) extends SimpleAttribute[String]("data")
    with ObjectAttribute

  /**
   * The CustomData attribute type represents a custom data attribute on an element. Because it
   * requires special handling, it cannot be a subclass of SimpleAttribute.
   *
   * @param name The name of the data, without the <code>data-</code> prefix.
   * @param value The value of the data.
   */
  final case class CustomData(name: String, value: String) extends GlobalAttribute {
    override def render =
      "data-" + name + "=\"" + value + "\""
  }

  final case class DateTime(value: String) extends SimpleAttribute[String]("datetime")
    with DelAttribute
    with InsAttribute
    with TimeAttribute

  final case class Default(value: String) extends SimpleAttribute[String]("default")
    with TrackAttribute

  final case class Defer(value: String) extends SimpleAttribute[String]("defer")
    with ScriptAttribute

  // TODO Add custom data type to represent the limited set of values.
  final case class Dir(value: String) extends SimpleAttribute[String]("dir")
    with GlobalAttribute

  final case class DirName(value: String) extends SimpleAttribute[String]("dirname")
    with InputAttribute with TextAreaAttribute

  final case class Disabled(value: Boolean) extends SimpleAttribute[Boolean]("disabled")
    with ButtonAttribute
    with CommandAttribute
    with FieldSetAttribute
    with InputAttribute
    with OptGroupAttribute
    with OptionAttribute
    with SelectAttribute
    with TextAreaAttribute

  final case class Download(value: String) extends SimpleAttribute[String]("download")
    with AnchorAttribute with AreaAttribute

  final case class Draggable(value: Boolean) extends SimpleAttribute[Boolean]("draggable")
    with GlobalAttribute

  final case class DropZone(value: String) extends SimpleAttribute[String]("dropzone")
    with GlobalAttribute

  final case class EncodingType(value: String) extends SimpleAttribute[String]("enctype")
    with FormAttribute

  final case class For(value: String) extends SimpleAttribute[String]("for")
    with LabelAttribute with OutputAttribute

  final case class Form(value: String) extends SimpleAttribute[String]("form")
    with ButtonAttribute
    with FieldSetAttribute
    with InputAttribute
    with LabelAttribute
    with MeterAttribute
    with ObjectAttribute
    with OutputAttribute
    with ProgressAttribute
    with SelectAttribute
    with TextAreaAttribute

  final case class FormAction(value: String) extends SimpleAttribute[String]("formaction")
    with InputAttribute with ButtonAttribute

  final case class Headers(value: String) extends SimpleAttribute[String]("headers")
    with TDAttribute with THAttribute

  final case class Height(value: String) extends SimpleAttribute[String]("height")
    with CanvasAttribute
    with EmbedAttribute
    with IFrameAttribute
    with ImageAttribute
    with InputAttribute
    with ObjectAttribute
    with VideoAttribute

  final case class Hidden(value: Boolean) extends SimpleAttribute[Boolean]("hidden")
    with GlobalAttribute

  final case class High(value: String) extends SimpleAttribute[String]("high")
    with MeterAttribute

  final case class Href(value: String) extends SimpleAttribute[String]("href")
    with AnchorAttribute
    with AreaAttribute
    with BaseAttribute
    with LinkAttribute

  final case class HrefLanguage(value: String) extends SimpleAttribute[String]("hreflang")
    with AnchorAttribute
    with AreaAttribute
    with LinkAttribute

  final case class HTTPEquiv(value: String) extends SimpleAttribute[String]("http-equiv")
    with MetaAttribute

  final case class Id(value: String) extends GlobalAttribute {
    val name = s"#$value"

    override def render =
      "id=\"#" + value + "\""
  }

  final case class Integrity(value: String) extends SimpleAttribute[String]("integrity")
    with LinkAttribute with ScriptAttribute

  final case class IsMap(value: Boolean) extends SimpleAttribute[Boolean]("ismap")
    with ImageAttribute

  final case class ItemProp(value: String) extends SimpleAttribute[String]("itemprop")
    with GlobalAttribute

  final case class Kind(value: String) extends SimpleAttribute[String]("kind")
    with TrackAttribute

  final case class Label(value: String) extends SimpleAttribute[String]("label")
    with TrackAttribute

  final case class Language(value: String) extends SimpleAttribute[String]("lang")
    with GlobalAttribute

  final case class ScriptingLanguage(value: String) extends SimpleAttribute[String]("language")
    with ScriptAttribute

  final case class List(value: String) extends SimpleAttribute[String]("list")
    with InputAttribute

  final case class Loop(value: String) extends SimpleAttribute[String]("loop")
    with AudioAttribute with VideoAttribute

  final case class Low(value: String) extends SimpleAttribute[String]("low")
    with MeterAttribute

  final case class Manifest(value: String) extends SimpleAttribute[String]("manifest")
    with HTMLAttribute

  final case class Max(value: String) extends SimpleAttribute[String]("max")
    with InputAttribute
    with MeterAttribute
    with ProgressAttribute

  final case class MaxLength(value: String) extends SimpleAttribute[String]("maxlength")
    with InputAttribute with TextAreaAttribute

  final case class MinLength(value: String) extends SimpleAttribute[String]("minlength")
    with InputAttribute with TextAreaAttribute

  final case class Media(value: String) extends SimpleAttribute[String]("media")
    with AnchorAttribute
    with AreaAttribute
    with LinkAttribute
    with SourceAttribute

  final case class Method(value: String) extends SimpleAttribute[String]("method")
    with FormAttribute

  final case class Min(value: String) extends SimpleAttribute[String]("min")
    with InputAttribute with MeterAttribute

  final case class Multiple(value: String) extends SimpleAttribute[String]("multiple")
    with InputAttribute with SelectAttribute

  final case class Muted(value: String) extends SimpleAttribute[String]("muted")
    with AudioAttribute with VideoAttribute

  final case class Name(value: String) extends SimpleAttribute[String]("name")
    with ButtonAttribute
    with FormAttribute
    with FieldSetAttribute
    with IFrameAttribute
    with InputAttribute
    with MapAttribute
    with MetaAttribute
    with ObjectAttribute
    with OutputAttribute
    with ParamAttribute
    with SelectAttribute
    with TextAreaAttribute

  final case class NoValidate(value: String) extends SimpleAttribute[String]("novalidate")
    with FormAttribute

  final case class OnAbort(f: UIEvent => _) extends EventAttribute[UIEvent]("abort")

  final case class OnActivate(f: UIEvent => _) extends EventAttribute[UIEvent]("activate")

  final case class OnBeforeCut(f: DragEvent => _) extends EventAttribute[DragEvent]("beforecut")

  final case class OnBeforeActivate(f: UIEvent => _) extends EventAttribute[UIEvent]("beforeactivate")

  final case class OnBeforeDeactivate(f: UIEvent => _) extends EventAttribute[UIEvent]("beforedeactivate")

  final case class OnBeforeCopy(f: DragEvent => _) extends EventAttribute[DragEvent]("beforecopy")

  final case class OnBeforePaste(f: DragEvent => _) extends EventAttribute[DragEvent]("beforepaste")

  final case class OnBlur(f: FocusEvent => _) extends EventAttribute[FocusEvent]("blur")

  final case class OnCanPlay(f: Event => _) extends EventAttribute[Event]("canplay")

  final case class OnCanPlayThrough(f: Event => _) extends EventAttribute[Event]("canplaythrough")

  final case class OnChange(f: Event => _) extends EventAttribute[Event]("change")

  final case class OnClick(f: MouseEvent => _) extends EventAttribute[MouseEvent]("click")

  final case class OnContextMenu(f: MouseEvent => _) extends EventAttribute[MouseEvent]("contextmenu")

  final case class OnCueChange(f: Event => _) extends EventAttribute[Event]("cuechange")

  final case class OnDeactivate(f: UIEvent => _) extends EventAttribute[UIEvent]("deactivate")

  final case class OnDoubleClick(f: MouseEvent => _) extends EventAttribute[MouseEvent]("dblclick")

  final case class OnDrag(f: DragEvent => _) extends EventAttribute[DragEvent]("drag")

  final case class OnDragEnd(f: DragEvent => _) extends EventAttribute[DragEvent]("dragend")

  final case class OnDragEnter(f: DragEvent => _) extends EventAttribute[DragEvent]("dragenter")

  final case class OnDragLeave(f: DragEvent => _) extends EventAttribute[DragEvent]("dragleave")

  final case class OnDragOver(f: DragEvent => _) extends EventAttribute[DragEvent]("dragover")

  final case class OnDragStart(f: DragEvent => _) extends EventAttribute[DragEvent]("dragstart")

  final case class OnDrop(f: DragEvent => _) extends EventAttribute[DragEvent]("drop")

  final case class OnEmptied(f: Event => _) extends EventAttribute[Event]("emptied")

  final case class OnEnded(f: Event => _) extends EventAttribute[Event]("ended")

  final case class OnFocus(f: FocusEvent => _) extends EventAttribute[FocusEvent]("focus")

  final case class OnFocusIn(f: FocusEvent => _) extends EventAttribute[FocusEvent]("focusin")

  final case class OnFocusOut(f: FocusEvent => _) extends EventAttribute[FocusEvent]("focusout")

  final case class OnHelp(f: Event => _) extends EventAttribute[Event]("help")

  final case class OnInput(f: Event => _) extends EventAttribute[Event]("input")

  final case class OnKeyDown(f: KeyboardEvent => _) extends EventAttribute[KeyboardEvent]("keydown")

  final case class OnKeyPress(f: KeyboardEvent => _) extends EventAttribute[KeyboardEvent]("keypress")

  final case class OnKeyUp(f: KeyboardEvent => _) extends EventAttribute[KeyboardEvent]("keyup")

  final case class OnLoad(f: Event => _) extends EventAttribute[Event]("load")

  final case class OnLoadedData(f: Event => _) extends EventAttribute[Event]("loadeddata")

  final case class OnLoadedMetadata(f: Event => _) extends EventAttribute[Event]("loadedmetadata")

  final case class OnLoadStart(f: Event => _) extends EventAttribute[Event]("loadstart")

  final case class OnMouseDown(f: MouseEvent => _) extends EventAttribute[MouseEvent]("mousedown")

  final case class OnMouseEnter(f: MouseEvent => _) extends EventAttribute[MouseEvent]("mouseenter")

  final case class OnMouseLeave(f: MouseEvent => _) extends EventAttribute[MouseEvent]("mouseleave")

  final case class OnMouseMove(f: MouseEvent => _) extends EventAttribute[MouseEvent]("mousemove")

  final case class OnMouseOut(f: MouseEvent => _) extends EventAttribute[MouseEvent]("mouseout")

  final case class OnMouseOver(f: MouseEvent => _) extends EventAttribute[MouseEvent]("mouseover")

  final case class OnMouseUp(f: MouseEvent => _) extends EventAttribute[MouseEvent]("mouseup")

  final case class OnMouseWheel(f: WheelEvent => _) extends EventAttribute[WheelEvent]("mousewheel")

  final case class OnPause(f: Event => _) extends EventAttribute[Event]("pause")

  final case class OnPlay(f: Event => _) extends EventAttribute[Event]("play")

  final case class OnPlaying(f: Event => _) extends EventAttribute[Event]("playing")

  final case class OnProgress(f: Any => _) extends EventAttribute[Event]("progress")

  final case class OnRateChange(f: Event => _) extends EventAttribute[Event]("ratechange")

  final case class OnReadyStateChange(f: Event => _) extends EventAttribute[Event]("readystatechange")

  final case class OnReset(f: Event => _) extends EventAttribute[Event]("reset")

  final case class OnScroll(f: UIEvent => _) extends EventAttribute[UIEvent]("scroll")

  final case class OnSeeked(f: Event => _) extends EventAttribute[Event]("seeked")

  final case class OnSeeking(f: Event => _) extends EventAttribute[Event]("seeking")

  final case class OnSelectStart(f: Event => _) extends EventAttribute[Event]("selectstart")

  final case class OnSelect(f: UIEvent => _) extends EventAttribute[UIEvent]("select")

  final case class OnStalled(f: Event => _) extends EventAttribute[Event]("stalled")

  final case class OnSubmit(f: Event => _) extends EventAttribute[Event]("submit")

  final case class OnSuspend(f: Event => _) extends EventAttribute[Event]("suspend")

  final case class OnTimeUpdate(f: Event => _) extends EventAttribute[Event]("timeupdate")

  final case class OnVolumeChange(f: Event => _) extends EventAttribute[Event]("volumechange")

  final case class OnWaiting(f: Event => _) extends EventAttribute[Event]("waiting")

  final case class Open(value: String) extends SimpleAttribute[String]("open")
    with DetailsAttribute

  final case class Optimum(value: String) extends SimpleAttribute[String]("optimum")
    with MeterAttribute

  final case class Pattern(value: String) extends SimpleAttribute[String]("pattern")
    with InputAttribute

  final case class Ping(value: String) extends SimpleAttribute[String]("ping")
    with AnchorAttribute with AreaAttribute

  final case class Placeholder(value: String) extends SimpleAttribute[String]("placeholder")
    with InputAttribute with TextAreaAttribute

  final case class Poster(value: String) extends SimpleAttribute[String]("poster")
    with VideoAttribute

  final case class Preload(value: String) extends SimpleAttribute[String]("preload")
    with AudioAttribute with VideoAttribute

  final case class RadioGroup(value: String) extends SimpleAttribute[String]("radiogroup")
    with AudioAttribute with VideoAttribute

  final case class ReadOnly(value: String) extends SimpleAttribute[String]("readonly")
    with InputAttribute with TextAreaAttribute

  final case class Rel(value: String) extends SimpleAttribute[String]("rel")
    with AnchorAttribute
    with AreaAttribute
    with LinkAttribute

  final case class Required(value: String) extends SimpleAttribute[String]("required")
    with InputAttribute
    with SelectAttribute
    with TextAreaAttribute

  final case class Reversed(value: String) extends SimpleAttribute[String]("reversed")
    with OLAttribute

  final case class Rows(value: String) extends SimpleAttribute[String]("rows")
    with TextAreaAttribute

  final case class RowSpan(value: String) extends SimpleAttribute[String]("rowspan")
    with TDAttribute with THAttribute

  final case class Sandbox(value: String) extends SimpleAttribute[String]("sandbox")
    with IFrameAttribute

  final case class Scope(value: String) extends SimpleAttribute[String]("scope")
    with THAttribute

  final case class Scoped(value: String) extends SimpleAttribute[String]("scoped")
    with AnchorAttribute with AreaAttribute

  final case class Seamless(value: String) extends SimpleAttribute[String]("seamless")
    with IFrameAttribute

  final case class Selected(value: String) extends SimpleAttribute[String]("selected")
    with OptionAttribute

  final case class Shape(value: String) extends SimpleAttribute[String]("shape")
    with AnchorAttribute with AreaAttribute

  final case class Size(value: String) extends SimpleAttribute[String]("size")
    with InputAttribute with SelectAttribute

  final case class Sizes(value: String) extends SimpleAttribute[String]("sizes")
    with LinkAttribute
    with ImageAttribute
    with SourceAttribute

  final case class Slot(value: String) extends SimpleAttribute[String]("slot")
    with GlobalAttribute

  final case class Span(value: String) extends SimpleAttribute[String]("span")
    with ColAttribute with ColGroupAttribute

  final case class SpellCheck(value: String) extends SimpleAttribute[String]("spellcheck")
    with GlobalAttribute

  final case class Source(value: String) extends SimpleAttribute[String]("src")
    with AudioAttribute
    with EmbedAttribute
    with IFrameAttribute
    with ImageAttribute
    with InputAttribute
    with ScriptAttribute
    with SourceAttribute
    with TrackAttribute
    with VideoAttribute

  final case class SourceDocument(value: String) extends SimpleAttribute[String]("srcdoc")
    with IFrameAttribute

  final case class SourceLanguage(value: String) extends SimpleAttribute[String]("srclang")
    with TrackAttribute

  final case class SourceSet(value: String) extends SimpleAttribute[String]("srcset")
    with ImageAttribute

  final case class Start(value: String) extends SimpleAttribute[String]("start")
    with OLAttribute

  final case class Step(value: String) extends SimpleAttribute[String]("step")
    with InputAttribute

  final case class Style(value: String) extends SimpleAttribute[String]("style")
    with GlobalAttribute

  final case class Summary(value: String) extends SimpleAttribute[String]("summary")
    with TableAttribute

  final case class TabIndex(value: String) extends SimpleAttribute[String]("tabindex")
    with GlobalAttribute

  final case class Target(value: String) extends SimpleAttribute[String]("target")
    with AnchorAttribute
    with AreaAttribute
    with BaseAttribute
    with FormAttribute

  final case class Title(value: String) extends SimpleAttribute[String]("title")
    with GlobalAttribute

  final case class Type(value: String) extends SimpleAttribute[String]("type")
    with ButtonAttribute
    with EmbedAttribute
    with InputAttribute
    with ObjectAttribute
    with ScriptAttribute
    with SourceAttribute
    with StyleAttribute

  final case class UseMap(value: String) extends SimpleAttribute[String]("usemap")
    with ImageAttribute
    with InputAttribute
    with ObjectAttribute

  final case class Value(value: String) extends SimpleAttribute[String]("value")
    with ButtonAttribute
    with InputAttribute
    with LIAttribute
    with MeterAttribute
    with OptionAttribute
    with ParamAttribute
    with ProgressAttribute

  final case class Width(value: String) extends SimpleAttribute[String]("width")
    with CanvasAttribute
    with EmbedAttribute
    with IFrameAttribute
    with ImageAttribute
    with InputAttribute
    with ObjectAttribute
    with VideoAttribute

  final case class Wrap(value: String) extends SimpleAttribute[String]("wrap")
    with TextAreaAttribute

}
