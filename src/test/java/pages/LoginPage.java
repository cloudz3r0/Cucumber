package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    @FindBy(id="txtUsername")
    public WebElement usernameTextField;
    @FindBy(id="txtPassword")
    public WebElement passWordTextField;

    @FindBy(id="btnLogin")
    public WebElement loginBtn;

    public LoginPage(){
        //this code will initialize all the elements of the page
        //because when the object is created, constructor will be called which will
        //initialize all of these elements.
        PageFactory.initElements(driver, this);
        //assertions to check if the element exists.
        //asseert true, it is a boolean condition to check if it returns true or false.

    }
    }

