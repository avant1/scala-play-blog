package bootstrap

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

class StepDefinitions extends ScalaDsl with EN with Matchers {

  var number: Int = _

  Given("""^I have number (-?\d+)$"""){ (inputNumber: Int) =>
    number = inputNumber
  }
  When("""^I add to this number (-?\d+)$"""){ (anotherNumber: Int) =>

    number += anotherNumber

  }
  Then("""^the result should be (-?\d+)$"""){ (expectedResult: Int) =>
    assertResult(expectedResult)(number)
  }

}
