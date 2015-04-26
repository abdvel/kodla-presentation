package com.vngrs
package example
package scalang
package control

object Behavioral extends App {

  val mon1 = ints map (2 *)

  val mon2 = ints filter divisible(3)

  val mon3 = ints filter even map (2 *) filterNot lessThan(5)

  val mon4 = for (i <- mon3) yield i * 2

  println(ints) // List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  println(mon1) // List(0, 2, 4, 6, 8, 10, 12, 14, 16, 18)
  println(mon2) // List(0, 3, 6, 9)
  println(mon3) // List(8, 12, 16)
  println(mon4) // List(16, 24, 32)

}
