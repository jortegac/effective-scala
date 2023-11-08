// Domain-agnostic data structures and utility functions.
// Collections, error management, math functions, asynchronous execution

// Lists

case class AddressBook(contacts: List[Contact])
case class Contact(name: String, email: String, phoneNumbers: List[String])

val alice = Contact("Alice", "alice@example.com", List())
val bob = Contact("Bob", "bob@example.com", List("+3165465465"))

val addressBook = AddressBook(List(alice, bob))

///

val fruits = List("apples", "oranges", "pears")
val nums = List(1, 2, 3, 4)
val dia3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
val empty = List()

///

val numberOfContacts : Int = addressBook.contacts.size
val isAliceInContacts: Boolean = addressBook.contacts.contains(alice)
val contactNames: List[String] = addressBook.contacts.map(contact => contact.name)
val contactsWithPhone: List[Contact] = addressBook.contacts.filter(contact => contact.phoneNumbers.nonEmpty)

