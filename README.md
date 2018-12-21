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
      