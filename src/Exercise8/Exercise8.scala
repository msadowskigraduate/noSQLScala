package Exercise8

/**
  * Created by sadowsm3 on 17.04.2018
  */
object Exercise8 {
  def main(args: Array[String]): Unit = {
      var integerList: List[Int] = List(0,1,0,10,1,0,1,0)
      print(integerList)
      print(removeNots(integerList))
  }

  def removeNots(list:List[Int]) :List[Int] = {
     list.filter(x => x != 0)
  }
}
