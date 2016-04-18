package bootstrap.ui.Calculation

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import services.Calculation.Calculator

class StepDefinitions extends ScalaDsl with EN with Matchers {


  Given("""^I have number (-?\d+)$"""){ (firstInputNumber: Int) =>
    throw new Exception("Not implemented")
  }
  When("""^I add to this number (-?\d+)$"""){ (anotherNumber: Int) =>
    throw new Exception("Not implemented")
  }
  Then("""^the result should be (-?\d+)$"""){ (expectedResult: Int) =>
    throw new Exception("Not implemented")
  }

}
