package bootstrap.calculation.ui

import bootstrap.common.UiStepDefinitions
import org.openqa.selenium.By
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.firefox.FirefoxDriver
import org.scalatest.Matchers
import play.api.Logger
import play.api.test._
import org.openqa.selenium._
import org.fluentlenium.core.filter.FilterConstructor._
import org.scalatest.selenium.HtmlUnit

class StepDefinitions extends ScalaDsl with UiStepDefinitions with EN with Matchers {

  Given("""^I have number (-?\d+)$"""){ (firstInputNumber: Float) =>
    browser.goTo(controllers.routes.CalculationController.index().toString)
    Logger.debug("Visited!!!")
    browser.find("#firstInputNumber").text(firstInputNumber.toString)
  }

  When("""^I add to this number (-?\d+)$"""){ (anotherNumber: Float) =>
    browser.find("#secondInputNumber").text(anotherNumber.toString)
    browser.fillSelect("#sign").withValue("+")

  }

  Then("""^the result should be (-?\d+)$"""){ (expectedResult: Float) =>
    browser.click(withName("submit"))

    assertResult(true)(browser.pageSource().contains("And the answer is"))
    assertResult(expectedResult)(browser.$("#calculation-result").getText.toFloat)
  }

}
