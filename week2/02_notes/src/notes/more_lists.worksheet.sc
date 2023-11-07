// A list is empty (called Nil) or
// A pair containing a head and a tail
// Lists are immutable. If you want a different list, you have to create a new one


case class AddressBook(contacts: List[Contact])
case class Contact(name: String, email: String, phoneNumbers: List[String])

val alice = Contact("Alice", "alice@example.com", List())
val bob = Contact("Bob", "bob@example.com", List("+3165465465"))
val carol = Contact("Carol", "carol@example", List())

val addressBook = AddressBook(List(alice, bob, carol))

val contacts1 = List(alice, bob)

val contacts2 = carol :: contacts1

// Calling the list constructor with several items is equivalnt to prepending these elements to the empty list Nil
List(alice, bob) == alice :: bob :: Nil

// The :: operator is right-associative
alice :: bob :: Nil == Nil.::(bob).::(alice)

/////// Pattern matching
// Print first contact
addressBook.contacts match
    case contact :: tail => println(contact.name)
    case Nil => ("No contacts")

// Print second contact
addressBook.contacts.match
    case first :: second :: third :: Nil => println(second.name)
    case _ => println("Unexpected number of contacts")

val fruits = List("apples", "oranges", "pears")
fruits.head == "apples"
fruits.tail == List("oranges", "pears")
fruits.tail.head == "oranges"
fruits(0) == "apples"
fruits(2) == "pears"

// Random access is inneficient (linear time)