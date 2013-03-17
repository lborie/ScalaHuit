package e6_PatternMatching

/**
 * hint : écrire la méthode calculate grâce à un Pattern Matching
 * operation match { case Operation(.... ) => ...... }
 */
object e2_Calculatrice {

  case class Operation(left: Double, right: Double, operande: String)

  def calculate(operation: Operation): Double = ???
}

class e2_Calculatrice extends HandsOnSuiteP6 {

  test("Calculatrice") {
    import e2_Calculatrice._

    calculate(Operation(5, 6, "+")) should be(11)
    calculate(Operation(5, 6, "-")) should be(-1)
    calculate(Operation(5, 6, "*")) should be(30)
    calculate(Operation(121, 11, "/")) should be(11)

  }
}
