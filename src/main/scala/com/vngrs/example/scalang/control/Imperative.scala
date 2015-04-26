package com.vngrs
package example
package scalang
package control

object Imperative extends App {

  import scala.collection.mutable.{ MutableList => MutLst }

  def twice(list: List[Int]): List[Int] = {
    val result = new MutLst[Int]
    for (int <- list)
      result += (int * 2)
    result.toList
  }

  def filterDivisible(div: Int, list: List[Int]): List[Int] = {
    val result = new MutLst[Int]
    for (int <- list)
      if (int % div == 0) result += int
    result.toList
  }

  def NotLessThan(that: Int, list: List[Int]): List[Int] = {
    val result = new MutLst[Int]
    for (int <- list)
      if (!(int < that)) result += int
    result.toList
  }


  val imp1 = twice(ints)

  val imp2 = filterDivisible(3, ints)

  val imp3 = NotLessThan(5, twice(filterDivisible(2, ints)))

  println(ints) // List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  println(imp1) // List(0, 2, 4, 6, 8, 10, 12, 14, 16, 18)
  println(imp2) // List(0, 3, 6, 9)
  println(imp3) // List(8, 12, 16)

}
