package ssng.dsl

import scala.collection.mutable.ArrayBuffer
import ssng.scenarios._
import ssng.dsl.Rules._
object Main extends App {
  
  Create_person named "Ben" aged_of 23.years with_friends 50 with_family 22 with_aquaitances 10 with_gf 1 with_children 0
  Create_person named "Chris" aged_of 24.years with_friends 44 with_family 26 with_aquaitances 0 with_gf 1 with_children 4 with_params {
    paranoid -> paranoid.medium
    jealous -> jealous.high
    worried -> 22
    active -> 50
  }

  Simulate with_scenarios Scenarios.notification and Scenarios.notification during 1.years

}
