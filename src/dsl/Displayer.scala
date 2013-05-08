package dsl
import api._

object Show {
  var is_detailed: Boolean = false
  def stats_for(duration: Int) {
    Simulator.get_stats(duration, this.is_detailed)
  }

  def detailed(): ShowTmp = {
    return new ShowTmp(true)
  }
}

class ShowTmp(detailed: Boolean) {
  def stats_for(duration: Int) {
    Simulator.get_stats(duration, this.detailed)
  }

}