package com.vngrs
package example
package scalang
package function

object Curry extends App {

  def even(x: Int): Boolean = x % 2 == 0

  def odd(x: Int): Boolean = x % 2 != 0

  def is(x: Int)(predicate: Int => Boolean): Boolean = predicate(x)

  val curried0: (Int => Boolean) => Boolean = is(0)
  val curried1 = is(7) _

  println(curried0(even)) // true
  println(curried0(odd))  // false

  println(curried1(even)) // false
  println(curried1(odd))  // true

}
