package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DashBoardPage;
import utils.CommonMethods;
import utils.Constants;
import utils.DbUtils;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        //WebElement addEmployeeButton = driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']"));
        click(dashBoardPage.addEmployeeBtn);
    }

    @When("user enters firstName middleName and lastName")
    public void user_enters_first_name_middle_name_and_last_name() {
        // WebElement firstNameField = driver.findElement(By.id("firstName"));
        //WebElement middleNameField = driver.findElement(By.id("middleName"));
        // WebElement lastNameField = driver.findElement(By.id("lastName"));

        sendText(addEmployeePage.firstNameTxt, "nind");
        sendText(addEmployeePage.middleNameTxt, "esha");
        sendText(addEmployeePage.lastNameTxt, "lata");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        // WebElement saveBtn = driver.findElement(By.id("btnSave"));
        click(addEmployeePage.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added");
    }

    @Then("user closes the browser")
    public void user_closes_the_browser() {
        closeBrowser();
    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstN, String middleN, String lastN) {
        //   WebElement firstNameField = driver.findElement(By.id("firstName"));
        // WebElement middleNameField = driver.findElement(By.id("middleName"));
        // WebElement lastNameField = driver.findElement(By.id("lastName"));

        sendText(addEmployeePage.firstNameTxt, firstN);
        sendText(addEmployeePage.middleNameTxt, middleN);
        sendText(addEmployeePage.lastNameTxt, lastN);
    }

    @When("user enters {string} and {string} and enters {string}")
    public void user_enters_and_and_enters(String firstN, String middleN, String lastN) {
        // WebElement firstNameField = driver.findElement(By.id("firstName"));
        //  WebElement middleNameField = driver.findElement(By.id("middleName"));
        //WebElement lastNameField = driver.findElement(By.id("lastName"));

        sendText(addEmployeePage.firstNameTxt, firstN);
        sendText(addEmployeePage.middleNameTxt, middleN);
        sendText(addEmployeePage.lastNameTxt, lastN);
    }

    @When("user adds Multiple employees from excel using {string} and verify it")
    public void user_adds_multiple_employees_from_excel_using_sheet1_and_verify_it(String sheetName) throws InterruptedException {
        //might get a null pointer exception. Make sure the names of the keys are the same and the sheet name is the same
        List<Map<String, String>> newEmployees =
                ExcelReader.read(sheetName, Constants.TESTDATA_FILEPATH);

        //from the list of maps, we need one map at one point of time
        // this iterator will give me one map to add one employee at a time
        Iterator<Map<String, String>> itr = newEmployees.iterator();
        //it checks whether we have values in map or not
        while (itr.hasNext()){
            //it will return the keys and the values of the map which we store in this
            // variable
            Map<String, String> employeeMap = itr.next();
            sendText(addEmployeePage.firstNameTxt, employeeMap.get("firstName"));
            sendText(addEmployeePage.middleNameTxt, employeeMap.get("middleName"));
            sendText(addEmployeePage.lastNameTxt, employeeMap.get("lastName"));
            sendText(addEmployeePage.photograph, employeeMap.get("Photograph"));
            if(!addEmployeePage.checkBox.isSelected()){
                click(addEmployeePage.checkBox);
            }
            sendText(addEmployeePage.usernameEmp, employeeMap.get("Username"));
            sendText(addEmployeePage.passwordEmp, employeeMap.get("Password"));
            sendText(addEmployeePage.confirmPassword, employeeMap.get("confirmPassword"));
           String employeeIdValue=
                   addEmployeePage.employeeIdLocator.getAttribute("value");
            click(addEmployeePage.saveBtn);
            Thread.sleep(2000);
            //verify the employee
            click(dashBoardPage.employeeListBtn);
            //we need to search employee by the stored employee id
            sendText(employeeSearchPage.empSearchIdField,employeeIdValue );
            //click on search button after entering employee id.
            click(employeeSearchPage.searchBtn);
            //after searching the employee it returns the info in format
            //empId firstName middleName lastName this is the format
            List<WebElement> rowData=
            driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for (int i = 0; i < rowData.size(); i++) {
                //it will give me the data from each cell of the row.
              String rowText=  rowData.get(i).getText();
                System.out.println(rowText);
                //we are getting the data from excel to compare it with web table data.
                String expectedDataFromExcel=employeeIdValue+" "+employeeMap.get("firstName")+" "+ employeeMap.get("middleName")+" "+ employeeMap.get("lastName");
                System.out.println(expectedDataFromExcel);

                Assert.assertEquals(expectedDataFromExcel,rowText);

            }
//because we want to add many employees
            click(DashBoardPage.dashBoardPage.addEmployeeBtn);
            Thread.sleep(2000);
            //verification of employee still pending
        }

    }
    @When("user adds multiple employees from data table")
    public void user_adds_multiple_employees_from_data_table
            (io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        for (Map<String, String> map:employeeNames
        ) {
            sendText(addEmployeePage.firstNameTxt, map.get("firstName"));
            sendText(addEmployeePage.middleNameTxt, map.get("middleName"));
            sendText(addEmployeePage.lastNameTxt, map.get("lastName"));
            click(addEmployeePage.saveBtn);
            Thread.sleep(2000);
            click(DashBoardPage.dashBoardPage.addEmployeeBtn);
            Thread.sleep(2000);
        }}


        }




