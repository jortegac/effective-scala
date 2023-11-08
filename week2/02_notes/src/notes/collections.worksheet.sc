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

////// Transforming collections

val list = List(1, 2, 3, 4, 5)
list.map(x => x + 1)

val buff = mutable.ArrayBuffer(1, 2, 3, 4, 5)
buff.map(x => x % 2 == 0)

val map = Map( 0 -> "No", 1 -> "Yes")
map.map((key, value) => key -> (value * 2))

// Note that map doesn't change the order or number of elements in a collection

// FlatMap allows us to change the number of elements in a collection

// Remove all the elements
List(1, 2, 3).flatMap(x => List())

// Double the number of elements
mutable.ArrayBuffer(1, 2).flatMap(x => mutable.ArrayBuffer(x, x * 2))

// Keep number of elements the same but change the type
Map(1 -> "One", 2 -> "Two").flatMap((key, _) => Map(key.toString() -> key))

// Map vs FlatMap
// Implement a program that returns all the phone number of a contact list

case class Contact(name: String, email: String, phoneNumbers: List[String])
val alice = Contact("Alice", "alice@example.com", List())
val bob = Contact("Bob", "bob@example.com", List("+3165465465"))
val carol = Contact("Carol", "carol@example.com", List("+3165434555", "+31654345"))

val contacts: List[Contact] = List(alice, bob, carol)

val allPhoneNumbers = contacts.map(contact => contact.phoneNumbers)

val allPhoneNumbers2 = contacts.flatMap(contact => contact.phoneNumbers)

// FoldLeft
// Allows us to transfrom a collection into anything else

// Sum the elements of the list
List(1, 2, 3).foldLeft(0)((acc, elem) => acc + elem)

// Reverse the list
List(1, 2, 3).foldLeft(List.empty[Int])((acc, elem) => elem +: acc)

// True if the last element is even or the list is empty
List(1, 2, 3).foldLeft(true)((acc, elem) => elem % 2 == 0)

// The first paramenter list in FoldLeft is the initial value of the accumulator
// The second parameter is the function is how we combine the accumulator with the current element of the list to create the next accumulator

// GroupBy
// Groups the elements of a collection according to a partition function

val emails = List("alice@example.com", "bob@test.com", "carol@example.com")

// Function extracting the domain name form an email address
val domain: String => String =
  email => email.dropWhile(contact => contact != '@').drop(1)

val emailsByDomain = emails.groupBy(domain)

////////
val pastry = List("croissant", "cake", "pain au chocolat")
val ingredients = (s: String) =>
  if(s == "croissant") List("flour", "butter")
  else if(s == "cake") List("flour", "eggs", "sugar", "butter")
  else List()

pastry.flatMap(ingredients)