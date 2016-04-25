package bootstrap.calculation.domain

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import services.Calculation.Calculator

class StepDefinitions extends ScalaDsl with EN with Matchers {

  var firstInputNumber: Float = _
  var sign: String = ""
  var secondInputNumber: Float = 0

  val calculator = Calculator

  Given("""^I have number (-?\d+)$"""){ (firstInputNumber: Int) =>
    this.firstInputNumber = firstInputNumber
  }
  When("""^I add to this number (-?\d+)$"""){ (anotherNumber: Int) =>
    sign = "+"
    secondInputNumber = anotherNumber
  }
  Then("""^the result should be (-?\d+)$"""){ (expectedResult: Int) =>
    assertResult(expectedResult)(calculator.calculate(firstInputNumber, sign, secondInputNumber))
  }

}
