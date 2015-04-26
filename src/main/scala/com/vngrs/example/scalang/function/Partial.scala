package com.vngrs
package example
package scalang
package function

object Partial extends App {

  val intReg = "\\d+".r

  def itself: PartialFunction[Any, Int] = { case x: Int => x }

  def parse: Any => Option[Int] = x => try { Some(x.toString.toInt) } catch { case _: Exception => None }

  def asInt: PartialFunction[Any, Int] = itself orElse Function.unlift(parse)

  val notInt: PartialFunction[Any, String] = { case any => s"sorry, $any is not an int!" }

  def printIfInt = (asInt orElse notInt) andThen println

  println(asInt.isDefinedAt(3))     // true
  println(asInt.isDefinedAt("3"))   // true
  println(asInt.isDefinedAt("foo")) // false

  printIfInt(3)     // 3
  printIfInt("3")   // 3
  printIfInt("foo") // sorry, foo is not an int!

}
