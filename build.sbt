enablePlugins(ScalaJSPlugin)

name := "domino"
organization := "org.domino"
version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.2",
  "org.scalatest" %%% "scalatest" % "3.0.4" % Test,
  "com.lihaoyi" %%% "scalatags" % "0.6.7" % Test
)

scalacOptions ++= Seq("-language:implicitConversions")

scalaJSUseMainModuleInitializer := true
