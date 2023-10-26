import java.awt.Shape
case class Rectangle(width: Int, height: Int):
    val area = width * height

val rectangle = Rectangle(2, 5)
rectangle.area

case class Square(side: Int):
    val area: Int = side * side

val square = Square(5)
square.area

case class Circle(radius: Double):
    val area = Math.PI * radius * radius

val circle = Circle(3)
circle.area

// Case classes are immutable, but we can use copy. Can supply new values for some or all fields
val newRectangle = rectangle.copy(height = 2)
newRectangle.area


// Sealed Traits
sealed trait Shape
case class Rectangle(width: Int, height: Int) extends Shape
case class Circle(radius: Int) extends Shape

// Sealed traits don't introduce constructors. Traits are abstract types
val someShape: Shape = Circle(4)

// A value of type Rectangle or Circle is also of type Shape
val someRectangle: Rectangle = Rectangle(1, 3)
val someOtherShape : Shape = someRectangle

val someShapeArea = 
    someShape.match
        case Rectangle(width, height) => width * height
        case Circle(radius) => radius * radius * Math.PI
    