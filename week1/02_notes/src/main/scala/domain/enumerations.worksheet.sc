// Convenient contruct for modeling a trype that has one of several possible singleton values

// An enum define a type and its comapion object, which in turn defines the possible values of 
// the enumeration, and additional operations such as values and valueOf

enum PrimaryColor:
    case Red, Blue, Green

def isProblematicForColorBlindPeople(color: PrimaryColor): Boolean = 
    color match
        case PrimaryColor.Blue => true
        case PrimaryColor.Green => false
        case PrimaryColor.Red => true
    
isProblematicForColorBlindPeople(PrimaryColor.Green)

PrimaryColor.values

PrimaryColor.valueOf("Blue")

// Enums are kind of equivalente to 

sealed trait Shape
object Shape:
    case object Square extends Shape
    case object Circle extends Shape
    case object Triangle extends Shape
    val values = Array(Square, Circle, Triangle)