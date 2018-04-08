/**
  * Created by sadowsm3 on 08.04.2018
  */
object Exercise3 {
  def main(args: Array[String]): Unit = {
    val tripleTuple = ("Hello! ", 1, 1.51)
    val function: ((String, Int, Double)) => String = {case (a,b,c) => a + " " + b + " " + c}
    println(function(tripleTuple))
  }
}
