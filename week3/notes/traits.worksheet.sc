// The only difference bwtween sealed traits and simple traits is that the fixed traits have a fixed number of concrete subclasses, in constrast to an unlimited number of subclasses
// More precisely, the subclasses of a sealed trait have to be defined in the same file as the sealed trait
// A practical consequence is tha exhaustive checking in pattern matching in only possible with sealed traits

// Both sealed traits and simple traits:
// Define a new type with no constructor
// Can have concrete and abstract memebers
// Can have public, protected, and private members
// Can create abstraction levels

