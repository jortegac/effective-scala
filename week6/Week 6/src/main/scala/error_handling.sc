import scala.util.{Failure, Try}

def attemptSomething(): Unit =
  println("So far, so good")
  throw RuntimeException("We can't continue")
  println("You will never see this")

try
  attemptSomething()
catch
  case e: RuntimeException =>
    System.err.println(s"Something went wrong: $e")
    println("Stopping program")

// Exception classes are define in the standard library and form a type hierarchy
// Each patter of the catch clause checks whether the exception that happened is of some specific type or not

// The top object in the hierarchy is "Throwable" and it divides into: Error and Exception

// Error is for issues with the JVM and there's very little your program can do
// Exception is for issues with your program

// To catch all throwable except those that are fatal, Scala provides the NonFatal extractor

// import scala.util.control.NonFatal
// catch
//   case NonFatal(throwable) => ...


// Try/catch expression can be followed by a -finally- clause that is executed both if no exceptions were thrown or if an exception was thrown

// Exceptions are a low level mechanism for dealing with unexpected problems during the program execution

val tryInt: Try[Int] = Failure(":sadface:")

val eitherInt = Left(Throwable(":sadface:"))

val eithderInt: Either[String, Int] = Left(":sadface:")