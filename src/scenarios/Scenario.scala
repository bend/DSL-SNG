package scenarios

import api.Person

trait Scenario {
  
  def simulate(p: Person, day:Int) : (Float, Float) = {return null}

}
