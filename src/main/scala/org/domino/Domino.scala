package org.domino

object Domino {
  implicit def string2Node(s: String): Node = Text(s)

  def a(attributes: AnchorAttribute*)(children: Node*) =
    AnchorElement(attributes, children)

  def abbr(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("abbr", attributes, children)

  def address(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("address", attributes, children)

  def area(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("area", attributes, children)

  def article(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("article", attributes, children)

  def aside(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("aside", attributes, children)

  def audio(attributes: AudioAttribute*)(children: Node*) =
    AudioElement(attributes, children)

  def b(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("b", attributes, children)

  def base(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("base", attributes, children)

  def bdi(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("bdi", attributes, children)

  def bdo(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("bdo", attributes, children)

  def blockquote(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("blockquote", attributes, children)

  def body(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("body", attributes, children)

  def br(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("br", attributes, children)

  def button(attributes: GlobalAttribute*)(children: Node*) =
    ButtonElement(attributes, children)

  def canvas(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("canvas", attributes, children)

  def caption(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("caption", attributes, children)

  def cite(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("cite", attributes, children)

  def code(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("code", attributes, children)

  def col(attributes: GlobalAttribute*)(children: Node*) =
    ColElement(attributes, children)

  def colgroup(attributes: GlobalAttribute*)(children: Node*) =
    ColGroupElement(attributes, children)

  def datalist(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("datalist", attributes, children)

  def dd(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("dd", attributes, children)

  def del(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("del", attributes, children)

  def details(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("details", attributes, children)

  def dfn(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("dfn", attributes, children)

  def dialog(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("dialog", attributes, children)

  def div(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("div", attributes, children)

  def dl(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("dl", attributes, children)

  def dt(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("dt", attributes, children)

  def em(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("em", attributes, children)

  def embed(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("embed", attributes, children)

  def fieldset(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("fieldset", attributes, children)

  def figcaption(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("figcaption", attributes, children)

  def figure(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("figure", attributes, children)

  def footer(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("footer", attributes, children)

  def form(attributes: FormAttribute*)(children: Node*) =
    FormElement(attributes, children)

  def h1(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("h1", attributes, children)

  def h2(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("h2", attributes, children)

  def h3(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("h3", attributes, children)

  def h4(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("h4", attributes, children)

  def h5(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("h5", attributes, children)

  def h6(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("h6", attributes, children)

  def head(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("head", attributes, children)

  def header(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("header", attributes, children)

  def hr(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("hr", attributes, children)

  def html(attributes: HTMLAttribute*)(children: Node*) =
    HTMLElement(attributes, children)

  def i(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("i", attributes, children)

  def iframe(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("iframe", attributes, children)

  def img(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("img", attributes, children)

  def input(attributes: InputAttribute*)(children: Node*) =
    InputElement(attributes, children)

  def ins(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("ins", attributes, children)

  def kbd(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("kbd", attributes, children)

  def label(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("label", attributes, children)

  def legend(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("legend", attributes, children)

  def li(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("li", attributes, children)

  def link(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("link", attributes, children)

  def main(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("main", attributes, children)

  def map(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("map", attributes, children)

  def mark(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("mark", attributes, children)

  def menu(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("menu", attributes, children)

  def menuitem(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("menuitem", attributes, children)

  def meta(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("meta", attributes, children)

  def meter(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("meter", attributes, children)

  def nav(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("nav", attributes, children)

  def noscript(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("noscript", attributes, children)

  def `object`(attributes: ObjectAttribute*)(children: Node*) =
    ObjectElement(attributes, children)

  def ol(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("ol", attributes, children)

  def optgroup(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("optgroup", attributes, children)

  def option(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("option", attributes, children)

  def output(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("output", attributes, children)

  def p(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("p", attributes, children)

  def param(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("param", attributes, children)

  def picture(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("picture", attributes, children)

  def pre(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("pre", attributes, children)

  def progress(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("progress", attributes, children)

  def q(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("q", attributes, children)

  def rp(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("rp", attributes, children)

  def rt(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("rt", attributes, children)

  def ruby(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("ruby", attributes, children)

  def s(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("s", attributes, children)

  def samp(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("samp", attributes, children)

  def script(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("script", attributes, children)

  def section(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("section", attributes, children)

  def select(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("select", attributes, children)

  def small(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("small", attributes, children)

  def source(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("source", attributes, children)

  def span(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("span", attributes, children)

  def strong(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("strong", attributes, children)

  def style(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("style", attributes, children)

  def sub(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("sub", attributes, children)

  def summary(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("summary", attributes, children)

  def sup(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("sup", attributes, children)

  def table(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("table", attributes, children)

  def tbody(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("tbody", attributes, children)

  def td(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("td", attributes, children)

  def template(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("template", attributes, children)

  def textarea(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("textarea", attributes, children)

  def tfoot(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("tfoot", attributes, children)

  def th(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("th", attributes, children)

  def thead(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("thead", attributes, children)

  def time(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("time", attributes, children)

  def title(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("title", attributes, children)

  def tr(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("tr", attributes, children)

  def track(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("track", attributes, children)

  def u(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("u", attributes, children)

  def ul(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("ul", attributes, children)

  def `var`(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("var", attributes, children)

  def video(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("video", attributes, children)

  def wbr(attributes: GlobalAttribute*)(children: Node*) =
    GenericElement("wbr", attributes, children)
}
