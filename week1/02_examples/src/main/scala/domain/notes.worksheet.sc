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
