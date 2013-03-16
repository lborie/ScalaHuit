package support

import org.scalatest.{Tag, FunSuite}
import org.scalatest.matchers.ShouldMatchers

trait HandsOnSuite extends FunSuite with ShouldMatchers {
  def __ : Any = {
    throw new Exception("à méditer")
  }

  def ??? : Nothing = throw new Error("à méditer")

  type ??? = Nothing
  type *** = Any
}



object HandsOnSuite {
  object partie1 extends Tag("support.partie1")
  object partie2 extends Tag("support.partie2")
  object partie3 extends Tag("support.partie3")
  object partie4 extends Tag("support.partie4")
  object partie5 extends Tag("support.partie5")
}