package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDE1MzIwNzksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTU3NTI3OSwidXNlcklkIjoiODMifQ.2Ao61acaopXKY2E4mrKm10MM6QXbFrT8BrLlmumjDfw";
    static String employee_id;

    @Test
    public void acreateEmployee() {
        //prepare the request
        //request specification allows use to prepare the request and put it in a variable.
        RequestSpecification request = given().header("Content-Type", "application/json").header("Authorization", token).
                body("{\n" +
                        "\"emp_firstname\": \"Adrian\",\n" +
                        "  \"emp_lastname\": \"Gerardo\",\n" +
                        "  \"emp_middle_name\": \"G\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2002-11-29\",\n" +
                        "  \"emp_status\": \"here\",\n" +
                        "  \"emp_job_title\": \"hi\"\n" +
                        "  \n" +
                        "}");
        //send the request
        Response response = request.when().post("/createEmployee.php");
        response.prettyPrint();


        //validate the response
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Adrian"));
        response.then().assertThat().header("Connection", equalTo("Keep-Alive"));
        employee_id = response.jsonPath().getString("Employee.employee_id");

    }

    @Test
    public void bgetCreatedEmployee() {
        RequestSpecification request = given().
                header("Authorization", token)
                .header("Content-type", "application/json").
                queryParam("employee_id", employee_id);
        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //validate the employees id from post call
        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(tempEmpId, employee_id);

    }

    @Test
    public void cUpdateEmployee() {
        RequestSpecification request = given().header("Content-Type", "application/json")
                .header("Authorization", token)
                .body("{\n" +
                        "\"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Adrian\",\n" +
                        "  \"emp_lastname\": \"Franco\",\n" +
                        "  \"emp_middle_name\": \"string\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2023-11-29\",\n" +
                        "  \"emp_status\": \"Fired\",\n" +
                        "  \"emp_job_title\": \"None\"\n" +
                        "  }");
        Response response = request.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);


    }

    @Test
    public void dgetupdatedEmployee(){
        //prepare the request
        RequestSpecification request = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);
        Response response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //validate the employee id's one from post call another from get call
        String tempEmpId = response.jsonPath().
                getString("employee.employee_id");
        Assert.assertEquals(tempEmpId, employee_id);
    }

}
