package ssng.dsl
import ssng.api._
import ssng.scenarios._

object Scenarios extends Enumeration {
  type Scenarios = Value
  var notification =Value
  var all = Value
}

import Scenarios._

object Simulate {
  def with_scenarios(sc : Scenarios): SimulateTmp = {
    if(sc == Scenarios.notification)
      Simulator.scenarios+=new Notification()
    return new SimulateTmp
  }
}

class SimulateTmp {
  def and(sc: Scenarios) : SimulateTmp = {
    return this
  }

  def during(duration: Int )  = {
    Simulator run duration
    Simulator show
  }

}


