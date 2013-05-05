package scenarios

import scala.util.Random
import api.Person

trait Notification extends Scenario {
	override def simulate(p: Person) : (Int, Int) = {
	  var notifications = Random.nextInt(Parameters.friends_activity)*(p.relations.nb_friends+p.relations.nb_family+p.relations.nb_aquaitances)
	  if(notifications > p.tolerance_notification) { // Probability to be annoyed by notifications 
	    return (0,10)
	  }
	  return (0,0)
	}
}
