import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("test/features"),
  plugin = Array("pretty"),
  tags = Array("@ui"),
  glue = Array("bootstrap.ui")

)
class RunUiTests extends {


}
