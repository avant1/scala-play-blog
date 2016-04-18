package services.Calculation

object Calculator {

  def calculate(firstInputValue: Float, sign: String, secondInputValue: Float): Float = sign match {
    case "+" => firstInputValue + secondInputValue
    case "-" => firstInputValue - secondInputValue
    case _ => throw new Exception("Given unknown sign: '%s'. Only addition and substraction are supported".format(sign))
  }

}
