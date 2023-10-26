import java.awt.Desktop.Action
// Sealed Traits
sealed trait Shape
case class Rectangle(width: Int, height: Int) extends Shape
case class Circle(radius: Int) extends Shape

// Sealed traits don't introduce constructors. Traits are abstract types
val someShape: Shape = Circle(4)

// A value of type Rectangle or Circle is also of type Shape
val someRectangle: Shape = Rectangle(1, 3)
val someOtherShape : Shape = someRectangle

val someShapeArea = 
    someShape.match
        case Rectangle(width, height) => width * height
        case Circle(radius) => radius * radius * Math.PI

// _ is a wildcard pattern
someRectangle match
    case circle: Circle => "This is a circle"
    case _ => "This is not a circle"

def area(shape: Shape): Double =
  shape match
    case Rectangle(w, h) => w * h
    case Circle(r)       => r * r * 3.14

area(someRectangle)

/////////////////////////////

sealed trait Action
case class Subscribe(channel: Channel) extends Action
case class Unsusbcribe(channel: Channel) extends Action
case class PostMessage(channel: Channel, message: String) extends Action

case class Channel(name: String)

val subscribeToEffectiveScala = Subscribe(Channel("effective-scala"))

// A sealed trait represents one of several alternatives. Case classes and sealed traits 
// are the building blocks for modeling business domains in Scala, match expressions 
// can be used to define alternative branches of a program according to the concrete class 
// of a sealed trait and to extract data from this class at the same time.