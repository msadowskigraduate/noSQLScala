package Exercise7

/**
  * Created by sadowsm3 on 17.04.2018
  */
case class Osoba(var _name: String, var _surname : String) {
    var name: String = _name
    var surname : String = _surname

  override def equals(o: scala.Any): Boolean = {
    o match {
      case osoba: Osoba =>
        osoba.name == name && osoba.surname == surname
      case _ => false
    }
  }

  override def toString: String = name + " " + surname
}
