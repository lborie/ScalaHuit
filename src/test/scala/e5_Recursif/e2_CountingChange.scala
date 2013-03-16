package e5_Recursif


/**
 * L'objectif est d'écrire une fonction récursive (countChange) qui compte de combien de façon différente vous pouvez faire la monnaie
 * sur un montant donné, avec une liste de pièces pré définies.
 * Par exemple, il y a 3 façons de donner la monnaie sur "4", si vous avez des pièces de 1 et de 2 : 1+1+1+1, 1+1+2, 2+2.
 * Write a recursive function that counts how many different ways you can make change for an amount, given a list of coin denominations.
 *
 * Cette fonction countChange prend un montant comme paramètre, et une liste de pièces uniques disponibles. Donc sa signature est :
 *
 * def countChange(money: Int, coins: List[Int]): Int
 *
 * Pensez à utiliser les fonctions isEmpty, head et tail sur la liste de pièces.coins.
 *
 * Astuce: Pensez aux cas limites. De combien de façon différentes pouvez vous changer 0 Eur ?
 * Et pour une somme >0 EUR, si vous n'avez pas de pièce ?
 **/
object CountChange {
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money <= 0) 0
    else if (coins.isEmpty) 0
    else if (coins.head == money) 1 + countChange(money, coins.tail)
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}

class e2_CountingChange extends HandsOnSuiteP5 {

  import CountChange.countChange

  test("example from instructions") {
    countChange(4, List(1, 2)) should be(3)
  }

  test("sorted CHF") {
    countChange(300, List(5, 10, 20, 50, 100, 200, 500)) should be(1022)
  }

  test("no pennies") {
    countChange(301, List(5, 10, 20, 50, 100, 200, 500)) should be(0)
  }

  test("unsorted CHF") {
    countChange(300, List(500, 5, 50, 100, 20, 200, 10)) should be(1022)
  }
}