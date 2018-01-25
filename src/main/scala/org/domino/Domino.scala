package org.domino

object Domino {
  def a(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("anchor", attributes, children)

  def abbr(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("abbr", attributes, children)

  def address(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("address", attributes, children)

  def area(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("area", attributes, children)

  def article(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("article", attributes, children)

  def aside(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("aside", attributes, children)

  def audio(attributes: AudioAttribute*)(children: Element[_]*) =
    AudioElement(attributes, children)

  def b(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("b", attributes, children)

  def base(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("base", attributes, children)

  def bdi(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("bdi", attributes, children)

  def bdo(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("bdo", attributes, children)

  def blockquote(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("blockquote", attributes, children)

  def body(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("body", attributes, children)

  def br(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("br", attributes, children)

  def button(attributes: GlobalAttribute*)(children: Element[_]*) =
    ButtonElement(attributes, children)

  def canvas(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("canvas", attributes, children)

  def caption(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("caption", attributes, children)

  def cite(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("cite", attributes, children)

  def code(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("code", attributes, children)

  def col(attributes: GlobalAttribute*)(children: Element[_]*) =
    ColElement(attributes, children)

  def colgroup(attributes: GlobalAttribute*)(children: Element[_]*) =
    ColGroupElement(attributes, children)

  def datalist(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("datalist", attributes, children)

  def dd(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("dd", attributes, children)

  def del(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("del", attributes, children)

  def details(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("details", attributes, children)

  def dfn(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("dfn", attributes, children)

  def dialog(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("dialog", attributes, children)

  def div(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("div", attributes, children)

  def dl(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("dl", attributes, children)

  def dt(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("dt", attributes, children)

  def em(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("em", attributes, children)

  def embed(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("embed", attributes, children)

  def fieldset(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("fieldset", attributes, children)

  def figcaption(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("figcaption", attributes, children)

  def figure(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("figure", attributes, children)

  def footer(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("footer", attributes, children)

  def form(attributes: FormAttribute*)(children: Element[_]*) =
    FormElement(attributes, children)

  def head(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("head", attributes, children)

  def header(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("header", attributes, children)

  def hr(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("hr", attributes, children)

  def html(attributes: HTMLAttribute*)(children: Element[_]*) =
    HTMLElement(attributes, children)

  def i(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("i", attributes, children)

  def iframe(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("iframe", attributes, children)

  def img(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("img", attributes, children)

  def input(attributes: InputAttribute*)(children: Element[_]*) =
    InputElement(attributes, children)

  def ins(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("ins", attributes, children)

  def kbd(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("kbd", attributes, children)

  def label(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("label", attributes, children)

  def legend(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("legend", attributes, children)

  def li(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("li", attributes, children)

  def link(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("link", attributes, children)

  def main(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("main", attributes, children)

  def map(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("map", attributes, children)

  def mark(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("mark", attributes, children)

  def menu(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("menu", attributes, children)

  def menuitem(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("menuitem", attributes, children)

  def meta(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("meta", attributes, children)

  def meter(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("meter", attributes, children)

  def nav(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("nav", attributes, children)

  def noscript(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("noscript", attributes, children)

  def `object`(attributes: ObjectAttribute*)(children: Element[_]*) =
    ObjectElement(attributes, children)

  def ol(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("ol", attributes, children)

  def optgroup(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("optgroup", attributes, children)

  def option(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("option", attributes, children)

  def output(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("output", attributes, children)

  def p(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("p", attributes, children)

  def param(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("param", attributes, children)

  def picture(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("picture", attributes, children)

  def pre(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("pre", attributes, children)

  def progress(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("progress", attributes, children)

  def q(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("q", attributes, children)

  def rp(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("rp", attributes, children)

  def rt(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("rt", attributes, children)

  def ruby(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("ruby", attributes, children)

  def s(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("s", attributes, children)

  def samp(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("samp", attributes, children)

  def script(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("script", attributes, children)

  def section(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("section", attributes, children)

  def select(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("select", attributes, children)

  def small(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("small", attributes, children)

  def source(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("source", attributes, children)

  def span(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("span", attributes, children)

  def strong(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("strong", attributes, children)

  def style(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("style", attributes, children)

  def sub(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("sub", attributes, children)

  def summary(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("summary", attributes, children)

  def sup(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("sup", attributes, children)

  def table(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("table", attributes, children)

  def tbody(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("tbody", attributes, children)

  def td(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("td", attributes, children)

  def template(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("template", attributes, children)

  def textarea(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("textarea", attributes, children)

  def tfoot(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("tfoot", attributes, children)

  def th(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("th", attributes, children)

  def thead(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("thead", attributes, children)

  def time(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("time", attributes, children)

  def title(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("title", attributes, children)

  def tr(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("tr", attributes, children)

  def track(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("track", attributes, children)

  def u(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("u", attributes, children)

  def ul(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("ul", attributes, children)

  def `var`(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("var", attributes, children)

  def video(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("video", attributes, children)

  def wbr(attributes: GlobalAttribute*)(children: Element[_]*) =
    GenericElement("wbr", attributes, children)
}
