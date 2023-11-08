import scala.collection.mutable

// Sequences are collections with a well defined order
// List and ArrayBuffer are sequences

val data = mutable.ArrayBuffer(1, 2, 3)
data.head
data.tail

// Lists are linear sequences requires that you iterate over the elements. In other words it is O(n)
// Array buffers are indexed sequences. They are O(1)

// Sorting
val friends = List(
    "Alice" -> 42,
    "Dave" -> 10,
    "Bob" -> 23,
    "Charlie" -> 12
)

friends.sortBy((_, age) => age)

friends.sortBy((name, _) => name)