scalaVersion := "3.3.1"

libraryDependencies ++= List(
    "com.lihaoyi" %% "fansi" % "0.4.0",
    "org.scalameta" %% "munit" % "0.7.29" % Test
)

testFrameworks += TestFramework("munit.Framework")

makeSite / mappings := {
    val indexFile = target.value / "index.html"
    IO.write(indexFile, "<h1>Hello World!</h1>")
    Seq(indexFile -> "index.html")
}

unmanagedSources / includeFilter := new io.ExtensionFilter(
    "java",
    "scala",
    "sc"
)