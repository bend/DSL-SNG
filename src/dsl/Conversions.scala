package dsl

object Conversions {
  implicit def Int2Duration(i: Int) = new Quantity(i)
  implicit def int2Float(i: Int) = i.toFloat
}