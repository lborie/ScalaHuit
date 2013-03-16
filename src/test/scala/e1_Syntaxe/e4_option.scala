package e1_Syntaxe


/**
 * Les options :
 * - http://www.scala-lang.org/api/current/index.html#scala.Option
 */

class e4_option extends HandsOnSuiteP1 {
  /**
   * Quelques tests rapides
   */
  test("None est égal à...None") {
    None should be(None)
  }

  test("None est identique à None") {
    val a = None
    // ici ed dénote le fait d'être identique, et == l'égalité
    a should be(None)
  }

  test("On peut convertir None en une String") {
    None.toString should be("None")
  }

  test("et en une liste aussi") {
    val a = None
    a.toList should be(List())
  }

  test("None est considéré comme vide") {
    None.isEmpty should be(true)
  }

  test("On ne peut pas caster None en n'importe quel objet") {
    intercept[ClassCastException] {
      assert(None.asInstanceOf[String] === classOf[ClassCastException])
    }
  }

  test("None peut être utilisé avec le type Option, plutôt qu'avec null") {
    val optional: Option[String] = None
    optional.isEmpty should be(true)
    optional should be(None)
  }

  test("Some est l'opposé de None pour le type Option") {
    val optional: Option[String] = Some("Some Value")
    (optional == None) should be(false)
    optional.isEmpty should be(false)
  }

  test("Option.getOrElse can be used to provide a default in the case of None") {
    val optional: Option[String] = Some("Some Value")
    val optional2: Option[String] = None
    optional.getOrElse("No Value") should be("Some Value")
    optional2.getOrElse("No Value") should be("No Value")
  }

}
