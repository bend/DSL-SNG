package api

import scala.collection.mutable.ArrayBuffer
import scenarios._
object Main extends App {
	// Simulator init 
	//Simulator run 5
    var scenarios = new ArrayBuffer[Scenario]();
    scenarios+= new Notification()

    var p1 = new Person("Ben D", 23,Relations(350,1,5,0,20), Params(10, 10, 50, 10),scenarios)
    var p2 = new Person("Chris C", 24,Relations(420,1,4,0,0), Params(2, 0, 50, 10),scenarios)
    Simulator add_person p1
    Simulator add_person p2
    Simulator run 10
    Simulator get_stats(7,false)

}
