// In Scala we use the type -Try- to indicate that a method might fail

import java.time.Period
import scala.util.Try

def attemptSomething(): Try[Unit] =
  Try {
    println("So far, so good")
    throw RuntimeException("Oops, something went wrong")
    println("You will never see this")
  }

attemptSomething().recover {
  case exn: RuntimeException =>
    System.err.println(s"Something went wrong: $exn")
    println("Stopping program")
}

////////////////////////////////////////////

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.util.{Failure, Success}
def parseDate(str: String): Try[LocalDate] =
  Try{
    LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
  }

parseDate("2023-01-01") match
  case Success(date) => println(date)
  case Failure(exception) => println(s"Something went wrong: $exception")


////////////////////////////////////////////

def tryPeriod(str1: String, str2: String): Try[Period] =
  parseDate(str1).flatMap { (date1: LocalDate) =>
    parseDate(str2).map { (date2: LocalDate) =>
      Period.between(date1, date2)
    }
  }

def tryPeriod2(str1: String, str2: String): Try[Period] =
  for
    date1 <- parseDate(str1)
    date2 <- parseDate(str2)
  yield
    Period.between(date1, date2)


tryPeriod("2023-01-01", "2023-01-05")
tryPeriod2("2023-25-01", "2023-31-05")