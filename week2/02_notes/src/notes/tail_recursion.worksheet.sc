// Factorial with recursive solution
def factorial(n: Int): Int = 
  if (n == 0) then 1
  else n * factorial(n - 1)

factorial(5)
//factorial(1000000) // StackOverflowError

// Factorial with tail recursion
def factorialWithTailRecursion(n: Int): Int =
    def factorialTailRec(x: Int, accumulator: Int): Int =
        if (x == 0) then accumulator
        else factorialTailRec(x - 1, x * accumulator)
    factorialTailRec(n, 1)
end factorialWithTailRecursion

factorialWithTailRecursion(5)
factorialWithTailRecursion(1000000)