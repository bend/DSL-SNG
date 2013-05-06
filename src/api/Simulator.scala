package api

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scenarios.Scenario

object Simulator{
  var persons: ArrayBuffer[Person] = new ArrayBuffer[Person]()
  var stats: HashMap[Person, ArrayBuffer[(Int,Int)]] = new HashMap[Person, ArrayBuffer[(Int,Int)]]()
  var days = 0
  var scenarios : ArrayBuffer[Scenario] = new ArrayBuffer[Scenario]()

  def add_person(person: Person) {
    persons+=person
  }

	def run(days: Int) {
	  	this.days = days
	  	for(day <- 0 to days) {
			for(p <- persons) {
              if(!stats.contains(p)) stats(p) = new ArrayBuffer[(Int,Int)]()
              p.scenarios = scenarios
              stats(p) += p.simulate(day)
			}
	  	}
	}
	/*
	 * Display the probabilities for each day and each type of person to join/leave, depending on the scenarios
	 */
	def show() {
	  for(day <- 0 to days) {
		  println("Day "+day)
		  for(p <- persons) {
            var s = stats(p)
            var avg1 = 0
            var avg2 = 0
            for(e <- s){
              avg1 += e._1
              avg2 += e._2
            }
            avg1 = avg1/ days
            avg2= avg2/ days
            println("Stats for user" + p.name + ": (" + avg1 + ","+avg2+")")
		  }
	  }
	}
}
