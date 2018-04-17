/**
  * Created by sadowsm3 on 17.04.2018
  */
object Exercise9 {
  def main(args: Array[String]): Unit = {
      val intList = (1 to 50).toList
      print(intList + "\n")
      print(collectionMap(intList))
  }

  def collectionMap(list: List[Int]): List[Int] = {
    list.map(x => x + 1)
  }
}
