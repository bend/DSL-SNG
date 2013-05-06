package ssng.scenarios

import ssng.api.Person

trait Scenario {
  
  def simulate(p: Person) : (Int, Int) = {return null}

}
