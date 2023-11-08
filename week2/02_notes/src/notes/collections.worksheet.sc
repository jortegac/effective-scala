import scala.collection.mutable

// By convention is recommended to explicitly use mutable to improve readability of the code
val buffer = mutable.ArrayBuffer()

// Constructing emoty collections
List.empty
mutable.ArrayBuffer.empty
Map.empty

// Now with useful types
List.empty[Int]
mutable.ArrayBuffer.empty[Double]
Map.empty[String, Boolean]

// Constructing a map with varargs
Map("a" -> true, "b" -> true, "c" -> false)

// Tuples
// A tuple is a collection of fixed size but the values in the collection may have different types
val pair1: (String, Int) = "Alice" -> 42
val pair2: (String, Int) = ("Alice", 42)
val tuple: (Int, String, Boolean) = (42, "Alice", true)

(10.0, "Hello") match
    case (number, greeting) => s"$greeting! The number is $number"

val (x, y) = (10.0, 20.0)
x
y

// We can access elements of a tuple by index
tuple(0)
tuple(1)
tuple(2)

// Add an element to the front of a list using +:
0 +: List(1, 2, 3)
// Add an element to the back of a list using :+
mutable.ArrayBuffer("a", "b") :+ "c"

// We cannot use +: or :+ on maps as they have no sense of order
// Instead we can use the + operation
Map("a" -> true) + ("b" -> false)


def euclideanDivision(dividend: Int, divisor: Int): (Int, Int) =
  val quotient  = dividend / divisor
  val remainder = dividend % divisor
  (quotient, remainder)

val result = euclideanDivision(10, 3)
result(0)

result match
  case (quotient, _) => println(quotient)

val (q, r) = euclideanDivision(10, 3)

///////////////////////////
// Querying collections

val data = List(1, 2, 3, 4, 5, 6)
data.size
data.isEmpty
data.nonEmpty
data.contains(1)

// Find the first even number
data.find(x => x % 2 == 0)
// Find all even numbers
data.filter(x => x % 2 == 0)

// There are two cases to Option: Some and None

// Will be None if the element is not found
data.find(x => x == 10)

// There are other filter methods in the scala documentation, such as filterNot, findLast, etc.


val names = List("Alice", "Bob", "Carol", "David")
names.filter(name => name.size > 4)
println(names)