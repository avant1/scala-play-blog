package runners.blog

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("test/features/blog/ui"),
  plugin = Array("pretty"),
  glue = Array("bootstrap.blog.ui"),
  tags = Array("~@wip")

)
class RunBlogUiTests extends {


}
