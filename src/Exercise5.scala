/**
  * Created by sadowsm3 on 08.04.2018
  */
object Exercise5 {
  def main(args: Array[String]): Unit = {
    val weekDays = List("PONIEDZIALEK", "WTOREK", "SRODA", "CZWARTEK", "PIATEK", "SOBOTA", "NIEDZIELA", "FAKEDAY")
    weekDays.foreach(x => println(patternMatching(x)))
  }

  def patternMatching(x : String) :String = x match {
    case "PONIEDZIALEK" => "PRACA"
    case "WTOREK" => "PRACA"
    case "SRODA" => "PRACA"
    case "CZWARTEK" => "PRACA"
    case "PIATEK" => "PRACA"
    case "SOBOTA" => "WEEKEND"
    case "NIEDZIELA" => "WEEKEND"
    case _ => "NIE MA TAKIEGO DNIA"
  }
}
