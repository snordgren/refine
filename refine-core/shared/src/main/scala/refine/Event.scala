package refine

sealed abstract class Event(val jsName: String)

object Event {

  case object Abort extends Event("abort")

  case object Activate extends Event("activate")

  case object BeforeCut extends Event("beforecut")

  case object BeforeActivate extends Event("beforeactivate")

  case object BeforeDeactivate extends Event("beforedeactivate")

  case object BeforeCopy extends Event("beforecopy")

  case object BeforePaste extends Event("beforepaste")

  case object Blur extends Event("blur")

  case object CanPlay extends Event("canplay")

  case object CanPlayThrough extends Event("canplaythrough")

  case object Change extends Event("change")

  case object Click extends Event("click")

  case object ContextMenu extends Event("contextmenu")

  case object CueChange extends Event("cuechange")

  case object Deactivate extends Event("deactivate")

  case object DoubleClick extends Event("dblclick")

  case object Drag extends Event("drag")

  case object DragEnd extends Event("dragend")

  case object DragEnter extends Event("dragenter")

  case object DragLeave extends Event("dragleave")

  case object DragOver extends Event("dragover")

  case object DragStart extends Event("dragstart")

  case object Drop extends Event("drop")

  case object Emptied extends Event("emptied")

  case object Ended extends Event("ended")

  case object Focus extends Event("focus")

  case object FocusIn extends Event("focusin")

  case object FocusOut extends Event("focusout")

  case object Help extends Event("help")

  case object Input extends Event("input")

  case object KeyDown extends Event("keydown")

  case object KeyPress extends Event("keypress")

  case object KeyUp extends Event("keyup")

  case object Load extends Event("load")

  case object LoadedData extends Event("loadeddata")

  case object LoadedMetadata extends Event("loadedmetadata")

  case object LoadStart extends Event("loadstart")

  case object MouseDown extends Event("mousedown")

  case object MouseEnter extends Event("mouseenter")

  case object MouseLeave extends Event("mouseleave")

  case object MouseMove extends Event("mousemove")

  case object MouseOut extends Event("mouseout")

  case object MouseOver extends Event("mouseover")

  case object MouseUp extends Event("mouseup")

  case object MouseWheel extends Event("mousewheel")

  case object Pause extends Event("pause")

  case object Play extends Event("play")

  case object Playing extends Event("playing")

  case object Progress extends Event("progress")

  case object RateChange extends Event("ratechange")

  case object ReadyStateChange extends Event("readystatechange")

  case object Reset extends Event("reset")

  case object Scroll extends Event("scroll")

  case object Seeked extends Event("seeked")

  case object Seeking extends Event("seeking")

  case object SelectStart extends Event("selectstart")

  case object Select extends Event("select")

  case object Stalled extends Event("stalled")

  case object Submit extends Event("submit")

  case object Suspend extends Event("suspend")

  case object TimeUpdate extends Event("timeupdate")

  case object VolumeChange extends Event("volumechange")

  case object Waiting extends Event("waiting")
}
