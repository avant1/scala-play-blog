package bootstrap.blog.ui

import bootstrap.common.UiStepDefinitions
import cucumber.api.PendingException
import cucumber.api.scala.{EN, ScalaDsl}
import org.fluentlenium.core.filter.Filter
import org.scalatest.Matchers
import repository.InMemoryBlogPostRepository

class StepDefinitions extends ScalaDsl with UiStepDefinitions with EN with Matchers {

  Before() { s =>
    InMemoryBlogPostRepository.reset()
  }

  Given("""^I am blog owner (.+)$""") { (name: String) =>
    empty
  }

  When("""^I create blog post "([^"]+)" with contents$""") { (title: String, contents: String) =>
    browser.goTo(controllers.routes.BlogController.index().toString)
    browser.click(".add-post")

    browser.findFirst("[name=title]").fill `with` title
    browser.findFirst("[name=content]").fill `with` contents

    browser.click("""[value="Add post"]""")
  }

  Then("""^I should see blog post with title "(.+?)" on blog index page$""") { (title: String) =>
    browser.goTo(controllers.routes.BlogController.index().toString)

    assert(browser.pageSource().contains(title), "Expected that page will contain blog post title, but none found.")
  }

  Then("""^this blog post should have preview text "(.+)"$""") { (previewText: String) =>
    browser.goTo(controllers.routes.BlogController.index().toString)

    assert(browser.pageSource().contains(previewText))
  }

  When("""^I go to this blog post view page$""") { () =>
    browser.click(".read-more")
  }

  Then("^I should see complete blog post contents$") { (contents: String) =>
    assert(browser.pageSource().contains(contents))
  }

  When("""^I create hidden blog post "([^"]+)" with contents$""") { (title: String, contents: String) =>
    browser.goTo(controllers.routes.BlogController.index().toString)
    browser.click(".add-post")

    browser.findFirst("[name=title]").fill `with` title
    browser.findFirst("[name=content]").fill `with` contents

    browser.findFirst("[name=isHidden]").click()

    browser.click("""[value="Add post"]""")

    assert(browser.url() == controllers.routes.BlogController.index().toString)
  }

  Then("^I should see no posts on blog index page$") { () =>
    browser.goTo(controllers.routes.BlogController.index().toString)
    assert(browser.find(".blog-post").isEmpty)
  }

  When("^I try to create blog post with empty title$") { () =>
    browser.goTo(controllers.routes.BlogController.index().toString)
    browser.click(".add-post")
    browser.findFirst("[name=content]").fill `with` "some content" * 100

    browser.click("""[value="Add post"]""")
  }

  Then("""^I should receive validation message saying that title should not have empty value$""") { () =>
    assert(browser.url() == controllers.routes.BlogController.savePost().toString)
    assert(browser.pageSource().contains("This field is required"))
  }


}
