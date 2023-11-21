// Interfaces are defined by using trait
trait DatabaseAccess:
    def readData(): List[Data]

class PersistentDatabase(connection: Connection) extends DatabaseAccess:
    def readData(): List[Any] = ???

class InMemoryDatabase extends DatabaseAccess:
    def readData(): List[Any] = ???
        
