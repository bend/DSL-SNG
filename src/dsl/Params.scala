package dsl

import api._

object paranoid {
  val not = 0
  val medium = 50
  val high =100

  def ->(i:Int) {
    Simulator.persons.last.params.paranoia_level = i
  }
}

object jealous {
  val not = 0
  val medium = 50
  val high =100

  def ->(i:Int) {
    Simulator.persons.last.params.jealousy_level = i
  }
}

object worried {
  val not = 0
  val medium = 50
  val high =100

  def ->(i:Int) {
    Simulator.persons.last.params.worry_level = i
  }
}

object active {
  val not = 0
  val medium = 50
  val high =100

  def ->(i:Int) {
    Simulator.persons.last.params.friends_activity = i
  }
}
