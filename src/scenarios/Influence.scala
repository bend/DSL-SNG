package scenarios

import scala.util.Random
import scala.math
import api.Person

/**
 * If the user has many friends, and is young, he will more likely want to join the social network
 */
class Influence extends Scenario {
	name = "Influence"
	
	override def simulate(p: Person, day:Int) : (Float, Float) = {
	  var chance_join = 0f
	  
	  chance_join = p.nbr_relations * (1f/(p.age/36.5f))
	  
	  return(chance_join,0f)
	}
}
