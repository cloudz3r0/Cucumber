package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    @Before
    public void start(){
        openBrowserAndLaunchApp();
    }

    @After
    public void end(Scenario scenario){
        byte[] pic;
        //we can take the screenshot before closing the browser
        //scenario class in cucumber which will give me the information
        //of the execution. It holds the complete information of the execution
        //getName is the method which returns the name of the scenario.
     if(scenario.isFailed()){
         pic= takeScreenshot("failed/"+scenario.getName());
     }else{
         pic= takeScreenshot("passed/"+scenario.getName());
     }
     //pic is array of byte, image/png is media type, getname is name of scenario.
     scenario.attach(pic,"image/png",scenario.getName());
        closeBrowser();
    }
}