package com.vngrs
package example
package scalang
package structure

object Objekt extends App {

  abstract class Foo {

    def foo: String = "foo"
    def bar: String

  }

  object FooBar extends Foo {

    def bar: String = s"$foo+bar"

  }

  trait Baz extends Foo {

    def bar: String = s"$foo+$baz"
    def baz: String

  }

  object FooBaz extends Baz {

    override def foo = "f2o"
    override def baz = "baz" // override optional

  }

  println(FooBar.bar) // foo+bar
  println(FooBaz.bar) // f2o+baz

}
