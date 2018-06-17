package Exercise6

/**
  * Created by sadowsm3 on 08.04.2018
  */
class KontoBankowe(var stanKonta : Double) {
  private var _stanKonta = 0.0

  def this(){
    this(0.0)
  }
  def stanKonta_ (x : Double): Unit = _stanKonta = x

  def wyplata(x : Double): Double = {
    if(x < _stanKonta) {
      stanKonta_(_stanKonta - x)
      return x
    }
    0
  }
  def saldoKonta(): Double = {
    _stanKonta
  }
  def wplata(x : Double): Unit = {
    stanKonta_(_stanKonta + x)
  }

}
