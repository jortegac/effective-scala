package hellosbt

@main def run(name: String): Unit =
  println(fansi.Color.Red(s"Hello, $name!!!!"))