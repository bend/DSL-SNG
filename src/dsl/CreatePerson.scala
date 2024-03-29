package dsl

import api._

object Create_person {
  def named(name: String): TmpAttr1 = {
    var p = new Person(name, 1, Relations(0, 0, 0, 0, 0), Params(1, 1, 1, 1), null)
    Simulator.add_person(p)
    return new TmpAttr1(p)
  }
}

class TmpAttr1(var person: Person) {

  def aged_of(age: Int): TmpAttr1 = {
    person.age = age
    return this
  }
  
  def who_is(p: Character): TmpAttr1 = {
    return this
  }

  def with_friends(i: Int): TmpAttr1 = {
    person.relations.nb_friends = i
    return this
  }
  def with_family(i: Int): TmpAttr1 = {
    person.relations.nb_family = i
    return this
  }
  def with_aquaitances(i: Int): TmpAttr1 = {
    person.relations.nb_aquaitances = i
    return this
  }
  def with_conjoint(i: Int): TmpAttr1 = {
    person.relations.nb_gf = i
    return this
  }

  def with_gf(i: Int): TmpAttr1 = {
    person.relations.nb_gf = i
    return this
  }

  def with_bf(i: Int): TmpAttr1 = {
    person.relations.nb_gf = i
    return this
  }

  def with_husband(i: Int): TmpAttr1 = {
    person.relations.nb_gf = i
    return this
  }

  def with_wife(i: Int): TmpAttr1 = {
    person.relations.nb_gf = i
    return this
  }

  def with_children(i: Int): TmpAttr1 = {
    person.relations.nb_children = i
    return this
  }

  def with_params(block: => Unit): TmpAttr1 = {
    block
    return this
  }

  def with_relations(block: => Unit): TmpAttr1 = {
    block
    return this
  }
}

