{ 
    object UserID:
        opaque type UserID = Long
        def parse(string: String): Option[UserID] = string.toLongOption
        def value(userID: UserID): Long = userID

    import UserID.UserID

    val userID: UserID = UserID.parse("321").get

    // To retrieve the underlying value we would write
    UserID.value(userID)

    // It would be more practical to write userID.value

}

{

    object UserID:
        opaque type UserID = Long
        def parse(string: String): Option[UserID] = string.toLongOption
        extension (userID: UserID)
            def value: Long = userID

    import UserID.UserID
    val userID: UserID = UserID.parse("321").get
    
    userID.value
}

///// We can extend other things as well

extension (n: Int)
    def isZero: Boolean = n == 0
    def ** (e: Int): Int = List.fill(e)(n).product

42.isZero
0.isZero
5 ** 3
**(2)(4)


///////
{
object Lengths:
  opaque type Meters = Double
  def Meters(value: Double): Meters = value
  extension (x: Meters)
    def + (y: Meters): Meters = x + y
    def show: String = s"$x m"

def usage(): Unit =
  import Lengths.*
  val twoMeters: Meters = Meters(2.0)
  val fourMeters: Meters = twoMeters + twoMeters
  println(fourMeters.show)
  println(show(fourMeters))

usage()
}