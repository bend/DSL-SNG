package api

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scenarios.Scenario

object Simulator{
  var persons: ArrayBuffer[Person] = new ArrayBuffer[Person]()
  var stats: HashMap[Person, Array[(Float,Float)]] = new HashMap[Person, Array[(Float,Float)]]()
  var days = 0
  var scenarios : ArrayBuffer[Scenario] = new ArrayBuffer[Scenario]()

  def add_person(person: Person) {
    persons+=person
  }

	def run(days: Int) {
	  	this.days = days
	  	for(day <- 1 to days) {
	  	  println("Jour "+day)
			for(p <- persons) {
              if(!stats.contains(p)) stats(p) = new Array[(Float,Float)](days)
              p.scenarios = scenarios
              stats(p)(day-1) = p.simulate(day)
              println("Stat "+p.name+" : "+stats(p)(day-1))
			}
	  	}
	}
	/*
	 * Display the probabilities for each day and each type of person to join/leave, depending on the scenarios
	 */
	def show() {
	  for(day <- 1 to days) {
		  println("Day "+day)
		  for(p <- persons) {
            var s = stats(p)(day-1)
            println("Stats for user" + p.name + ": (" + s._1 + ","+s._2+")")
		  }
	  }
	}
}
