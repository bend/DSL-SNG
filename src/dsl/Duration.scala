package dsl
case class Duration(val amount: Int) {
  def years = amount*365
  def weeks = amount*52
  def year = amount*365
  def week = amount*52
  def day = amount
  def days = amount
  def month = amount*30
  def months = amount*30
}
