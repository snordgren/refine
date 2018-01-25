package org.domino

object Domino {
  implicit def string2Node(s: String): Node = Text(s)

  def a(attributes: AnchorAttribute*)(children: Node*) =
    Element("a", attributes, children)

  def abbr(attributes: GlobalAttribute*)(children: Node*) =
    Element("abbr", attributes, children)

  def address(attributes: GlobalAttribute*)(children: Node*) =
    Element("address", attributes, children)

  def area(attributes: AreaAttribute*)(children: Node*) =
    Element("area", attributes, children)

  def article(attributes: GlobalAttribute*)(children: Node*) =
    Element("article", attributes, children)

  def aside(attributes: GlobalAttribute*)(children: Node*) =
    Element("aside", attributes, children)

  def audio(attributes: AudioAttribute*)(children: Node*) =
    Element("audio", attributes, children)

  def b(attributes: GlobalAttribute*)(children: Node*) =
    Element("b", attributes, children)

  def base(attributes: BaseAttribute*)(children: Node*) =
    Element("base", attributes, children)

  def bdi(attributes: GlobalAttribute*)(children: Node*) =
    Element("bdi", attributes, children)

  def bdo(attributes: GlobalAttribute*)(children: Node*) =
    Element("bdo", attributes, children)

  def blockquote(attributes: BlockQuoteAttribute*)(children: Node*) =
    Element("blockquote", attributes, children)

  def body(attributes: GlobalAttribute*)(children: Node*) =
    Element("body", attributes, children)

  def br(attributes: GlobalAttribute*)(children: Node*) =
    Element("br", attributes, children)

  def button(attributes: ButtonAttribute*)(children: Node*) =
    Element("button", attributes, children)

  def canvas(attributes: CanvasAttribute*)(children: Node*) =
    Element("canvas", attributes, children)

  def caption(attributes: CaptionAttribute*)(children: Node*) =
    Element("caption", attributes, children)

  def cite(attributes: GlobalAttribute*)(children: Node*) =
    Element("cite", attributes, children)

  def code(attributes: GlobalAttribute*)(children: Node*) =
    Element("code", attributes, children)

  def col(attributes: ColAttribute*)(children: Node*) =
    Element("col", attributes, children)

  def colgroup(attributes: ColGroupAttribute*)(children: Node*) =
    Element("colgroup", attributes, children)

  def datalist(attributes: GlobalAttribute*)(children: Node*) =
    Element("datalist", attributes, children)

  def dd(attributes: GlobalAttribute*)(children: Node*) =
    Element("dd", attributes, children)

  def del(attributes: DelAttribute*)(children: Node*) =
    Element("del", attributes, children)

  def details(attributes: GlobalAttribute*)(children: Node*) =
    Element("details", attributes, children)

  def dfn(attributes: GlobalAttribute*)(children: Node*) =
    Element("dfn", attributes, children)

  def dialog(attributes: GlobalAttribute*)(children: Node*) =
    Element("dialog", attributes, children)

  def div(attributes: GlobalAttribute*)(children: Node*) =
    Element("div", attributes, children)

  def dl(attributes: GlobalAttribute*)(children: Node*) =
    Element("dl", attributes, children)

  def dt(attributes: GlobalAttribute*)(children: Node*) =
    Element("dt", attributes, children)

  def em(attributes: GlobalAttribute*)(children: Node*) =
    Element("em", attributes, children)

  def embed(attributes: EmbedAttribute*)(children: Node*) =
    Element("embed", attributes, children)

  def fieldset(attributes: FieldSetAttribute*)(children: Node*) =
    Element("fieldset", attributes, children)

  def figcaption(attributes: GlobalAttribute*)(children: Node*) =
    Element("figcaption", attributes, children)

  def figure(attributes: GlobalAttribute*)(children: Node*) =
    Element("figure", attributes, children)

