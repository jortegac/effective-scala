// connection is private
class DatabaseAccess(connection: Connection):
    // Class members are public by default
    def readData(): List[Data] =
        ???
    // Private members have to be declared explicitly
    private def decodeTableRow(row: TableRow): Data =
        ???
    
    
// This code defines a type DatabaseAccess and a constructor of the same name. The type DatabaseAccess has one methods: readData
// By contrast with the case classses, Cosutrctor parametners of "simple" classes are private: they can be accessed only from the class body
// This highlishgt one difference between case classes and simple classes: the case classes achieve aggreation whereas the simple classes achieve encapsulation