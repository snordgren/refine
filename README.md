# Refine

Refine is a library for declarative HTML rendering in Scala.js.

## Install
Add the following to your `build.sbt`. You can find `refineVersion` in the Releases
tab.

	resolvers += "jitpack" at "https://jitpack.io"
	
	// JVM
	libraryDependencies += "com.github.snordgren.refine" %% "refine-core" % refineVersion

	// Scala.js
    libraryDependencies ++= Seq(
      "com.github.snordgren.refine" %%% "refine-core" % refineVersion,
      "com.github.snordgren.refine" %%% "refine-dom" % refineVersion)
      
## Getting Started
### Hello, world!

```scala
case class App(user: String)

object App {
  implicit object RenderApp extends Render[App] {
    override def render(app: App): Node =
      div(
        h1(s"Hello, ${app.user}!"),
        p(id := "description")("Welcome to Refine!")
      )
  }
}
```

First, we define our data type (`App`), then we implement the `Render` type class
for that data type (this means that we can write render code for types that we do
not control).

```scala
object EntryPoint {
  def main(args: Array[String]): Unit =
    RefineDOM.render(App(user = "Me"), "root")
}
```

Then, in our entry point, we use `RefineDOM.render` to render our data to a
DOM element with the id `root`.

Alternatively, if you are running Refine server-side, you can render the data
to a string using the `.renderToString` method of any Node object. By importing
`refine.implicits._`, you can also call it on any data type that has a `Render`
instance.

```scala
import refine.implicits._

object ServerSideRender {
  def renderPage: String =
    App(user = "You!").renderToString
}
```
