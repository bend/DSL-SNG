package api

import scala.collection.mutable.ArrayBuffer
import scenarios.Scenario

object Simulator {
	var persons: ArrayBuffer[Person] = null
	var scenarios: ArrayBuffer[ArrayBuffer[Scenario]] = null
	var stats: ArrayBuffer[ArrayBuffer[(Int, Int)]] = null
	var days: Int = 0
	
	
	def run(days: Int) {
	  	this.days = days
		stats = new ArrayBuffer[ArrayBuffer[(Int, Int)]]
	  	for(day <- 0 to days) {
			for(p <- persons) {
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
