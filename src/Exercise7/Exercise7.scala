package Exercise7

/**
  * Created by sadowsm3 on 17.04.2018
  */
object Exercise7 {
  def main(args: Array[String]): Unit = {
    val osoba1 = new Osoba("Michal", "Sadowski")
    val osoba2 = new Osoba("Julia", "Ziemska")
    val osoba3 = new Osoba("Mateusz", "Filipowicz")

    val list: List[Osoba] = List(osoba1, osoba2, osoba3)
    list.foreach(s => println(greet(s)))
  }

  def greet(osoba: Osoba): String = {
    osoba match {
      case Osoba("Michal","Sadowski") => s"Czesc $osoba"
      case Osoba("Julia","Ziemska") => s"Hello $osoba"
      case Osoba("Mateusz","Filipowicz") => s"Guten Tag $osoba"
      case _ => "Witaj nieznajomy"
    }
  }
}
