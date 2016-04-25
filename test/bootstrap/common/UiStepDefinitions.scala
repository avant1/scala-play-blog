package bootstrap.common

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import play.api.test.{FakeApplication, Helpers, TestBrowser, TestServer}

trait UiStepDefinitions {

  this: ScalaDsl =>

  val webDriverClass = Helpers.HTMLUNIT

  val app = FakeApplication()
  val port = 3333

  var isRunning = false

  lazy val browser: TestBrowser = TestBrowser.of(webDriverClass, Some("http://localhost:" + port))
  lazy val server = TestServer(port, app)

  Before() { s =>
    if (!isRunning) {
      server.start()
      isRunning = true
    }
  }


  After() { s =>

    if (isRunning) {
      //todo this stuff must be stopped, but if i uncomment this now
      //todo second and subsequent UI scenarios will not be runned
//      server.stop()
//      browser.quit()
    }
  }



}
