package e1_Syntaxe


/**
 * Passe très rapide sur les classes en Scala
 */

class e2_classes extends HandsOnSuiteP1 {

  // on peut définir des classes avec des paramètres val et var
  class ClassWithValParameter(val name: String) {

  }

  /**
   * Dans les cas où l'on a un paramètre immutable, on obtient naturellement un getter mais pas de setter
   */
  test("Le paramètre val définit un getter") {
    val aClass = new ClassWithValParameter("name goes here")
    aClass.name should be("name goes here")
  }

  class ClassWithVarParameter(var description: String) {

  }

  /**
   * Dans les cas où l'on a un paramètre mutable, on obtient naturellement un getter et un setter
   */
  test("Le paramètre var définit un getter et un setter") {
    val aClass = new ClassWithVarParameter("description goes here")
    aClass.description should be("description goes here")

    aClass.description = "new description"
    aClass.description should be("new description")
  }

  /**
   * Enfin on peut définir un paramètre privé
   */
  class ClassWithPrivateFields(name: String) {

  }

  test("champs privé d'une classe") {
    val aClass = new ClassWithPrivateFields("name")
    // NOTE: aClass.name n'est pas accessible
  }

}
