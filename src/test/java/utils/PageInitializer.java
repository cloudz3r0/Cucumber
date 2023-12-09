package utils;

import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class PageInitializer {
    public static LoginPage loginPage;
    public static DashBoardPage dashBoardPage;

    public static EmployeeSearchPage employeeSearchPage;


    public static AddEmployeePage addEmployeePage;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        dashBoardPage = new DashBoardPage();
        employeeSearchPage = new EmployeeSearchPage();
        addEmployeePage = new AddEmployeePage();
    }
}
