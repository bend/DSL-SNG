package api

import scala.collection.mutable.ArrayBuffer
import scenarios.Scenario

object RelationType extends Enumeration {
  type RelationType = Value
  var Friend, Family, Colleagues, Aquaitances= Value //TODO complete with more relations
}

case class Relations(var nb_friends:Int, var nb_gf:Int, var nb_family:Int, var nb_children: Int, var nb_aquaitances:Int) 

case class Params(var paranoia_level: Int, var jealousy_level:Int, var worry_level:Int, var tolerance_level: Int, var friends_activity: Int) 

class Person(var name: String, var age:Int, var relations : Relations, var params:Params, var scenarios:ArrayBuffer[Scenario]){
  def simulate(day:Int): ((Float, Float)) = {
    var stats_day = (0f,0f)
    for(s <- scenarios) {
      var stats_scenario = s.simulate(this, day)
      stats_day = (stats_day._1 + stats_scenario._1, stats_day._2 + stats_scenario._2)
    }
    stats_day = (stats_day._1 / scenarios.length, stats_day._2 / scenarios.length)
    return stats_day
  }

  def nbr_relations: Int = {return this.relations.nb_aquaitances + this.relations.nb_family + this.relations.nb_friends}
}
