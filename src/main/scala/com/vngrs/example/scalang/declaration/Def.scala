package com.vngrs
package example
package scalang
package declaration

object Def extends App {

  var foo: String = "foo"
  def bar: String = evaluate(foo)
  def evaluate(some: String): String = { println("evaluating..."); some }

  println("--begin--") // --begin--
  println(bar)         // evaluating... // foo
  foo = "bar"
  println(bar)         // evaluating... // bar
  println("---end---") // ---end---

}
