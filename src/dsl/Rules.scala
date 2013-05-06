package dsl

object Rules {
	implicit def Int2Duration(i: Int) = new Duration(i)
	implicit def int2Float(i: Int) = i.toFloat
}
