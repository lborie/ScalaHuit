package e5_Recursif


/**
 * Le Pattern de nombres suivant est appelé Triangle de Pascal.
 *
 *       1
 *      1 1
 *     1 2 1
 *    1 3 3 1
 *   1 4 6 4 1
 *   ...
 *
 * Il y a toujours un 1 au sommet de la pyramide, et chaque nombre dans la pyramide est la somme des deux nombres au dessus de lui.
 * Ecrivez une fonction qui calcule les éléments du triangle de pascale, de façon récursive.
 *
 * Dans la fonction à implémenter (def pascal(c: Int, r: Int): Int = ???), c est la colonne, et r la ligne.
 * On compte à partir de 0, du sommet
 * On retourne la valeur du chiffre présent aux coordonnées données.
 *
 * Par exemple :
 *    pascal(0,2)=1
 *    pascal(1,2)=2
 *    pascal(1,3)=3.
 **/

object Pascal {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Ecrire la fonction pascale, qui retourne la bonne valeur en fonction de ses coordonnées
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }
}

class e1_PascalSuite extends HandsOnSuiteP5 {

  import Pascal.pascal

  test("col=0,row=2") {
    pascal(0, 2) should be(1)
  }

  test("col=1,row=2") {
    pascal(1, 2) should be(2)
  }

  test("col=1,row=3") {
    pascal(1, 3) should be(3)
  }
}
