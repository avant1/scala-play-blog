package runners.calculation

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("test/features"),
  plugin = Array("pretty"),
  tags = Array("@domain"),
  glue = Array("bootstrap.calculation.domain")

)
class RunDomainTests extends {


}
