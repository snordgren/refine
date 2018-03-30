package refine

object implicits extends Conversions {
  implicit class RenderOps[A](a: A)(implicit ev: Render[A]) {
    def renderToString: String =
      ev.render(a).renderToString
  }
}
