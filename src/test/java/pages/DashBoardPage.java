package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashBoardPage extends CommonMethods {
    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimBtn;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeListBtn;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeBtn;
    @FindBy(id="welcome")
    public WebElement welcomeAdminLocator;

    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }
}
