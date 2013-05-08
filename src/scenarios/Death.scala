package scenarios

import scala.util.Random
import scala.math
import api.Person

class Death extends Scenario {
  name = "Death"

  override def simulate(p: Person, day: Int): (Float, Float) = {
    var chance_death: Float = 0
    var age_year: Int = p.age / 365
    if(age_year > 100){
      println("100%")
      return (0f, 100)
    }
    chance_death = P(age_year)
    println("Death at age : "+age_year + " : " +chance_death*100)
    return (0f, chance_death*100)
  }

  def F(k: Int): Float = {
    // Quotient de mortalité tous les ans en Belgique
    // http://www.iabe.be/sites/default/files/bijlagen/annexesterftetafels_0.pdf
    val quotients = Array(0.002996, 0.000407, 0.000222, 0.000124, 0.000093, 0.000121, 0.000131, 0.000122, 0.000111, 0.000103, 0.000111, 0.000085, 0.000075, 0.000076, 0.000127, 0.000173, 0.000213, 0.000240, 0.000262, 0.000263, 0.000217, 0.000302, 0.000355, 0.000332, 0.000231, 0.000219, 0.000283, 0.000325, 0.000419, 0.000441, 0.000396, 0.000420, 0.000476, 0.000489, 0.000463, 0.000498, 0.000545, 0.000617, 0.000734, 0.000853, 0.000928, 0.001058, 0.001231, 0.001292, 0.001307, 0.001332, 0.001544, 0.001969, 0.002237, 0.002235, 0.002469, 0.002892, 0.003265, 0.003433, 0.003619, 0.003908, 0.004153, 0.004556, 0.004859, 0.005156, 0.005529, 0.005888, 0.006502, 0.007034, 0.007887, 0.008670, 0.008811, 0.009493, 0.010665, 0.011501, 0.012533, 0.013913, 0.015392, 0.016174, 0.018061, 0.021079, 0.023059, 0.026210, 0.030869, 0.035736, 0.041780, 0.046601, 0.053228, 0.062107, 0.070182, 0.081143, 0.092840, 0.104369, 0.115337, 0.129334, 0.146011, 0.165916, 0.187040, 0.201735, 0.221570, 0.246472, 0.269561, 0.277234, 0.289864, 0.320471, 0.347597, 0.367648, 0.361963, 0.348921, 1.000000)

    var ret: Double = 1.f
    for (i <- 0 to k) {
      ret = ret * (1 - quotients(i))
    }
    return ret.toFloat
  }

  def P(k: Int): Float = {
    return F(k) - F(k + 1)
  }
}