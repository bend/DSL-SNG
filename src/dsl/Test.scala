package dsl

import scala.collection.mutable.ArrayBuffer
import scenarios._
import api._

import Conversions._

object Main extends App {
  Create_person named "Ben" aged_of 23.years with_friends 500 with_family 22 with_aquaitances 10 with_gf 1 with_children 0 with_params {
    paranoid -> paranoid.medium
    jealous -> jealous.medium
    tolerance -> tolerance.low
    friends_activity -> friends_activity.high
  }
/*
  Create_person named "Chris" aged_of 44.years with_friends 20 with_family 20 with_aquaitances 0 with_gf 1 with_children 0 with_params {
    paranoid -> paranoid.medium
    jealous -> jealous.low
    tolerance -> tolerance.medium
    friends_activity -> friends_activity.low
  }

  Create_person named "David" aged_of 30.years with_friends 0 with_family 20 with_aquaitances 50 with_gf 1 with_children 20 with_params {
    paranoid -> paranoid.not
    jealous -> jealous.not
    tolerance -> tolerance.low
    friends_activity -> friends_activity.extreme
  }
  Create_person named "Jack" aged_of 23 with_params {
    paranoid -> paranoid.medium
  } with_wife 1 with_friends 20

  Create_person named "Patrick" aged_of 22 with_params {
    paranoid -> paranoid.medium
  } with_relations {
    friends -> 10
    family -> 20
  }
*/
  
  Simulate with_scenarios Scenarios.all during 100.year
  //Show detailed () stats_for 1.year
  //Simulate on 1000.persons during 100.years
  


  //Show detailed () stats_for 100.year
  //Simulator.get_evolution(1.month, 100000)

}
