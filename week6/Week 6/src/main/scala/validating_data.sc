type Validated[A] = Either[Errors, A]

val validInt: Validated[Int] = Right(42)
val invalidInt: Validated[Int] = Left(Seq("Invalid Integer"))

validInt match
  case Right(n) => println(s"Valid integer: $n")
  case Left(errors) => println(s"Invalid integers: $errors")

// Like with Try, we can use the operation map to transform a valid (right) value without having to deal with cases

validInt.map(n => n + n)
invalidInt.map(n => n + n)

// We need an operation for combining validated values

def validateBoth[A, B](
  validatedA: Validated[A],
  validatedB: Validated[B]
): Validated[(A, B)] =
  (validatedA, validatedB) match
  case (Right(a), Right(b)) => Right((a, b))
  case (Left(e), Right(_)) => Left(e)
  case (Right(_), Left(e)) => Left(e)
  case (Left(e1) , Left(e2)) => Left(e1 ++ e2)


////////////////////

// You can
// - transform valid values with map
// - chain validation rules with flatMap
// - aggregate valid values (accumulating validation errors) with validateBoth
// - validate a collection of values with validateEach
