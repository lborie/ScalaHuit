import org.scalatest.Tag
import support.HandsOnSuite


/**
 * ceci est un e1_Syntaxe object, c'est un truc cool ce Scala qui permet d'avoir des fonctions utilitaires ou autres
 */
package object e4_Fonctionnel {

  trait HandsOnSuiteP4 extends support.HandsOnSuite {
    override protected def test(testName: String, testTags: Tag*)(testFun: => Unit) {
      super.test(testName, (testTags :+ (HandsOnSuite.partie4)): _*)(testFun)
    }
  }

}
