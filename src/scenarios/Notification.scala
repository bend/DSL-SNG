package scenarios

import scala.util.Random
import scala.math
import api.Person

/**
 * we calculate the activity (depicted in the number of notifications) depending on the number of friends that are present in the social network
 * the more the user have friends, the more he will receive notifications from them, and depending on his tolerance, it will start to annoy him
 * if his tolerance is reached, he may want to leave the social network (with a maximal probability of 20%, which is 
 * the weight attributed to the importance of notifications annoyance)
 * 
 *  the probabilities of this class are random for every days 
 */
class Notification extends Scenario {
	name = "Notification"
	  
	override def simulate(p: Person, day:Int) : (Float, Float) = {
	  
	  var good_average = 10
	  var chance_to_leave = 0f 
	  
	  for(i <- 1 to good_average) {
		  var max_notif = ((p.params.friends_activity/100.0f)*p.nbr_relations)
		  if(max_notif <= 0) max_notif = 10
		  var notifications_this_day = Random.nextInt(math.round(max_notif))
		  if(notifications_this_day == 0) notifications_this_day = 1
	        
		  chance_to_leave += notifications_this_day/(if(p.params.tolerance_level==0) 1 else p.params.tolerance_level)
	  }
	  
	  chance_to_leave /= good_average
	  chance_to_leave *= (((p.age/365f)*2f) / 100f) // More he is old, more he wants to leave because of notifications
	  
      var param_tolerance = p.params.friends_activity / (if(p.params.tolerance_level==0) 1 else p.params.tolerance_level)
	  if(chance_to_leave > param_tolerance) chance_to_leave = param_tolerance
	  
	  return (0f,chance_to_leave)
	  
	}
}
