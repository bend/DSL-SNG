package ssng.dsl
case class Duration(val amount: Int) {
  def years = amount*365
  def weeks = amount*52
}
