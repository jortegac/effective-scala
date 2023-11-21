// Case classes achieve aggregation
// Classes achieve encapsulation

// Case classes:
// Constructor parameters of case classes are public (aka fields)
// A case class has an extractor that enables pattern matching
// Equality operator between instances compares the values of the case class fields


case class CaseClass(value: Int)
// True
CaseClass(42) == CaseClass(42)

class SimpleClass(value: Int)
// False
SimpleClass(42) == SimpleClass(42)
