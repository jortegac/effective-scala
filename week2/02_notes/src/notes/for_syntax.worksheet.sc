
val namesAndSwissNumbers: List[(String, String)] = 
    contacts.flatMap { contact => 
        contact.phoneNumbers
            .filter(phoneNumber => phoneNumber.startsWith("+41"))
            .map(phoneNumber => (contact.name, phoneNumber))
    }

// Rewrite using for syntax

val namesAndSwissNumbers_2: List[(String, String)] = 
    for {
        contact <- contacts
        phoneNumber <- contact.phoneNumbers
        if phoneNumber.startsWith("+41")
    } yield (contact.name, phoneNumber)

// The general form of the for syntax is: for(s) yield e
// Where s is a sequence of generators and filters
// And e is an expression whose value is returned by an iteration

// A generator is of the form p <- e, where p is a pattern and e an expression whose value is a collection
// A filter is of the for if f where f is a boolean expression
// The sequence must start with a generator
// If there are several generators in the sequence, the last generators vary faster than the first ones

// To write imperative loops in Scala, we use the for ( ) do syntax
// for x <- e1 do s
// It translates to e1.foreach(x => s)