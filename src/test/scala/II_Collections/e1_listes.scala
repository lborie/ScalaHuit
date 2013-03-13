package II_Collections

import I_Syntaxe.HandsOnSuiteP1

/**
* On passe aux LISTES
*/ 

class e1_listes extends HandsOnSuiteP1{


  /**
  *  ça peut servir : http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.List
  */


  /**
  * Nil est et restera la liste vide quelque soit le typage de la liste !
  */
  test("Les listes Nil, quelque soit leur type sont identiques") {
    val a: List[String] = Nil
    val b: List[Int] = Nil

    (a == Nil) should be(__)
    (b == Nil) should be(__)
    (a == b) should be(__)

  }

  /**
  * Attention, on as vu cet exemple dans l'exo 2 sur les cases classes !
  */
  test("Eq teste l'égalité d'objet") {
    val a = List(1, 2, 3)
    val b = List(1, 2, 3)

    (a eq b) should be(__)
  }

  /**
  *  Quelques méthodes utiles à retenir
  */
  test("Les fonctions head et tail") {
    val a = List(1, 3, 5, 7, 9)

    // accès à l'élément 2 de la liste
    a(2) should equal(__)
    // ça prend la tête...
    a.head should equal(__)
    // ah non ça prend tout, sauf la tête
    a.tail should equal(__)
    // longeur de la liste
    a.length should equal(__)
    // inverse de la liste
    a.reverse should equal(__)
    // converti une liste en String
    a.toString should equal(__)

    // multiplie par 3 chaque élément de la liste
    a.map {
      v => v * 3
    } should equal(__)
    // conserve tous les multiple de 3
    a.filter {
      v => v % 3 == 0
    } should equal(__)
    // conserve tous les multiple de 3
    val c = List(1, 2, 5, 8, 9)
    val b = c.filterNot(v => v == 5)
    c should equal(List(1, 2, 5, 8, 9)) // les listes sont immutables par défaut !
    b should equal(__) 
  }

  /**
  * L'utilisation de "_" qui désigne tout ce qui n'a pas beson d'être nommé
  */
  test("Les fonctions appliquées aux listes peuvent utiliser '_' ") {
    val a = List(1, 2, 3)
    a.map(_ * 2) should equal(__)
    a.filter(_ % 2 != 0) should equal(__)
  }
}
