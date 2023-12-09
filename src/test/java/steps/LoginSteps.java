package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.log.Log;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    @Given("when user is navigated to HRMS application")
    public void when_user_is_navigated_to_hrms_application() {
        // driver=new ChromeDriver();
        //driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        openBrowserAndLaunchApp();
    }
    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() {
       //object of login page class to access all the webelements
      //  LoginPage lp=new LoginPage();
        //WebElement userNameTextField=driver.findElement(By.xpath("//*[@id='txtUsername']"));
     //   userNameTextField.sendKeys("admin");
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("username"));
      //  WebElement passwordField=driver.findElement(By.cssSelector("input#txtPassword"));
       // passwordField.sendKeys("Hum@nhrm123");
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        sendText(loginPage.passWordTextField,ConfigReader.getPropertyValue("password"));
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button()  {
      // WebElement loginBtn=driver.findElement(By.xpath("//*[@id='btnLogin']"));
       // LoginPage lp=new LoginPage();
        click(loginPage.loginBtn);
      // loginBtn.click();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("My test has passed");
        //assertions to check if the element exists.
        //asseert true, it is a boolean condition to check if it returns true or false.
        Assert.assertTrue(dashBoardPage.welcomeAdminLocator.isDisplayed());


    }


}
