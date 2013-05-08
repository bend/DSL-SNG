package scenarios

import scala.util.Random
import scala.math
import api.Person

class Artist extends Scenario {
  name = "Artist"

  override def simulate(p: Person, day: Int): (Float, Float) = {
    var proba_artist = 0.1f
    var chance_join = (p.nbr_relations * p.params.friends_activity / 100f) * proba_artist
    if (chance_join > 3f) chance_join = 3f
    return (chance_join, 0f)
  }
}