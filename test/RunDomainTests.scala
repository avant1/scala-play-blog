import cucumber.api.{CucumberOptions, PendingException}
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith
import cucumber.api.junit.Cucumber._
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("test/features"),
  plugin = Array("pretty"),
  tags = Array("@domain"),
  glue = Array("bootstrap.domain")

)
class RunDomainTests extends {


}
