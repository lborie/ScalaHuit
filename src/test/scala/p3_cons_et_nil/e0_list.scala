package p3_cons_et_nil


import support.HandsOnSuite


class e0_list extends HandsOnSuite {


  sealed trait List[+A] {

    def map[B](fonction:A => B):List[B]

    def flatMap[B](fonction:A => List[B]):List[B]

    def filter(fonction:A => Boolean):List[A]

    final def union[B >: A](list:List[B]):List[B]= {
      this match {
        case Cons(head,tail) => Cons(head, ???)
        case Nil => ???
      }
    }

    //def isEmpty:Boolean
  }

  object List {
    // 'A*' signifie var args de A
    def apply[A](values:A*):List[A] = {
      if (values.isEmpty) {
        Nil
      } else {
        // ':_*' permet d'étendre une list en var args
        (Cons(values.head, List(values.tail:_*)))
      }
    }
  }
  /**
   * Cons veut dire Constructor, c'est lui qui permet de construire la liste en ajoutant un élément à la queue
   */
  case class Cons[A](head:A, tail:List[A]) extends  List[A] {

    def map[B](fonction:A => B):List[B] = ???


    /**
     * l'implémentation de flatMap a besoin d'union
     */
    def flatMap[B](fonction:A => List[B]):List[B] = ???

    def filter(fonction:A => Boolean):List[A] = ???

  }

  /**
   * il y a qu'un seul Nil, donc cela peut être un case object
   */
  case object Nil extends List[Nothing] {
    type A = Nothing

    def map[B](fonction:A => B):List[B]  = ???

    def flatMap[B](fonction:A => List[B]):List[B] = Nil

    def filter(fonction:A => Boolean):List[A] = ???
  }

  test("création") {

    List() should be(Nil)

    List(1,2,3) should be(Cons(1,Cons(2,Cons(3,Nil))))

  }

  test("map") {
    List(1,2,3).map(x => x + 1) should be(List(2,3,4))
  }


  test("union") {

    List(1,2,3).union(List(4,5)) should be(List(1,2,3,4,5))

    List(1,2,3).union(List("A","B","C")) should be(List(1,2,3,"A","B","C"))
    // Cet example est un peu complexe, le compilateur cherche un B pour l'union tel que
    // String <: B et A (ici Int) <: B
    // Le type qui convient est Any, l'équivalent de Object en Java

    // Il n'y a rien a faire de particulier pour que cet example marche, le compilateur fait tout.

  }

  test("flatMap") {

    val combinaison = for (a <- List("A","B"); i <- List(1,2)) yield (a + i)

    combinaison should be( List("A1","A2","B1","B2"))

  }

  test("filter") {

    List(1,2,3).filter(x => x > 1) should be(List(2,3))

    List(1,2,3).filter(x => false) should be(Nil)
  }


}
