package dsl

import api._
import scenarios._

object Scenarios extends Enumeration {
  type Scenarios   = Value
  var notification = Value
  var relationship = Value
  var stalking     = Value
  var all          = Value
}

import Scenarios._

object Simulate {
  def with_scenarios(sc : Scenarios): SimulateTmp = {
    println(sc)
    if(sc == Scenarios.notification || sc == Scenarios.all)
      Simulator.scenarios+=new Notification()
    if(sc == Scenarios.relationship || sc == Scenarios.all)
      Simulator.scenarios+=new Relationship()
    if(sc == Scenarios.stalking || sc == Scenarios.all)
      Simulator.scenarios+=new Relationship()
    return new SimulateTmp
  }
}

class SimulateTmp {
  def and(sc: Scenarios) : SimulateTmp = {
    Simulate.with_scenarios(sc)
    return this
  }

  def during(duration: Int )  = {
    Simulator run duration
    //Simulator show
  }

}


