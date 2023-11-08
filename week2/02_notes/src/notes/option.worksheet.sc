// Option is a special type of collection that has at most one element.
// An option is either Some(T) or None.

// Optional values have similar operations as collections (map, filter, flatMap, foldLeft, isEmpty, contains, etc.)

case class Contact(
    name: String,
    maybeEmail: Option[String],
    phoneNumbers: List[String]
)

val alice = Contact("Alice", Some("alice@example.com"), List(""))
val bob = Contact("Bob", None, List("123-456-7890"))
val carol = Contact("Carol", Some("carol@example.com"), List("123-456-7890"))

// It is common practice to prefix identifiers of optional values with "maybe".

def hasExampleDotComEmail(contact: Contact) : Boolean =
    contact.maybeEmail match
        case Some(email) => email.contains("@example.com")
        case None => false

hasExampleDotComEmail(alice)    
hasExampleDotComEmail(bob)

// The operation getOrElse returns the value of the optional value if it is defined, otherwise it returns the default value.

def emailLength(contact: Contact): Int =
    contact.maybeEmail
        .map(email => email.size)
        .getOrElse(0)

emailLength(alice)
emailLength(bob)

// The operation zip combines two optional values into a single optional value that contains a pair.
// The resulting values is defined if both values are defined.
val maybeAliceAndBobEmails: Option[(String, String)] =
    alice.maybeEmail.zip(bob.maybeEmail)

val maybeAliceAndCarolEmails: Option[(String, String)] =
    alice.maybeEmail.zip(carol.maybeEmail)

// Collection operation returning an Option
// Find returns None in case no elements are found.
// headOption on List returns the first element of the list or None if the list is empty.

def sendNotifications(contact: Contact, message: String): Unit =
    contact.phoneNumbers.headOption match
        case Some(phoneNumber) => println(s"Sending notification to $phoneNumber")
        case None =>
            contact.maybeEmail match
                case Some(email) => println(s"Sending notification to $email")
                case None => ()
            
    