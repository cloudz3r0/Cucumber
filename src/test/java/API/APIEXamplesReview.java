package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class APIEXamplesReview {
    RequestSpecification request;
    String baseURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDE5MTE0NTEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTk1NDY1MSwidXNlcklkIjoiODMifQ.1liCO7uUzTrxHRmvWBCE6-MWhtxMKpflqpRYzKiShv0";

    @Test
    public void createEmployee() {
        RequestSpecification request = given().header("Content-Type", "application/json").header("Authorization", token)
                .body("{\n" +
                        "   \n" +
                        "  \"emp_firstname\": \"Adrian\",\n" +
                        "  \"emp_lastname\": \"Gerardo\",\n" +
                        "  \"emp_middle_name\": \"G\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2002-11-29\",\n" +
                        "  \"emp_status\": \"here\",\n" +
                        "  \"emp_job_title\": \"hi\"\n" +
                        "  \n" +
                        "}");


        //    send the request to the endpoint
        Response response = request.when().post("/createEmployee.php");

//    response.prettyPrint();
//    extract the response in the form of string
        ResponseBodyExtractionOptions resp = response.then().extract().body();
        System.out.println(resp.asString());

//    extract the value of the key message
        String message = response.jsonPath().getString("Message");
//    asseretion
        Assert.assertEquals(message,"Employee Created");

        //Assert tha the employee firstname is Adrian
        String fname=response.jsonPath().getString("Employee.emp_firstname");
        Assert.assertEquals(fname,"Adrian");
    }
}
