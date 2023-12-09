package utils;

import APISteps.APIWorkflowSteps;
import org.json.JSONObject;

public class APIPayloadConstants {
    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "   \n" +
                "  \"emp_firstname\": \"Adrian\",\n" +
                "  \"emp_lastname\": \"Gerardo\",\n" +
                "  \"emp_middle_name\": \"G\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2002-11-29\",\n" +
                "  \"emp_status\": \"here\",\n" +
                "  \"emp_job_title\": \"hi\"\n" +
                "  \n" +
                "}";
        return createEmployeePayload;
    }

    public static String generateTokenPayload() {
        String GenerateToken = "{\n" +
                "  \"email\": \"test@adrian.com\",\n" +
                "  \"password\": \"cloud\"\n" +
                "}";
        return GenerateToken;
    }

    public static String createEmployeeJsonPayload
            () {
       JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Adrian");
        obj.put("emp_lastname", "Gerardo");
        obj.put("emp_middle_name", "G");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday","2002-11-29");
        obj.put("emp_status", "here");
        obj.put("emp_job_title", "hi");
        return obj.toString();
    }

   public static String payloadDynamic(String emp_firstName, String emp_lastname,
                                       String emp_middle_name, String emp_gender, String emp_birthday,String emp_status,String emp_job_title) {
       JSONObject obj = new JSONObject();
       obj.put("emp_firstname",emp_firstName);
       obj.put("emp_lastname",emp_lastname);
       obj.put("emp_middle_name",emp_middle_name);
       obj.put("emp_gender",emp_gender);
       obj.put("emp_birthday",emp_birthday);
       obj.put("emp_status",emp_status);
       obj.put("emp_job_title",emp_job_title);

       return obj.toString();
    }
public static String updateEmployeePayload(){
    JSONObject obj = new JSONObject();
    //obj.put("employee_id", APIWorkflowSteps.employee_id);
    obj.put("employee_id","98371A");

    obj.put("emp_firstname", "Adrian");
    obj.put("emp_lastname", "Gerardo");
    obj.put("emp_middle_name", "G");
    obj.put("emp_gender", "M");
    obj.put("emp_birthday","2002-11-29");
    obj.put("emp_status", "Fired");
    obj.put("emp_job_title", "hi");
    return obj.toString();
}
}
