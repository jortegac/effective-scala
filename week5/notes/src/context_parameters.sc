{
  import scala.math.Ordering
  val list = List(99, 2, 75, 3, 1, 1)

  def sort[T](list: List[T])(ord: Ordering[T]): List[T] = {
    if ord.lt(x, y) then
      ???
    }

  sort(list)(Ordering.Int)
}

// We can let the compiler know that we expect it to pass the ord argument byt making it a context parameter
{
  import scala.math.Ordering

  val list = List(99, 2, 75, 3, 1, 1)

  def sort[T](list: List[T])(using ord: Ordering[T]): List[T] = {
    if ord.lt(x, y) then
      ???
  }
  // Then we call call the function just as
  sort(list)

  // The compiler infers the argument value based on its expected type
}
{
  // There is a shorter, alternate syntax for context parameters
  def sort[A: Ordering](list: List[A]): List[A] = ???
}
{
  // We say the the ype parameteer A has one context bound: Ordering
  // This is equivalent to the following signature:
  def sort[A](list: List[A])(using Ordering[A]): List[A] = ???
}