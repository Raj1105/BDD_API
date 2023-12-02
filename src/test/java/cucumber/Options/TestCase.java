package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/AddPlace.feature", 
monochrome=true,
plugin= {"pretty",
"json:target/jsonReports/cucumber-report.json"},
glue = { "StepDefinition" }
)
//tags =  "@DeletePlace" 

public class TestCase {

}
