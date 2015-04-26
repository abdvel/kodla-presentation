package com.vngrs
package example
package scalang
package declaration

object Val extends App {

  var foo: String = "foo"
  val bar: String = evaluate(foo) // evaluating...
  def evaluate(some: String): String = { println("evaluating..."); some }

  println("--begin--") // --begin--
  println(bar)         // foo
  foo = "bar"
  println(bar)         // foo
  println("---end---") // ---end---

}
