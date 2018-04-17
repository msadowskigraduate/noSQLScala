import scala.annotation.tailrec


object Exercise1 {
  def main(args: Array[String]){
      val weekDays = List("PONIEDZIALEK", "WTOREK", "SRODA", "CZWARTEK", "PIATEK", "SOBOTA", "NIEDZIELA")
      for(day <- weekDays) println(day)
      println("----------------------------------------------------------")
      for(day <- weekDays if day.startsWith("P")) println(day)
      println("----------------------------------------------------------")
      weekDays.foreach { x => println(x) }
      println("----------------------------------------------------------")
      weekDays.filter { x => x.startsWith("P") }.foreach { y => println(y)  }
      println("----------------------------------------------------------")
      var iterator = weekDays.iterator
      while(iterator.hasNext){
        println(iterator.next())
      }
      println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
      recursiveFunction(weekDays)
      println("----------------------------------------------------------")
      recursiveReverseFunction(weekDays)
      println("FOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDL")
      weekDays.foldLeft(){(_, x) => println(x)} 
      println("FOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDFOLDR")
      weekDays.foldRight(){(x, _) => println(x)} 
      println("XXXXXXXXXXXXXXX FOLD WITH ONLY P FOLD XXXXXXXXXXXXXXXXXXX")
      weekDays.foldLeft(){(_, x) => if (x.startsWith("P")) println(x)} 
  }
  
  def recursiveFunction(days: List[String]) {
    @tailrec
    def iterateOver(x: Int) {
      if(x >= 0 && x < days.length) {
        println(days(x))
        iterateOver(x + 1)
      }
    }
    iterateOver(0)
  }
  
 def recursiveReverseFunction(days: List[String]) {
    @tailrec
    def iterateOver(x: Int) {
      if(x >= 0 && x <= days.length) {
        println(days(x))
        iterateOver(x - 1)
      }
    }
    iterateOver(days.length - 1)
  }
}