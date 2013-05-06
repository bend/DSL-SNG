package dsl

import api._

object Create_person {
  def named(name: String): TmpAge = {
    return new TmpAge(name)
  }
}

class TmpAge(name:String) {
  def aged_of(age:Int): TmpAttr1 = {
    var p = new Person(name, age, Relations(0,0,0,0,0), Params(0,0,0,0,0), null) 
    Simulator.add_person(p)
    return new TmpAttr1(p)
  }
}

class TmpAttr1(var person:Person) {

  def with_friends(i:Int): TmpAttr1 = {
    person.relations.nb_friends = i
    return this
  }
  def with_family(i:Int): TmpAttr1 = {
    person.relations.nb_family = i
    return this
  }
  def with_aquaitances(i:Int): TmpAttr1 = {
    person.relations.nb_aquaitances = i
    return this
  }
  def with_gf(i:Int): TmpAttr1 = {
    person.relations.nb_gf = i
    return this
  }
  def with_children(i:Int): TmpAttr1 = {
    person.relations.nb_children = i
    return this
  }

  def with_params(block: => Unit) {
    block
  }
}

