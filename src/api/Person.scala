package api

import scala.collection.mutable.ArrayBuffer
import scenarios.Scenario

case class Relations(var nb_friends:Int, var nb_gf:Int, var nb_family:Int, var nb_children: Int, var nb_aquaitances:Int) 

case class Params(var paranoia_level: Int, var jealousy_level:Int, var worry_level:Int, var tolerance_level: Int, var friends_activity: Int) 

class Person(var name: String, var age:Int, var relations : Relations, var params:Params, var scenarios:ArrayBuffer[Scenario]){
  def simulate(day:Int): ((Float, Float)) = {
    var stats_day = (0f,0f)
    println("Death stat : "+deathProb(day))
    for(s <- scenarios) {
      var stats_scenario = s.simulate(this, day)
      stats_day = (stats_day._1 + stats_scenario._1, stats_day._2 + stats_scenario._2)
    }
    stats_day = (stats_day._1 / scenarios.length, stats_day._2 / scenarios.length)
    return stats_day
  }
  
  def deathProb(day:Int): Float = {
    var age_year : Int = day/3650
    return P(age_year)
  }
  
  def F(k: Int): Float =  {
	  // Quotient de mortalité tous les 10 ans en Be
	  // http://www.iabe.be/sites/default/files/bijlagen/annexesterftetafels_0.pdf
	  val quotients = List(0.006041, 0.0001, 0.000512, 0.000612, 0.001406, 0.002501, 0.06496, 0.017342, 0.057315, 0.1676)
	  var ret : Double = 1.f
	  for(i <- 0 to k) {
	    ret = ret * (1-quotients(i))
	  }
	  println(ret)
	  return ret.toFloat
  }
  
  def P(k: Int): Float = {
	  return F(k) - F(k+1)
  }

  def nbr_relations: Int = {return this.relations.nb_aquaitances + this.relations.nb_family + this.relations.nb_friends}
}
