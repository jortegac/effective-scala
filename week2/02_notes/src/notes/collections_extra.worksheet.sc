import scala.collection.mutable

// We can ++ to concatenate collections
List(1, 2, 3) ++ List(4, 5, 6)
mutable.ArrayBuffer("a", "b", "c") ++ mutable.ArrayBuffer("d", "e", "f")
Map("a" -> true, "e" -> false) ++ Map("b" -> true)

// Concatenation is immutable

// There is a mutable concatenation method. The ++= method
val first = mutable.ArrayBuffer(1, 2, 3)
val second = mutable.ArrayBuffer(4, 5, 6)
first ++= second
first
second

// Mutable prepend and append
val data = mutable.ArrayBuffer(1, 2, 3)
data.prepend(0)
data += 4
data.append(5)
6 +=: data
data

// Mutably removing elements
// We can use the -= method to remove elements in mutable sequences

val a = mutable.ArrayBuffer(1, 2, 3, 3, 2, 1)
a -= 3
a

// The --= method removes all the elements found in the given collection

val b = mutable.ArrayBuffer(1, 2, 3, 4, 5, 6)
b --= List(3, 4, 7)

//// Querying collections
// Sometimes we might want to know if any or all elements match a predicate
// We can use the exists and forall methods

val test = mutable.ArrayBuffer(1, 2, 3, 4, 5, 6)
// Is any element negative
test.exists(x => x < 0)

// Are all elements even
test.forall(x => x % 2 == 0)

///// Other types of collections
// mutable.HashMap
// Set is a collection that contains only one instance of a given element
// BitSet is a mutable collection that contains a set of bits
// LazyList is a type of sequence that can have infinite length


////////////////////

val l1 = List.empty[Int]
val l2 = 1 +: 2 +: 3 +: l1
val l3 = l2 ++ List(4, 5, 6)
val l4 = l3.filter(x => x % 2 == 0)
val result = l4.exists(x => x == l4.size)
