package ssng //simul social growth


object RelationType extends Enumeration {
  type RelationType = Value
  val ParentOf, GrandParentOf = Value
}


case class Name(first: String, last: String)

case class Relation(person1: Person, person2: Person, relationType : RelationType )

case class Person(name: Name, age:Int, relations:List[Relation])
