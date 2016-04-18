package controllers

import javax.inject._

import org.joda.time._
import play.api.mvc._
import services.Calculation.Calculator

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class CalculationController @Inject() extends Controller {

  def index(firstInputNumber: Float, sign: String, secondInputNumber: Float, submit: String) = Action {

    val calculator = Calculator
    val formWasSubmitted = submit != ""
    var calculationResult: Float = 0

    if (formWasSubmitted) {
      calculationResult = calculator.calculate(firstInputNumber, sign, secondInputNumber)
    }

    Ok(views.html.calculation.index(firstInputNumber, sign, secondInputNumber, formWasSubmitted, calculationResult))
  }

}
