package bootstrap.common

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import play.api.test.{FakeApplication, Helpers, TestBrowser, TestServer}

trait UiStepDefinitions {

  this: ScalaDsl =>

  val webDriverClass = Helpers.HTMLUNIT

  val app = FakeApplication()
  val port = 3333


  lazy val browser: TestBrowser = TestBrowser.of(webDriverClass, Some("http://localhost:" + port))
  lazy val server = TestServer(port, app)

  Before() { s =>
    server.start()
  }


  After() { s =>
    server.stop()
    browser.quit()
  }



}
