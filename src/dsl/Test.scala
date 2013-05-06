package dsl

import scala.collection.mutable.ArrayBuffer
import scenarios._
import dsl._
import api._

object Main extends App {
  
  Create_person named "Ben" aged_of 23 with_friends 500 with_family 22 with_aquaitances 10 with_gf 1 with_children 0 with_params {
    paranoid -> paranoid.medium
    jealous -> jealous.high
    worried -> worried.medium
    tolerance -> tolerance.high
    friends_activity -> friends_activity.extreme
  }
  Create_person named "Chris" aged_of 44 with_friends 20 with_family 20 with_aquaitances 0 with_gf 1 with_children 0 with_params {
    paranoid -> paranoid.medium
    jealous -> jealous.high
    worried -> worried.medium
    tolerance -> tolerance.medium
    friends_activity -> friends_activity.low
  }

  Simulate with_scenarios Scenarios.notification and Scenarios.relationship during 10

}
