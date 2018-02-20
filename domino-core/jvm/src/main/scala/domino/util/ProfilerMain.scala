package domino.util

import scala.io.StdIn

/**
 * Entry point for profiling text rendering performance.
 */
object ProfilerMain {
  def main(args: Array[String]): Unit = {
    var count = 0
    var running = true
    val thread = new Thread(() => {
      while (running) {
        import domino.html._

        html(
          head(
            meta(charset := "UTF-8")()
          ),
          body(
            header(h1("header")),
            div(
              div(
                h1("title"),
                p("content")),
              aside(div(id := "root")("This is where I render to!"))),
            footer("copyright")
          )
        ).renderToString

        count += 1
      }
    })

    println("Waiting to start...")
    val startTime = System.currentTimeMillis()
    StdIn.readLine()
    println("Started... ")

    thread.start()
    Thread.sleep(10 * 1000)
    running = false
    val endTime = System.currentTimeMillis()
    val totalTime = endTime - startTime
    val runsPerSecond = count / (totalTime / 1000)

    println("Run ended.")
    println("Domino managed " + runsPerSecond + " executions per second.")
    System.exit(0)
  }
}
