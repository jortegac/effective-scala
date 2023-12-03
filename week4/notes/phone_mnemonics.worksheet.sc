class Mnemonics(dictionary: Set[String]):

  private val keys: Map[Char, String] = Map(
    '2' -> "ABC",
    '3' -> "DEF",
    '4' -> "GHI",
    '5' -> "JKL",
    '6' -> "MNO",
    '7' -> "PQRS",
    '8' -> "TUV",
    '9' -> "WXYZ"
  )

  private val letterToDigit: Map[Char, Char] =
    for
      (digit, letters) <- keys
      letter           <- letters
    yield letter -> digit

  private def wordToDigits(word: String): String =
    word.toUpperCase.map(letterToDigit)

  private val index: Map[String, Set[String]] =
    dictionary.groupBy(wordToDigits)

  def ofPhoneNumber(digits: String): Seq[Seq[String]] =
    if digits.isEmpty then Seq(Nil)
    else
      for
        splitPoint <- 1 to digits.length
        (firstDigits, remainingDigits) = digits.splitAt(splitPoint)
        word  <- index.getOrElse(firstDigits, Nil)
        words <- ofPhoneNumber(remainingDigits)
      yield word +: words

end Mnemonics

val dictionary = Set(
  "Scala",
  "rocks",
  "is",
  "fun",
  "love",
  "thank",
  "me",
  "you",
  "of"
)

val mnemonics = Mnemonics(dictionary)

mnemonics.ofPhoneNumber("7225276257")

mnemonics.ofPhoneNumber("7225247386")

mnemonics.ofPhoneNumber("7225284265968")

mnemonics.ofPhoneNumber("968568363")
