package org.domino.html

import org.domino.{TextRenderer, UnitSpec}

class HTMLSpec extends UnitSpec {
  "HTML" should "be performant" in {
    val titleString = "This is my title"
    val firstParaString = "This is my first paragraph"
    val contentpara = "contentpara"
    val first = "first"
    val times = 1024 * 32

    def testDomino() = {
      import HTML._
      val startTime = System.currentTimeMillis()

      (0 until times).foreach(_ => {
        TextRenderer(
          html(
            head(script("console.log(1)")),
            body(
              header(id := "header", title := "This is the header.")(titleString),
              h1(titleString),
              div(
                p(className := contentpara + " " + first)(0, firstParaString),
                div((0 until 5).map(n => p(className := contentpara)("Paragraph ", n)): _*)
              )
            )
          ))
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
                  color := (if (i % 2 == 0) "red" else "green"),
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

    (0 until 3).foreach { _ =>
      testDomino()
      testScalaTags()
    }

    val dmResult = testDomino()
    val stResult = testScalaTags()
    println(stResult + ", " + dmResult)
  }
}
