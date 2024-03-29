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

  Create_person named "Chris" aged_of 44.years with_friends 2000 with_family 20 with_aquaitances 0 with_gf 1 with_children 0 with_params {
    paranoid -> paranoid.extreme
    jealous -> jealous.extreme
    tolerance -> tolerance.extreme
    friends_activity -> friends_activity.extreme
  }

  Create_person named "David" with_friends 10 with_family 20 with_aquaitances 50 with_gf 0 with_children 20 with_params {
    paranoid -> paranoid.not
    jealous -> jealous.not
    tolerance -> tolerance.low
    friends_activity -> friends_activity.extreme
  } aged_of 30.years

  Create_person named "Jack" aged_of 23 with_params {
    paranoid -> paranoid.medium
  } with_wife 1 with_friends 20

  Create_person named "Patrick" with_params {
    paranoid -> paranoid.medium
  } with_relations {
    friends -> 10
    family -> 20
  } aged_of 10

  
  Simulate with_scenarios Scenarios.all during 10.year
  //Simulate with_scenarios Scenarios.relationship during 1.month
  
  Simulate on 1000.persons during 10.years
  //Show stats_for 1.month
  Show detailed () stats_for 1.years

}
