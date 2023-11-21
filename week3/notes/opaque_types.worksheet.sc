case class User(name: String, age: Int)

// Type alisases incur no runtime costs (there are no classes added) and can be interchangeably used with the type they are an alias to
type AgeAndUsers = (Int, Seq[User])

val users: Seq[User] = List(User("John", 25), User("Lisa", 29), User("Carol", 29))

val userByAge: Iterable[AgeAndUsers] = 
    users.groupBy(user => user.age)


/////////////////
// Opaque type aliases

object UserID:
    opaque type UserID = Long
    // By definition, there is nothing one can do with a value of type UserID
    // The object that define the opaque type alias should also define methods that produce and consume opaque types
    def parse(string: String): Option[UserID] = string.toLongOption
    def value(userID: UserID): Long = userID

object VehicleID:
    opaque type VehicleID = Long

import UserID.UserID
import VehicleID.VehicleID

case class Vehicle(vehicleID: VehicleID)

def findVehicle(vehicleID: VehicleID): Option[Vehicle] = ???

def mistake(userID: UserID): Unit =
    //findVehicle(userID)
    ???
