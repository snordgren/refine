package org.domino.dom

import org.domino.EventAttribute
import org.scalajs.dom.{DragEvent, Event, FocusEvent, KeyboardEvent, MouseEvent, WheelEvent}
import org.w3c.dom.events.UIEvent

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
