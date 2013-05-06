package scenarios

import scala.util.Random
import scala.math
import api.Person

/**
 * the probabilities of this class are constant for every days
 */
class Relationship extends Scenario {
	override def simulate(p: Person, day:Int) : (Float, Float) = {

	  var chance_to_leave = 0f
	  var chance_to_join = 0f
	  var probability_brokeup = 1f // 1% chance to break up with our GF everyday
	  
	  var chance_to_join_breakup = 0f
	  var chance_to_leave_day = 0f
	  
	  // If we have a GF and we breakup, and we don't have many friends, we would like to join, 
	  // especially if we are old, because we want to meet someone
	  if(p.relations.nb_gf > 0) {
	    chance_to_join_breakup = ((probability_brokeup*p.relations.nb_gf) / p.nbr_relations)*100
	    if(p.age > 40) chance_to_join_breakup *= 2
	  }
	  
	  chance_to_join += math.round(chance_to_join_breakup)
	  
	  // If the ratio of family member on facebook is too high, we want to leave
	  if((p.relations.nb_family*1f / p.nbr_relations) >= 0.2) {
	    chance_to_leave += 100/((1-(p.relations.nb_family*1f / p.nbr_relations)) * p.params.friends_activity*3f)
	  }
	  
	  
	  chance_to_leave += math.round(chance_to_leave_day)

	  
	  if(chance_to_leave > 20) chance_to_leave = 20
	  if(chance_to_join > 20) chance_to_join = 20
	  
	  return (chance_to_join,chance_to_leave)
	  
	}
}
