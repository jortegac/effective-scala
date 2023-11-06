//Functions are like methods. They have parameters and they return a result

val increment: Int => Int =
    x => 
        val result = x + 1
        result

val add = 
    (x: Int, y: Int) => x + y

add(1, increment(2))

// A key difference between functions and methods is that functions define a value that can be passed as a parameter or returned as a result. 
// The runtime creastes an boject for them in memory. As such, functions are objects

// Calling a function means calling its method apply:
increment(41)
increment.apply(41)


// When a function uses its argument only once, you don’t have to give it a name. Instead, you can use the so-called placeholder syntax like the following:

val increment_2: Int => Int = _ + 1
val endsWithExampleDotCom: String => Boolean = _.endsWith("@example.com")

val increment_3: Int => Int = x => x + 1
increment_3(41)

val increment_4 = (x: Int) => x + 1
increment_4(41)

val increment_5 = (_: Int) + 1
increment_5(41)

//

val add_2: (Int, Int) => Int = _ + _
add_2(1, 2)

val add_3: (Int, Int) => Int = (x1, x2) => x1 + x2
add_3(1, 2)
