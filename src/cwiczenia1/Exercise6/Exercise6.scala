package Exercise6

/**
  * Created by sadowsm3 on 08.04.2018
  */
object Exercise6 {
  def main(args: Array[String]): Unit = {
    var konto1 = new KontoBankowe
    println(konto1.saldoKonta())
    konto1.wplata(55.5)
    println(konto1.saldoKonta())
    konto1.wyplata(65.5)
    println(konto1.saldoKonta())
    konto1.wyplata(35.45)
    println(konto1.saldoKonta())
    var konto2 = new KontoBankowe()
    println(konto2.saldoKonta)
  }
}
