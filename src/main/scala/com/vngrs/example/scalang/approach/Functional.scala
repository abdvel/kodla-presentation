package com.vngrs
package example
package scalang
package approach

object Functional extends App {

  sealed trait FunctionalShape extends Shape {
    def contains(coord: Coord) = insideShape(this)(coord)
    lazy val area = findArea(this)
  }

  case class Square(center: Coord, length: Double) extends FunctionalShape
  case class Circle(center: Coord, radius: Double) extends FunctionalShape

  def insideSquare(l: Double)(rel: Coord): Boolean =
    Math.abs(rel.x) <= l && Math.abs(rel.y) <= l

  def insideCircle(r: Double)(rel: Coord): Boolean =
    Math.sqrt(Math.pow(rel.x, 2.0) + Math.pow(rel.y, 2.0)) <= 1.0

  def insideShape(shape: Shape): Coord => Boolean = shape match {
    case Square(center, length) => c => insideSquare(length / 2)(center - c)
    case Circle(center, radius) => c => insideCircle(radius)(center - c)
  }

  def findArea(shape: Shape): Double = shape match {
    case Square(_, length) => Math.pow(length, 2.0)
    case Circle(_, radius) => Math.pow(radius, 2.0) * Math.PI
  }

  def isUnit(shape: Shape): Boolean = shape match {
    case Square(_, 1) => true
    case Circle(_, 1) => true
    case _ => false
  }

  val sqr = Square(Coord(3, 3), 4)
  val crc = Circle(Coord(3, -1), 2)
  val point = Coord(2, 2)

  println(sqr.contains(point)) // true
  println(sqr.area)            // 16.0
  println(crc.contains(point)) // false
  println(crc.area)            // 12.566...

}
