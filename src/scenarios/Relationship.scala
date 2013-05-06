package scenarios

import scala.util.Random
import scala.math
import api.Person

class Relationship extends Scenario {
	override def simulate(p: Person, day:Int) : (Int, Int) = {
	  var good_average = 10
	  var chance_to_leave = 0 
	  var chance_to_join = 0 
	  for(i <- 1 to good_average) {
		  
	  }
	  
	  chance_to_leave
	  if(chance_to_leave > 20) chance_to_leave = 20
	  chance_to_join
	  if(chance_to_join > 20) chance_to_join = 20
	  
      return (chance_to_join,chance_to_leave)
	  
	}
}
