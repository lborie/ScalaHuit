package e6_PatternMatching

/**
 * Un pattern matching est capable de reconnaitre la
 * structure d'une Collection
 */
object e1_Collections {
  def taille(list: List[Any]) : Int = {
    list match {
      case Nil => 0
      case head :: tail => 1 + taille(tail)
    }
  }
}

class e1_Collections extends HandsOnSuiteP6 {
  import e1_Collections.taille

  test("Sur les collections ?") {
    val myList = List("toto", "tata", 2, 3, 42)
    taille(myList) should be(5)
  }
}
