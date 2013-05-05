package ssng.api //simul social growth

import scala.collection.mutable.ArrayBuffer


object RelationType extends Enumeration {
  type RelationType = Value
  var Friend, Family, Colleagues, Aquaitances= Value //TODO complete with more relations
}

import RelationType._

case class Name(first: String, last: String) 

case class Relations(nb_friends:Int, nb_gf:Int, nb_family:Int, nb_children: Int, nb_aquaitances:Int) 

case class Params(paranoia_level: Int, jealousy_level:Int, worry_level:Int) 

class Person(var name: Name, var age:Int, var relations : Relations, var params:Params){
  var joined = false
  var last_change = 0

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

}
