package ssng.api //simul social growth

import scala.collection.mutable.ArrayBuffer


object RelationType extends Enumeration {
  type RelationType = Value
  var Friend, Family, Colleagues, Aquaitances= Value //TODO complete with more relations
}

import RelationType._

case class Name(first: String, last: String) 

case class Relation(var person1: Person, var relationType : RelationType ) 

class Person(var name: Name, var age:Int, var paranoia_leve:Int){
  var joined = false
  var last_change = 0
  var relations = ArrayBuffer[Relation]()


  def addRelation(rel: Relation)  = {
    relations+=rel
    rel.person1.relations+=Relation(this, rel.relationType)
  }

  def join(day: Int) {
    if (!joined) {
      joined = true
      //  Observer.join(day)
      last_change = day
    }
  }

  // user leaves the network
  def leave(day: Int) {
    if (joined) {
      joined = false
      // Observer.leave(day)
      last_change = day
    }
  }

  // returns whether a change could be made according to the last change
  def change(days: Int): Boolean = {
    //if (last_change != 0 && days < Simulation.generator.nextDouble * 1)
    // return true
    return false
  }
}
