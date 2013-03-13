package IV_Fonctionnel

import support.HandsOnSuite
import util.Random
import scala.collection


class e0_une_mise_en_abime /* ou un sac de sac */ extends HandsOnSuite {



  case class Sac(contenu:Int, tagDeSac:Set[String] = Set("gros sac")) {

    /**
     * Certains appellent cette API : Functor , un mélange de terminator et de fonction.
     * Ces gens là ont en général une barbe et font un peu de théorie de catégorie.
     *
     *
     * @param fonction la fonction a appliquer à contenu
     * @return un Sac
     */
    def map(fonction:Int => Int):Sac = ???


    /** Honnêtement, ce n'est pas le concept le plus simple */

    /** mais il faut se lancer !!! :) */

    /**
     *
     * Les individus cités plus haut ont aussi un nom pour cette API : Bind.
     * A croire que ces individus ont une recette miracle pour trouver des noms à tout.
     *
     * @param fonction Hum hUm, la fonction à appliquer en fusionnant les contextes d'application (ici Sac) entre eux...
     * @return un Sac !
     */
    def flatMap(fonction:Int => Sac):Sac = {
      val res:Sac = ???
      res.copy(tagDeSac = ???)
    }
  }


  test("Je peux créer mon sac avec un seul entier, et faire des choses avec mon sac") {

    val monPetitSacDeZero = Sac(0, Set("petit sac") )

    monPetitSacDeZero.contenu should be(0)

    monPetitSacDeZero.copy(1) should be(__)

    def incrémenteUnSac(sac:Sac):Sac = sac.copy(sac.contenu + 1)

    incrémenteUnSac(monPetitSacDeZero).contenu should be(__)

    incrémenteUnSac(monPetitSacDeZero).tagDeSac should contain(__)

  }

  test("je peux appliquer une fonction à l'intérieur de mon sac") {
    /**
     *
     * Pour passer ce test il faut implémenter la fonction Map plus haut
     */
    val incrémente:(Int => Int) = (i:Int) => i + 1
    //l'équivalent avec def est :
    def incrémenteAvecDef(i:Int) = i + 1


    incrémente(0) should be(1)

    val monPetitSacDeZero = Sac(0, Set("petit sac"))

    monPetitSacDeZero.map(incrémente).contenu should be(1)
    monPetitSacDeZero.map(incrémente).tagDeSac should contain("petit sac")
  }

  test("je peux appliquer une expression en for sur mon sac") {
    /**
     * Ce test se base sur la fonction map implémentée précedement
     */

    val monPetitSacDeZero = Sac(0, Set("petit sac") )

    val monPetitSacDeUn  = (for (i <- monPetitSacDeZero) yield (i + __.asInstanceOf[Int]))

    /*
     * Le compilateur scala traduit cette boucle for par :
     *
     * monPetitSacDeZero.map(i => i + __.asInstanceOf[Int])
     */

    monPetitSacDeUn.contenu should be(1)




  }

  test("je peux appliquer une expression imbriquée dans mes Sac") {

    /**
     * Ce test se base sur la fonction flatMap a implémenter plus haut.
     */


    val monPetitSacDeDeux = Sac(2,Set("petit sac"))
    val monGrosSacDeCent = Sac(100, Set("gros sac"))

    val l_union_de_mes_sac = for (p <- monPetitSacDeDeux; g <- monGrosSacDeCent) yield( p * g)

    /**
     * Le compilateur scala traduit cette boucle for par :
     *
     * monPetitSacDeDeux.flatMap{ p => monGrosSacDeCent.map(g => p *g))
     */


    l_union_de_mes_sac.contenu should be(200)

    l_union_de_mes_sac.tagDeSac should be(Set("petit sac","gros sac"))
  }

}