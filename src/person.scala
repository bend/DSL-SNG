package ssng //simul social growth


object RelationType extends Enumeration {
  type RelationType = Value
  val ParentOf, GrandParentOf = Value //TODO complete with more relations
}

import RelationType._

case class Name(first: String, last: String) 

case class Relation(person1: Person, relationType : RelationType ) 

case class Person(name: Name, age:Int, relations:List[Relation]){

  def addRelation(rel: Relation) = Person(name, age, relations.add(rel))
  
  def deleteRelation(rel: Relation) = {
    
  }
}
