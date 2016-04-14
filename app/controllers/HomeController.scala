package controllers

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Calendar
import javax.inject._

import play.api._
import play.api.mvc._
import org.joda.time._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject() extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index(name: String) = Action {
    val now = (new DateTime).withZone(DateTimeZone.forID("Europe/Minsk"))
    val isTooLate = now.getHourOfDay >= 22 || now.getHourOfDay < 8

    Ok(views.html.index(name, now.toString("Y-m-d H:mm:s"), isTooLate))
  }

}
