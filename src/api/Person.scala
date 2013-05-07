package api

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scenarios.Scenario

case class Relations(var nb_friends:Int, var nb_gf:Int, var nb_family:Int, var nb_children: Int, var nb_aquaitances:Int) 

case class Params(var paranoia_level: Int, var jealousy_level:Int, var tolerance_level: Int, var friends_activity: Int) 

class Person(var name: String, var age:Int, var relations : Relations, var params:Params, var scenarios:ArrayBuffer[Scenario]){
  def simulate(day:Int): (HashMap[String,(Float, Float)]) = {
    age += 1
    var stats_day = HashMap[String, (Float, Float)]()
    for(s <- scenarios) {
      var stats_scenario = s.simulate(this, day)
      stats_day(s.name) = (stats_scenario._1, stats_scenario._2)
    }
    return stats_day
  }

  def nbr_relations: Int = {return this.relations.nb_aquaitances + this.relations.nb_family + this.relations.nb_friends}
}
