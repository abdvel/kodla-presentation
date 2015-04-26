package com.vngrs
package example
package scalang

package object approach {

  trait Shape {
    def contains(coord: Coord): Boolean
    def area: Double
  }

  case class Coord(x: Int, y: Int) {
    def -(other: Coord) = Coord(x - other.x, y - other.y)
  }

}
