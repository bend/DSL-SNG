package ssng.api

import scala.collection.mutable.ArrayBuffer
import ssng.scenarios.Scenario

class Simulator(var persons: ArrayBuffer[Person],var scenarios: ArrayBuffer[ArrayBuffer[Scenario]], var days: Int ){

  var stats: ArrayBuffer[ArrayBuffer[(Int, Int)]] = new ArrayBuffer[ArrayBuffer[(Int,Int)]]
	def run(days: Int) {
	  	this.days = days
        println("test")
		stats = new ArrayBuffer[ArrayBuffer[(Int, Int)]]
        println("test2")
	  	for(day <- 0 to days) {
          println("test3")
			for(p <- persons) {
              println("test4")
				stats(day)(p.id) = p.simulate()
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
		    println("Probability for "+p.name+" "+stats(day)(p.id))
		  }
	  }
	}
}
