import scala.concurrent.Future
/*
import scala.util.control.NonFatal
// You can sequentially chain to asynchronous computations by using flatMap

// To join not just two asynchronous computations, but an arbitrary number of asynchronous computations. You can use the operation traverse.

type User

val userData: Seq[(String, String)] = Seq(
  "Alice" -> "somePassword",
  "Bob" -> "otherPass"
)
*/
/*
val eventualUsers: Future[Seq[User]] =
  Future.traverse(userData)(hashPasswordAndInsert)

// Failure handling
// We represent failures with -failed- Future values containing an exception.
// Like with -Try-, we can handle these failures with the operation recover

val eventuallyInserted: Future[Boolean] =
  hashPasswordAndInsert("Alice", "somePassword")
    .map(_ => true)
    .recover { case NonFatal(exception) => false }
*/
// You can build sequential path of computations with map and flatMap, and you can build a parallel path of computations
// with zip and traverse. Finally, you can recover from failures with recover and recoverWith.

import scala.concurrent.ExecutionContext.Implicits.global

for
  _ <- Future(println("A"))
  _ <- Future(println("B"))
yield ()