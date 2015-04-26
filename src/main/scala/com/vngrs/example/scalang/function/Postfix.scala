package com.vngrs
package example
package scalang
package function

object Postfix extends App {

  class MyInt(value: Int) {
    def is(predicate: Int => Boolean) = predicate(value)
  }

  def even(value: Int): Boolean = value % 2 == 0

  def lessThan(value: Int): (Int => Boolean) = value >

  println(new MyInt(0).is(even))         // true
  println (new MyInt(7) is even)         // false

  println(new MyInt(7).is(lessThan(0)))  // false
  println (new MyInt(0) is lessThan (7)) // true

}
