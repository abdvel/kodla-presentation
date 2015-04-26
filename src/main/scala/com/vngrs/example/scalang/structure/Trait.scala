package com.vngrs
package example
package scalang
package structure

object Trait extends App {

  trait Foo {
    def foo: String = "foo"
    def bar: String
  }

  trait Bar extends Foo {
    def foo: String
    def bar: String = s"$foo+bar"
  }

  trait Baz {
    self: Foo =>

    def bar: String = s"$foo+$baz"
    def baz: String
  }

  trait BazImpl {
    self: Baz =>

    def baz: String = "baz"
  }

  println((new Object with Bar).bar)                       // foo+bar
  println((new Object with Foo with Baz with BazImpl).bar) // foo+baz

}
