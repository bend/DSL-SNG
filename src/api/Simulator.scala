package api

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scenarios.Scenario

object Simulator{
  var persons: ArrayBuffer[Person] = new ArrayBuffer[Person]()
  var stats: HashMap[Person, Array[HashMap[String, (Float,Float)]]] = new HashMap[Person, Array[HashMap[String, (Float,Float)]]]()
  var days = 0
  var scenarios : ArrayBuffer[Scenario] = new ArrayBuffer[Scenario]()

  def add_person(person: Person) {
    persons+=person
  }

	def run(days: Int) {
	  	this.days = days
	  	for(day <- 1 to days) {
			for(p <- persons) {
              if(!stats.contains(p)) stats(p) = new Array[HashMap[String, (Float,Float)]](days)
              p.scenarios = scenarios
              stats(p)(day-1) = p.simulate(day)
			}
	  	}
	  	
	}
	/*
	 * Display the probabilities for each day and each type of person to join/leave, depending on the scenarios
	 */
	def show() {
	}
	/**
	 * If period = 0 -> each day
	 * If period = 1 -> each week
	 * if period = 2 -> each month
	 * if period = 3 -> each year
	 */
	def get_stats(value: Int) {
	  
	  var sg = HashMap[String, (Float, Float)]()
	  
	  var period = 1
	  if(value == 0) period = 1
	  else if(value == 1) period = 7
	  else if(value == 2) period = 30
	  else if(value == 3) period = 365
	  
	  var i = 1
	  for(day <- 1 to days) {
		  if(i == 1) {
			println("Day "+day)
		  }
		  for(p <- persons) {
			var s = stats(p)(day-1)
			if(!sg.contains(p.name))  sg(p.name) = (0f, 0f)
			for(sc <- s) {
				sg(p.name) = (sg(p.name)._1 + sc._2._1, sg(p.name)._2 + sc._2._2)
			}
			if(i == 1) {
				var time_elapsed = (if(day == 1) 1 else period)
				println("Stats globales "+p.name+" : ("+sg(p.name)._1/time_elapsed+","+sg(p.name)._2/time_elapsed+")")
				sg(p.name) = (0f, 0f) // stats globales
			}
		  }
		  if(i == 1) {
			println()
		  }
		  i += 1
		  if(i >= period) { i = 1 }
		  
	  }
	}
}
