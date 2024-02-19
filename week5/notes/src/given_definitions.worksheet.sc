// For the context parameter to work, Ordering.Int must be a "given" definition:
// This code defines a given instance of type Ordering[Int], name Int.
// The instance is initialized the first time it is used
{
  object Ordering
  given Int: Ordering[Int] with
    def compare(x: Int, y: Int): Int =
      if x < y then -1
      else if x > y then 1
      else 0

  // An alias can be used to define a given instance that is equal to some expression:
  object IntOrdering extends Ordering[Int]:

  def compare(x: Int, y: Int): Int =
    if x < y then -1
    else if x > y then 1
    else 0

  given intOrdering: Ordering[Int] = IntOrdering
}
// Given definitions can be anonymous:
{
given Ordering[Double] with
  def compare(x: Double, y: Double): Int =
    if x < y then -1
    else if x > y then 1
    else 0
}
// The compiler will synthesize a name for an anonymous given definition:
{
given given_Ordering_Double: Ordering[Double] with
  def compare(x: Double, y: Double): Int =
    if x < y then -1
    else if x > y then 1
    else 0
}

// Full example
{
  trait Ordering[A]:
    def compare(a1: A, a2: A): Int

  object Ordering:
    given Int: Ordering[Int] with
      def compare(a1: Int, a2: Int): Int =
        if a1 < a2 then -1
        else if a1 > a2 then 1
        else 0

    given String: Ordering[String] with
      def compare(s1: String, s2: String): Int = ???

    def sort[A](as: List[A])(using Ordering[A]): List[A] = ???

    sort(List(1, 2, 3))
    sort(List("a", "b", "c"))
}
{
  case class Num(value: Int)

  given n: Num = Num(42)

  def f(using x: Num): Int = x.value

  println(f)
}
{
  case class Num(value: Int)

  given n: Num = Num(42)

  def f(using x: Num): Int = x.value

  println(f(using Num(0)))
}
{
  trait Show[A]:
    def apply(a: A): String

  object Show:
    given Show[Int] with
      def apply(n: Int): String = s"Int($n)"

  def printValue[A: Show](a: A): Unit =
    println(summon[Show[A]].apply(a))

  printValue(42)
}
{
  println(List(1, 2, 3).min)
}