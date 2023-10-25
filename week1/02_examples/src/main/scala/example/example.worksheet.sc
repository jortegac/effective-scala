1 + 1

val x = 42

x * x

var y = x * 5

y = y * y

"abc" * 5

"julian".toUpperCase()

// Infix
true && true

// Dot notation
true.&&(true)
3.+(3)

1 + 2.5

val facade = 5 * 3
val door = 1 * 2
facade - door

// Type mismatch
// true && "false"

// Explicit type
val area : Int = 5 * 3

// Should give error
// val test = 1 / 0
// test

// Return type is optional
// Indentation matters
// end statement is optional
def calculatePaintArea(facade: Double, window: Double) : Double =
    val door = 2 * 1
    val substractedArea = door + window * 2
    facade - substractedArea
end calculatePaintArea

calculatePaintArea(facade, door)

// Curly braces for the block is more of a Scala 2 thing
// Scala 3 still supports it
def marathonDuration(speed: Double): Double = {
    val distance: Double = 42.195
    val duration = distance * speed
    duration * 60 // Minutes
}

// Can have named args for readability
marathonDuration(speed = 12)
marathonDuration(14)

