{
  case class Rational(num: Int, denom: Int)


  given Ordering[Rational] with
    override def compare(x: Rational, y: Rational): Int =
      x.num * y.denom - x.denom * y.num

  val rationals = List(Rational(6, 2), Rational(7, 3), Rational(5, 4), Rational(20, 2))

  rationals.sorted
}


