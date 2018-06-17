package cwiczenia1

/**
  * Created by sadowsm3 on 17.04.2018
  */
object Exercise10 {
  def main(args: Array[String]): Unit = {
    val list = (-10.5f to 20.5f by 0.5f).toList
    println(list)
    println(absList(list))
  }

  def absList(list:List[Float]):List[Float] = {
    list.filter(x => {x >= -5 && x <= 12}).map(y => math.abs(y))
  }
}
