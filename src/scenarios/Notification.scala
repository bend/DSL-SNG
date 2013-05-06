package scenarios

import scala.util.Random
import scala.math
import api.Person

/**
 * we calculate the activity (depicted in the number of notifications) depending on the number of friends that are present in the social network
 * the more the user have friends, the more he will receive notifications from them, and depending on his tolerance, it will start to annoy him
 * if his tolerance is reached, he may want to leave the social network (with a maximal probability of 20%, which is 
 * the weight attributed to the importance of notifications annoyance) 
 */
class Notification extends Scenario {
	override def simulate(p: Person, day:Int) : (Int, Int) = {
	  
	  var good_average = 10
	  var chance_to_leave = 0 
	  
	  for(i <- 1 to good_average) {
		  var max_notif = ((p.params.friends_activity/100.0f)*(p.relations.nb_friends+p.relations.nb_family+p.relations.nb_aquaitances))
		  if(max_notif <= 0) max_notif = 10
		  var notifications_this_day = Random.nextInt(math.round(max_notif))
	        
		  //println(p.name+" : "+notifications_this_day+" ("+max_notif+") (tolerance : "+p.params.tolerance_level+", activity : "+p.params.friends_activity+", friends : "+(p.relations.nb_friends+p.relations.nb_family+p.relations.nb_aquaitances)+")")
		  
		  chance_to_leave += notifications_this_day/p.params.tolerance_level 
	  }
	  
	  chance_to_leave = chance_to_leave/good_average
	  if(chance_to_leave > 20) chance_to_leave = 20
      
	  return (0,chance_to_leave)
	  
	}
}
