package ssng.api

import scala.collection.mutable.ArrayBuffer
import ssng.scenarios._
object Main extends App {
	// Simulator init 
	//Simulator run 5
    var scenarios = new ArrayBuffer[Scenario]();
    scenarios+= new Notification()
    var persons = new ArrayBuffer[Person]()
    persons+=new Person(Name("Ben","D"), 23,Relations(350,1,5,0,20), Params(10, 10, 10, 50),scenarios)
    persons+=new Person(Name("Chris","C"), 24,Relations(420,1,4,0,0), Params(2, 0, 30, 50),scenarios)
  var sim = new Simulator(persons)
  sim run 10
  sim show
}
