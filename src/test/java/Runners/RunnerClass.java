package Runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        //ignores java since the resources folder is in test folder not java
        //glues is where we find the implementation of gherkin steps
        //we provide the path of package where we defined all the step definitions
        glue = "steps",
        //it will stop the execution
        //it quickly scans all the gherkin steps in all the feature files and will give you
        //the missing step Definition.
        //for actual execution we need to set the value of it to false.
        dryRun = false,
        //tags will identify the scenarios in a group and will execute all the scenarios with these tags
        //using and keyword just means the tags must have both tags
        tags = "@test123",
        //for generating the report
        //in yout framework, all reports should be generated under target folder
        //we will generate html report in target folder
        //plugin = {"pretty","html:target/cucumber.html"} for example
        //creates a report in target folder with the name cucumber.html right click and open in chrome to view report
        plugin = {"pretty","html:target/cucumber.html",
                "json:target/cucumber.json", "rerun:target/failed.txt"}
        //rerun plugin that will create failed.txt under target for all failed test cases
)

public class RunnerClass {
    //it will be empty
}
