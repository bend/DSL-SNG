package ssng.api //simul social growth

import ssng.api._

object TestPerson extends App {
  var p1 = new Person(Name("Ben", "D"), 23, 10)
  var p2 = new Person(Name("Chris", "C"), 24, 100)
  p2.addRelation(Relation(p1, RelationType.Friend))
  println(format("%s %s: %d\n", p1.name.first, p1.name.last, p1.relations.size))
  println(format("%s %s: %d\n", p2.name.first, p2.name.last, p2.relations.size))
  
}
