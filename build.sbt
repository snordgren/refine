enablePlugins(ScalaJSPlugin)
name := "domino"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.2",
  "org.scalatest" %%% "scalatest" % "3.0.4" % Test
)
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.4"
scalacOptions ++= Seq("-language:implicitConversions")
