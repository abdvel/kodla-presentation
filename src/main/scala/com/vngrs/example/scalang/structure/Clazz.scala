package com.vngrs
package example
package scalang
package structure

object Clazz extends App {

  abstract class Foo {

    def foo: String = "foo"
    def bar: String

  }

  class Bar extends Foo {

    override def foo = super.foo + "+" + bar // s"${super.foo}+$bar"
    def bar: String = "bar"

    object Baz extends Foo {

      override val foo: String = Bar.this.foo
      def bar: String = "baz"

    }

    object Buz extends Foo {

      override val foo: String = s"${super.foo}+$bar+$baz"
      def bar: String = Bar.this.bar
      def baz: String = "baz"

    }

  }

  println((new Bar).foo)     // foo+bar
  println((new Bar).Baz.foo) // foo+bar
  println((new Bar).Buz.foo) // foo+bar+baz

}
