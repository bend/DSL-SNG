package scenarios

import api.Person

trait Scenario {
  var name = ""
  def simulate(p: Person, day: Int): (Float, Float)
}
