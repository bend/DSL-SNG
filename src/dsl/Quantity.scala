package dsl
case class Quantity(val amount: Int) {
  def years = amount * 365
  def year = amount * 365
  def months = amount * 30
  def month = amount * 30
  def weeks = amount * 7
  def week = amount * 7
  def days = amount
  def day = amount
  def person = amount
  def persons = amount
}
