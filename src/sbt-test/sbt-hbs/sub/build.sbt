import JsEngineKeys._

lazy val root = (project in file(".")).enablePlugins(SbtWeb)

JsEngineKeys.engineType := JsEngineKeys.EngineType.Node

val check = taskKey[Unit]("check that file contents are handlebars template")

check := {
  val contents = IO.read(file("target/web/stage/sub/dir/test.js"))
  if (!contents.contains("templates['sub/dir/test'] = template(")) {
    sys.error(s"Expected template declaration: $contents")
  }
}
