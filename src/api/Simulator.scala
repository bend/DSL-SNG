package api

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scala.util.Random
import scenarios.Scenario

object Simulator {
  var persons: ArrayBuffer[Person] = new ArrayBuffer[Person]()
  var stats: HashMap[Person, Array[HashMap[String, (Float, Float)]]] = new HashMap[Person, Array[HashMap[String, (Float, Float)]]]()
  var days: Int = 0
  var scenarios: ArrayBuffer[Scenario] = new ArrayBuffer[Scenario]()

  def add_person(person: Person) {
    persons += person
  }

  def run(days: Int) {
    this.days = days
    for (day <- 1 to days) {
      for (p <- persons) {
        if (!stats.contains(p)) stats(p) = new Array[HashMap[String, (Float, Float)]](days)
        p.scenarios = scenarios
        stats(p)(day - 1) = p.simulate(day)
        //println("Stat " + p.name + " : " + stats(p)(day - 1))
        p.age += 1
        //println("Age of " + p.name + " is " + p.age / 365 + " years or " + p.age + " days")
      }
    }

  }
  /**
   * If period = 1 -> each day
   * If period = 7 -> each week
   * if period = 30 -> each month
   * if period = 365 -> each year
   */
  def get_stats(period: Int, detailed: Boolean) {

    var sg = new HashMap[String, (Float, Float)]()
    var sd = new HashMap[String, HashMap[String, (Float, Float)]]()

    var i = 1
    for (day <- 1 to days) {
      if (i == 1) {
        println("Day " + day)
      }
      for (p <- persons) {
        var s = stats(p)(day - 1)
        if (!sg.contains(p.name)) sg(p.name) = (0f, 0f)
        if (!sd.contains(p.name)) sd(p.name) = new HashMap[String, (Float, Float)]()
        for (sc <- s) {
          sg(p.name) = (sg(p.name)._1 + sc._2._1, sg(p.name)._2 + sc._2._2)
          if (!sd(p.name).contains(sc._1)) sd(p.name)(sc._1) = (0f, 0f)
          sd(p.name)(sc._1) = (sd(p.name)(sc._1)._1 + sc._2._1, sd(p.name)(sc._1)._2 + sc._2._2)
        }
        if (i == 1) {
          var time_elapsed = (if (day == 1) 1 else period)
          println("Stats globales " + p.name + " : Join " + sg(p.name)._1 / time_elapsed + "%, Leave " + sg(p.name)._2 / time_elapsed + "%")
          if (detailed) {
            for (sc <- sd(p.name)) {
              println("   " + sc._1 + " : Join " + sc._2._1 / time_elapsed + "%, Leave " + sc._2._2 / time_elapsed + "%")
            }
          }
          sg(p.name) = (0f, 0f) // stats globales
        }
      }
      if (i == 1) {
        println()
      }
      i += 1
      if (i >= period) { i = 1 }

    }
  }
  
  /**
   * If period = 1 -> each day
   * If period = 7 -> each week
   * if period = 30 -> each month
   * if period = 365 -> each year
   */
  def get_evolution(period: Int, population: Int) {
    var sg = new HashMap[String, (Float, Float)]()
    var nb_join = new HashMap[String, Array[Int]]()
    var nb_leave = new HashMap[String, Array[Int]]()

    var i = 1
    for(day <- 1 to days) {
      if(i == 1) {
        println("Evolution on day "+day)
      }
      
      for(p <- persons) {
        var s = stats(p)(day - 1)
        if (!nb_join.contains(p.name)) nb_join(p.name) = new Array[Int](days)
        if (!nb_leave.contains(p.name)) nb_leave(p.name) = new Array[Int](days)
        if (!sg.contains(p.name)) sg(p.name) = (0f, 0f)
        for (sc <- s) {
        	sg(p.name) = (sg(p.name)._1 + sc._2._1, sg(p.name)._2 + sc._2._2)
        }
        
        nb_join(p.name)(day-1) = 0
        nb_leave(p.name)(day-1) = 0
        var rand_join = Array[Int](math.round(sg(p.name)._1))
        var rand_leave = Array[Int](math.round(sg(p.name)._2))

        for(h <- 0 to rand_join.length-1) {
          var rand_n = Random.nextInt(99)
          while(rand_join.contains(rand_n) & rand_join.length < 99)
            rand_n = Random.nextInt(99)
          rand_join(h) = rand_n
        }
        
        for(h <- 0 to rand_leave.length-1) {
          var rand_n = Random.nextInt(99)
          while(rand_leave.contains(rand_n) & (rand_join.length + rand_leave.length) < 99)
            rand_n = Random.nextInt(99)
          rand_leave(h) = rand_n
        }
        
        for(j <- 1 to population) {
           var rand_n = Random.nextInt(99)
           if(rand_join.contains(rand_n)) {
        	   nb_join(p.name)(day-1) += 1
           } else if(rand_leave.contains(rand_n)) {
    		   nb_leave(p.name)(day-1) += 1
           }
        }
        sg(p.name) = (0f, 0f) // stats globales
      }
      
      if(i == 1) {
        for(p <- persons) {
          var evol = 0
	      if(day == 1) {
	        evol = nb_join(p.name)(0) - nb_leave(p.name)(0)
	      } else {
	          for(d <- day-period to day-1) {
	            evol += nb_join(p.name)(d) - nb_leave(p.name)(d)
	          }
	      }
          println("  " + evol + " new members like " + p.name)
        }
      }
      
      i += 1
      if (i >= period) { i = 1 }
    }
    
    println()
    println("Total evolution of the population after "+days+" days")
    for(p <- persons) {
      var evol = 0
      for(d <- 1 to days-1) {
        evol += nb_join(p.name)(d-1) - nb_leave(p.name)(d-1)
      } 
      println("New members like "+p.name+" : " + evol + " members")
    }
  }
}