  def footer(attributes: GlobalAttribute*)(children: Node*) =
    Element("footer", attributes, children)

  def form(attributes: FormAttribute*)(children: Node*) =
    Element("form", attributes, children)

  def h1(attributes: GlobalAttribute*)(children: Node*) =
    Element("h1", attributes, children)

  def h2(attributes: GlobalAttribute*)(children: Node*) =
    Element("h2", attributes, children)

  def h3(attributes: GlobalAttribute*)(children: Node*) =
    Element("h3", attributes, children)

  def h4(attributes: GlobalAttribute*)(children: Node*) =
    Element("h4", attributes, children)

  def h5(attributes: GlobalAttribute*)(children: Node*) =
    Element("h5", attributes, children)

  def h6(attributes: GlobalAttribute*)(children: Node*) =
    Element("h6", attributes, children)

  def head(attributes: GlobalAttribute*)(children: Node*) =
    Element("head", attributes, children)

  def header(attributes: GlobalAttribute*)(children: Node*) =
    Element("header", attributes, children)

  def hr(attributes: HRAttribute*)(children: Node*) =
    Element("hr", attributes, children)

  def html(attributes: HTMLAttribute*)(children: Node*) =
    Element("html", attributes, children)

  def i(attributes: GlobalAttribute*)(children: Node*) =
    Element("i", attributes, children)

  def iframe(attributes: IFrameAttribute*)(children: Node*) =
    Element("iframe", attributes, children)

  def img(attributes: ImageAttribute*)(children: Node*) =
    Element("img", attributes, children)

  def input(attributes: InputAttribute*)(children: Node*) =
    Element("input", attributes, children)

  def ins(attributes: InsAttribute*)(children: Node*) =
    Element("ins", attributes, children)

  def kbd(attributes: GlobalAttribute*)(children: Node*) =
    Element("kbd", attributes, children)

  def label(attributes: LabelAttribute*)(children: Node*) =
    Element("label", attributes, children)

  def legend(attributes: GlobalAttribute*)(children: Node*) =
    Element("legend", attributes, children)

  def li(attributes: GlobalAttribute*)(children: Node*) =
    Element("li", attributes, children)

  def link(attributes: LinkAttribute*)(children: Node*) =
    Element("link", attributes, children)

  def main(attributes: GlobalAttribute*)(children: Node*) =
    Element("main", attributes, children)

  def map(attributes: GlobalAttribute*)(children: Node*) =
    Element("map", attributes, children)

  def mark(attributes: GlobalAttribute*)(children: Node*) =
    Element("mark", attributes, children)

  def menu(attributes: GlobalAttribute*)(children: Node*) =
    Element("menu", attributes, children)

  def menuitem(attributes: GlobalAttribute*)(children: Node*) =
    Element("menuitem", attributes, children)

  def meta(attributes: GlobalAttribute*)(children: Node*) =
    Element("meta", attributes, children)

  def meter(attributes: MeterAttribute*)(children: Node*) =
    Element("meter", attributes, children)

  def nav(attributes: GlobalAttribute*)(children: Node*) =
    Element("nav", attributes, children)

  def noscript(attributes: GlobalAttribute*)(children: Node*) =
    Element("noscript", attributes, children)

  def `object`(attributes: ObjectAttribute*)(children: Node*) =
    Element("object", attributes, children)

  def ol(attributes: GlobalAttribute*)(children: Node*) =
    Element("ol", attributes, children)

  def optgroup(attributes: GlobalAttribute*)(children: Node*) =
    Element("optgroup", attributes, children)

  def option(attributes: GlobalAttribute*)(children: Node*) =
    Element("option", attributes, children)

  def output(attributes: GlobalAttribute*)(children: Node*) =
    Element("output", attributes, children)

  def p(attributes: GlobalAttribute*)(children: Node*) =
    Element("p", attributes, children)

  def param(attributes: GlobalAttribute*)(children: Node*) =
    Element("param", attributes, children)

