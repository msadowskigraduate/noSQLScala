/**
  * Created by sadowsm3 on 08.04.2018
  */
object Exercise2 {
  def main(args: Array[String]): Unit = {
    val productMap = Map[String, Double](("Banany", 1.5), ("Ziemniaki", 2.5), ("Paroweczki", 5.5))
    val updatedProductMap = productMap.map({case (key, value) => (key, value * 1.1)})
    updatedProductMap.foreach({case (key, value) => println(key +" " + updatedProductMap.get(key))})
  }
}
