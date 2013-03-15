package e5_Recursif

import e1_Syntaxe.HandsOnSuiteP1

 /**
 * Write a recursive function that counts how many different ways you can make change for an amount, given a list of coin denominations.
 * For example, there are 3 ways to give change for 4 if you have coins with denomiation 1 and 2: 1+1+1+1, 1+1+2, 2+2.
 * Do this exercise by implementing the countChange function in Main.scala.
 * This function takes an amount to change, and a list of unique denominations for the coins. Its signature is as follows:
 *
 * def countChange(money: Int, coins: List[Int]): Int
 * you can make use of functions isEmpty, head and tail on the list of integers coins.
 *
 * Hint: Think of the degenerate cases. How many ways can you give change for 0 Eur? How many ways can you give change for >0 EUR, if you have no coins?
 **/
object CountChange {
  def countChange(money: Int, coins: List[Int]): Int = ???
}

class e2_CountingChange extends HandsOnSuiteP1 {
  import CountChange.countChange

  test("example from instructions") {
    countChange(4,List(1,2)) should be(3)
  }

  test("sorted CHF") {
    countChange(300,List(5,10,20,50,100,200,500)) should be(1022)
  }

  test("no pennies") {
    countChange(301,List(5,10,20,50,100,200,500)) should be(0)
  }

  test("unsorted CHF") {
    countChange(300,List(500,5,50,100,20,200,10)) should be(1022)
  }
}