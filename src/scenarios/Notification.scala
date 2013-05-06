package scenarios

import scala.util.Random
import api.Person

class Notification extends Scenario {
	override def simulate(p: Person, day:Int) : (Int, Int) = {
	  println("Notif proba pour "+p.name+" : (tolerance : "+p.tolerance_notification+") (friend activity : "+p.params.friends_activity+", nbr friends : "+(p.relations.nb_friends+p.relations.nb_family+p.relations.nb_aquaitances)+") "+(day+1))
	  println((p.params.friends_activity)*(p.relations.nb_friends+p.relations.nb_family+p.relations.nb_aquaitances))
	  var notifications =
        Random.nextInt(p.params.friends_activity)*(p.relations.nb_friends+p.relations.nb_family+p.relations.nb_aquaitances)*(day+1)
        
	    
	  if(notifications > p.tolerance_notification) { // Probability to be annoyed by notifications
	    return (0,notifications)
	  }
	  return (0,0)
	}
}
