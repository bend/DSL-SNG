package scenarios

import scala.util.Random
import scala.math
import api.Person

class Stalking extends Scenario {
  name = "Stalking"

  override def simulate(p: Person, day: Int): (Float, Float) = {
    var chance_join_day = 0f
    var chance_leave_day = 0f
    var parano = (p.params.paranoia_level + p.params.jealousy_level) / 40f

    if (p.relations.nb_gf > 0) {
      var chance_join_day_gf = ((p.params.paranoia_level + p.params.jealousy_level) / 100f) * 3f
      if (chance_join_day_gf > parano) chance_join_day_gf = parano // max 3% chance to join because of this
      chance_join_day += chance_join_day_gf
    }

    if (p.relations.nb_children > 0) {
      var paranoia_children = p.params.paranoia_level * p.relations.nb_children * (p.age / 365f)
      if (paranoia_children > 100) paranoia_children = 100
      chance_join_day += (paranoia_children / 100f) * 3f // max 3% chance to join because of this
    }

    var chance_leave_day_friends = p.nbr_relations * p.params.friends_activity / 1000f
    var friends_tolerance = 3f * (p.params.tolerance_level / 100f)
    if (friends_tolerance > 10f) friends_tolerance = 10f // max 10% chance to leave because of this
    if (chance_leave_day_friends > friends_tolerance) chance_leave_day_friends = friends_tolerance
    chance_leave_day += chance_leave_day_friends

    return (chance_join_day, chance_leave_day)
  }
}