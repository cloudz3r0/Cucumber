package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt",
        //ignores java since the resources folder is in test folder not java
        //glues is where we find the implementation of gherkin steps
        //we provide the path of package where we defined all the step definitions
        glue = "steps"
)
public class FailedRunners {
}
