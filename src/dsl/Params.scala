package dsl

import api._

trait levels {
  val not = 0
  val low = 10
  val medium = 35
  val high = 65
  val extreme = 100
}

object paranoid extends levels {
  def ->(i: Int) {
    Simulator.persons.last.params.paranoia_level = i
  }
}

object jealous extends levels {
  def ->(i: Int) {
    Simulator.persons.last.params.jealousy_level = i
  }
}

object tolerance extends levels {
  def ->(i: Int) {
    Simulator.persons.last.params.tolerance_level = i
  }
}

object friends_activity extends levels {
  def ->(i: Int) {
    Simulator.persons.last.params.friends_activity = i
  }
}
