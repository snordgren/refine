val commonSettings = Seq(
  organization := "org.scalacode",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.4",
  scalacOptions := Seq("-language:implicitConversions"),
  libraryDependencies ++= Seq(
    "org.scalatest" %%% "scalatest" % "3.0.4" % Test,
    "com.lihaoyi" %%% "scalatags" % "0.6.7" % Test
  )
)

lazy val dominoCore = crossProject
  .in(file("domino-core"))
  .settings(commonSettings)
  .settings(name := "domino-core")
  .jsSettings()
  .jvmSettings()

lazy val dominoCoreJS = dominoCore.js
lazy val dominoCoreJVM = dominoCore.jvm

lazy val dominoDOM = project
  .in(file("domino-dom"))
  .settings(commonSettings)
  .settings(name := "domino-dom",
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.2",
      "org.scala-js" %% "scalajs-env-jsdom-nodejs" % "1.0.0-M1" % Test),
    jsEnv in Test := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv())
  .dependsOn(dominoCoreJS)
  .enablePlugins(ScalaJSPlugin)

lazy val root = project
  .in(file("."))
  .aggregate(dominoCoreJS, dominoCoreJVM, dominoDOM)
