// We will look at iterating on standard collection, imperative loops with the control structure while, and functional loops with recursion

// Implement factorial with foldLeft
// We creat a collection of 1 to n and then we compute the product of all the elements in the collection
def factorialFoldLeft(n: Int): Int =
    (1 to n).foldLeft(1)((result, x) => result * x)

factorialFoldLeft(4)

// There is the operation product
(1 to 4).product

// Ranges
1 to 4
0 to 10 by 2
5 until 0 by -1
10 until 0 by -2

// Factorial using a while loop
def factorialWhile(n: Int): Int =
    var acc = 1
    var i = 1
    while i < n do
        i += 1
        acc *= i
    acc

factorialWhile(4)

// Factorial with recursion
def factorialRec(n: Int): Int =
    if n == 1 then 1
    else n * factorialRec(n - 1)

factorialRec(4)


/////////////////////

case class Position(x: Double, y: Double):
    def distanceTo(that: Position): Double = ???
    def distanceToLine(line: (Position, Position)): Double = ???

object Position:
    val player = Position(0, 1.80)
    val hoop = Position(6.75, 3.048)

case class Angle(radians: Double)
case class Speed(metersPerSecond: Double)

def isWinningShot(angle: Angle, speed: Speed): Boolean =
    val v0X = speed.metersPerSecond * math.cos(angle.radians)
    val v0Y = speed.metersPerSecond * math.sin(angle.radians)
    val p0X = Position.player.x
    val p0Y = Position.player.y
    val g = -9.81

    def goesThroughHoop(line: (Position, Position)): Boolean =
        Position.hoop.distanceToLine(line) < 0.01

    def isNotTooFar(position: Position): Boolean =
        position.y > 0 && position.x <= Position.hoop.x + 0.01

    def position(t: Int): Position =
        val x = p0X + v0X * t
        val y = p0Y + v0Y * t + 0.5 * g * t * t
        Position(x, y)

/* 
    // Algotithm with LazyList 
    val timings: LazyList[Int] = LazyList.from(0)
    val positions: LazyList[Position] = timings.map(position)
    val lines = positions.zip(positions.tail)
    lines
        .takeWhile((p1, _) => isNotTooFar(p1))
        .exists(goesThroughHoop)
*/

/*
    // Algorithm with while
    var time = 0
    var previousPosition = position(time)
    var isWinning = false
    while isNotTooFar(previousPosition) && !isWinning do 
        time += 1
        val nextPosition = position(time)
        val line = (previousPosition, nextPosition)
        isWinning = goesThroughHoop(line)
        previousPosition = nextPosition
    isWinning
*/

    // Algorithm with recursive method
    def loop(time: Int): Boolean = 
        val currentPosition = position(time)
        if isNotTooFar(currentPosition) then
            val nextPosition = position(time + 1)
            val line = (currentPosition, nextPosition)
            goesThroughHoop(line) || loop(time + 1)
        else
            false

    loop(time = 0)

end isWinningShot

val angle = Angle(1.4862)
val speed = Speed(20)
isWinningShot(angle, speed)


///////////////////////////////////////////////////////////////

case class Task(name: String, duration: Int, requirements: List[Task])

val csSetup = Task("cs Setup", 4, Nil)
val ide = Task("IDE", 3, Nil)
val hack = Task("hack", 8, List(csSetup, ide))
val deploy = Task("deploy", 3, List(hack))


def maxTotalDuration(tasks: List[Task]): Int =
    tasks match
        case Nil => 0
        case head :: tail =>
            val headDuration = totalDuration(head)
            val tailDuration = maxTotalDuration(tail)
            if headDuration < tailDuration then tailDuration
            else headDuration
    

def totalDuration(task: Task): Int =
    task.duration + maxTotalDuration(task.requirements)

totalDuration(deploy)

//// With built in methods

def totalDuration2(task: Task): Int =
    val requirementsMaxTotalDuration = task.requirements.map(totalDuration).maxOption.getOrElse(0)
    task.duration + requirementsMaxTotalDuration

totalDuration2(deploy)