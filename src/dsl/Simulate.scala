package dsl

import api._
import scenarios._

object Scenarios extends Enumeration {
  type Scenarios = Value
  var notification = Value
  var relationship = Value
  var stalking = Value
  var artist = Value
  var influence = Value
  var death = Value
  var all = Value
}

import Scenarios._

object Simulate {
  // To take into account a new scenario, you need to add 2 lines in the following method. You also need to add the new keyword in the object Scenario
  def with_scenarios(sc: Scenarios): SimulateTmp = {
    println(sc)
    if (sc == Scenarios.notification || sc == Scenarios.all)
      Simulator.scenarios += new Notification()
    if (sc == Scenarios.relationship || sc == Scenarios.all)
      Simulator.scenarios += new Relationship()
    if (sc == Scenarios.stalking || sc == Scenarios.all)
      Simulator.scenarios += new Stalking()
    if (sc == Scenarios.artist || sc == Scenarios.all)
      Simulator.scenarios += new Artist()
    if (sc == Scenarios.influence || sc == Scenarios.all)
      Simulator.scenarios += new Influence()
    if (sc == Scenarios.death|| sc == Scenarios.all)
      Simulator.scenarios += new Death()
    return new SimulateTmp
  }
  
  def on(x : Int): SimulateTmp2 = {
    return new SimulateTmp2(x)
  }
}

class SimulateTmp {
  def and(sc: Scenarios): SimulateTmp = {
    Simulate.with_scenarios(sc)
    return this
  }

  def during(duration: Int) = {
    Simulator run duration
  }

}

class SimulateTmp2(x: Int){
  def during(duration: Int) = {
    //Simulator get_evolution(duration, x)
  }
}