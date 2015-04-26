package com.vngrs
package example
package scalang
package types

object Generic extends App {

  class MyObj[T](value: T) {

    def is(predicate: T => Boolean) = predicate(value)

  }

  def even: Int => Boolean = _ % 2 == 0

  def infinity: Double => Boolean = _ isInfinity

  def is[T](t: T, predicate: T => Boolean) = predicate(t)

  val posInf = Double.PositiveInfinity

  println(new MyObj(0) is even)          // true
  println(new MyObj(2.3) is infinity)    // false
  println(new MyObj(posInf) is infinity) // true

  println(is(3, even))                   // false
  println(is(posInf, infinity))          // true

}
