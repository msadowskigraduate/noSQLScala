package cwiczenia1

/**
  * Created by sadowsm3 on 08.04.2018
  */
object Exercise4 {
  def main(args: Array[String]): Unit = {
    val nullableMap = Map((1, "Bar"))
    val probablyNull: Option[String] = nullableMap.get(2)
    println(probablyNull.isDefined)
    println(probablyNull.getOrElse("Null Value!"))
  }
}
