package scenarios

import api.Person

trait Scenario {
  
  def simulate(p: Person) : (Int, Int) = {return null}

}