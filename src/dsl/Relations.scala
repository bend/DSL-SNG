package dsl

import api._

object friends {
  def ->(i:Int) {
    Simulator.persons.last.relations.nb_friends = i
  }
}

object family{
  def ->(i:Int) {
    Simulator.persons.last.relations.nb_family = i
  }
}

object conjoint{
  def ->(i:Int) {
    Simulator.persons.last.relations.nb_gf = i
  }
}

object aquaitance{
  def ->(i:Int) {
    Simulator.persons.last.relations.nb_aquaitances= i
  }
}

object children{
  def ->(i:Int) {
    Simulator.persons.last.relations.nb_children = i
  }
}