  def picture(attributes: GlobalAttribute*)(children: Node*) =
    Element("picture", attributes, children)

  def pre(attributes: GlobalAttribute*)(children: Node*) =
    Element("pre", attributes, children)

  def progress(attributes: GlobalAttribute*)(children: Node*) =
    Element("progress", attributes, children)

  def q(attributes: GlobalAttribute*)(children: Node*) =
    Element("q", attributes, children)

  def rp(attributes: GlobalAttribute*)(children: Node*) =
    Element("rp", attributes, children)

  def rt(attributes: GlobalAttribute*)(children: Node*) =
    Element("rt", attributes, children)

  def ruby(attributes: GlobalAttribute*)(children: Node*) =
    Element("ruby", attributes, children)

  def s(attributes: GlobalAttribute*)(children: Node*) =
    Element("s", attributes, children)

  def samp(attributes: GlobalAttribute*)(children: Node*) =
    Element("samp", attributes, children)

  def script(attributes: GlobalAttribute*)(children: Node*) =
    Element("script", attributes, children)

  def section(attributes: GlobalAttribute*)(children: Node*) =
    Element("section", attributes, children)

  def select(attributes: GlobalAttribute*)(children: Node*) =
    Element("select", attributes, children)

  def small(attributes: GlobalAttribute*)(children: Node*) =
    Element("small", attributes, children)

  def source(attributes: GlobalAttribute*)(children: Node*) =
    Element("source", attributes, children)

  def span(attributes: GlobalAttribute*)(children: Node*) =
    Element("span", attributes, children)

  def strong(attributes: GlobalAttribute*)(children: Node*) =
    Element("strong", attributes, children)

  def style(attributes: GlobalAttribute*)(children: Node*) =
    Element("style", attributes, children)

  def sub(attributes: GlobalAttribute*)(children: Node*) =
    Element("sub", attributes, children)

  def summary(attributes: GlobalAttribute*)(children: Node*) =
    Element("summary", attributes, children)

  def sup(attributes: GlobalAttribute*)(children: Node*) =
    Element("sup", attributes, children)

  def table(attributes: GlobalAttribute*)(children: Node*) =
    Element("table", attributes, children)

  def tbody(attributes: GlobalAttribute*)(children: Node*) =
    Element("tbody", attributes, children)

  def td(attributes: GlobalAttribute*)(children: Node*) =
    Element("td", attributes, children)

  def template(attributes: GlobalAttribute*)(children: Node*) =
    Element("template", attributes, children)

  def textarea(attributes: TextAreaAttribute*)(children: Node*) =
    Element("textarea", attributes, children)

  def tfoot(attributes: GlobalAttribute*)(children: Node*) =
    Element("tfoot", attributes, children)

  def th(attributes: GlobalAttribute*)(children: Node*) =
    Element("th", attributes, children)

  def thead(attributes: GlobalAttribute*)(children: Node*) =
    Element("thead", attributes, children)

  def time(attributes: GlobalAttribute*)(children: Node*) =
    Element("time", attributes, children)

  def title(attributes: GlobalAttribute*)(children: Node*) =
    Element("title", attributes, children)

  def tr(attributes: GlobalAttribute*)(children: Node*) =
    Element("tr", attributes, children)

  def track(attributes: GlobalAttribute*)(children: Node*) =
    Element("track", attributes, children)

  def u(attributes: GlobalAttribute*)(children: Node*) =
    Element("u", attributes, children)

  def ul(attributes: GlobalAttribute*)(children: Node*) =
    Element("ul", attributes, children)

  def `var`(attributes: GlobalAttribute*)(children: Node*) =
    Element("var", attributes, children)

  def video(attributes: GlobalAttribute*)(children: Node*) =
    Element("video", attributes, children)

  def wbr(attributes: GlobalAttribute*)(children: Node*) =
    Element("wbr", attributes, children)
}
