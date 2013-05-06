package dsl

import api._
import scenarios._

object Scenarios extends Enumeration {
  type Scenarios = Value
  var notification = Value
  var relationship = Value
  var all = Value
}

import Scenarios._

object Simulate {
  def with_scenarios(sc : Scenarios): SimulateTmp = {
    println(sc)
    if(sc == Scenarios.notification)
      Simulator.scenarios+=new Notification()
    if(sc == Scenarios.relationship)
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


