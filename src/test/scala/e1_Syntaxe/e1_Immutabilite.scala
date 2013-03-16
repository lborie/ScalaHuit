package e1_Syntaxe

/**
 * Immutabilité ?
 */
class e1_Immutabilite extends HandsOnSuiteP1 {

  test("Les vars peuvent être réaffectées") {
    var a = 5
    a should be(5)

    a = 7
    a should be(7)
  }

  test("Par contre les vals sont immuables (équivalent de final Java), elles ne peuvent pas être réaffectées") {
    val a = 5
    a should be(5)

    // Qu'est-ce qui se passe lorsque l'on ajoute ces lignes ?
    // a = 7
    // a should be (7)
  }
}
