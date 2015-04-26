package com.vngrs
package example
package scalang

package object control {

  val ints = (0 to 9).toList

  def lessThan: Int => Int => Boolean = _ >

  def divisible(divisor: Int): Int => Boolean = _ % divisor == 0

  def even = divisible(2)

}
