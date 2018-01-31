package org.domino

class HTMLSpec extends UnitSpec {
  "HTML" should "be performant" in {
    val titleString = "This is my title"
    val firstParaString = "This is my first paragraph"
    val contentpara = "contentpara"
    val first = "first"
    val times = 4096 * 2

    def testDomino() = {
      import org.domino.HTML._
      val startTime = System.currentTimeMillis()

      (0 until times).foreach(_ => {
        html(
          head(
            script("console.log(1)")
          ),
          body(
            header(id := "header", title := "This is the header.")(titleString),
            h1(titleString),
            div(
              p(cls := contentpara + " " + first)(0, firstParaString),
              div((for (i <- 0 until 5) yield {
                p(cls := contentpara)(
                  "Paragraph ",
                  i
                )
              }): _*)
            )
          )
        ).renderToString
      })

      val endTime = System.currentTimeMillis()
      endTime - startTime
    }

    def testScalaTags() = {
      import scalatags.Text.all._
      val startTime = System.currentTimeMillis()
      (0 until times).foreach(_ => {
        html(
          head(
            script("console.log(1)")
          ),
          body(
            header(id := "header", title := "This is the header.", titleString),
            h1(titleString),
            div(
              p(0, cls := contentpara + " " + first, firstParaString),
              div(for (i <- 0 until 5) yield {
                p(i,
                  cls := contentpara,
                  "Paragraph ",
                  i
                )
              })
            )
          )
        ).toString
      })
      val endTime = System.currentTimeMillis()
      endTime - startTime
    }

    testDomino()
    testScalaTags()

    val dmResult = testDomino()
    val stResult = testScalaTags()
    dmResult should be < stResult
  }
}
