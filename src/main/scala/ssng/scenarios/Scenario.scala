package ssng.scenarios

import ssng.api.Person

trait Scenario {
  
  def simulate(p: Person, day:Int) : (Int, Int) = {return null}

}
