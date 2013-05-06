package api

import scala.collection.mutable.ArrayBuffer
import scenarios.Scenario

object RelationType extends Enumeration {
  type RelationType = Value
  var Friend, Family, Colleagues, Aquaitances= Value //TODO complete with more relations
}

case class Relations(var nb_friends:Int, var nb_gf:Int, var nb_family:Int, var nb_children: Int, var nb_aquaitances:Int) 

case class Params(var paranoia_level: Int, var jealousy_level:Int, var worry_level:Int,
  var friends_activity: Int) 

class Person(var name: String, var age:Int, var relations : Relations, var params:Params, var scenarios:ArrayBuffer[Scenario]){
  var id = 0
  var tolerance_notification = 5

  def simulate(day:Int): ((Int, Int)) = {
    var stats_day = (0,0)
    for(s <- scenarios) {
      var stats_scenario = s.simulate(this, day)
      stats_day = (stats_day._1 + stats_scenario._1, stats_day._2 + stats_scenario._2)
    }
    return stats_day
  }

}
