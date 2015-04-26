package com.vngrs
package example
package scalang
package approach

object Objective extends App {

  trait ObjectiveShape extends Shape {
    def isUnit: Boolean
  }

  class Square(val center: Coord, val length: Int) extends Shape {

    def contains(coord: Coord): Boolean = {
      val rel = coord - center
      val l = length / 2.0
      Math.abs(rel.x) <= l && Math.abs(rel.y) <= l
    }

    def area: Double = Math.pow(length, 2.0)

    def isUnit: Boolean = length == 2

  }

  class Circle(val center: Coord, val radius: Int) extends Shape {

    def contains(coord: Coord): Boolean = {
      val rel = coord - center
      Math.sqrt(Math.pow(rel.x, 2.0) + Math.pow(rel.y, 2.0)) <= 1.0
    }

    def area = Math.pow(radius, 2.0) * Math.PI

    def isUnit: Boolean = radius == 1

  }

  val sqr = new Square(Coord(3, 3), 4)
  val crc = new Circle(Coord(3, -1), 2)
  val point = Coord(2, 2)

  println(sqr.contains(point)) // true
  println(sqr.area)            // 16.0
  println(crc.contains(point)) // false
  println(crc.area)            // 12.566...

}
