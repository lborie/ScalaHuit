import org.scalatest.Tag
import support.HandsOnSuite


/**
 * ceci est un I_Syntaxe object, c'est un truc cool ce Scala qui permet d'avoir des fonctions utilitaires ou autres
 */
package object I_Syntaxe {

  trait HandsOnSuiteP1 extends support.HandsOnSuite {
    override protected def test(testName: String, testTags: Tag*)(testFun: => Unit) {
      super.test(testName, (testTags :+ (HandsOnSuite.partie1)):_*)(testFun)
    }
  }

}