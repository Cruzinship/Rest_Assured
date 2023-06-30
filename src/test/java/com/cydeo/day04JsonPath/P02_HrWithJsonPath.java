package com.cydeo.day04JsonPath;

import com.cydeo.day06DeserializationContinued.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class P02_HrWithJsonPath extends HrTestBase {

    @DisplayName("GET all /countries")
    @Test
    public void test1() {
        Response response = get("/countries");
//response.prettyPrint();
        //verify status code
        response.prettyPrint();
        assertEquals(200, response.statusCode());
        //create jsonpath object
        JsonPath jsonPath = response.jsonPath();
        //get me 3rd country name
        System.out.println("jsonPath.getString(\"item[2].country_name\") = " + jsonPath.getString("items[2].country_name"));
        //get me 3rd and 4th country name
        System.out.println("jsonPath.getString(\"items[2,3].country_name\") = " + jsonPath.getString("items[2,3].country_name"));
        //get me all country name where region_id is 2
        List<String> AllCountryNames = response.path("items.country_name");
        System.out.println("AllCountryNames = " + AllCountryNames);

    }

    /*
   Given accept type is application/json
   And query param limit is 200
   When user send request /employees
   Then user should see ............
    */
    @DisplayName("GET all /employees?limit=200 with JsonPath")
    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON).queryParam("limit", 200).get("/employees");
        //response.prettyPrint();

        //assert status code
        assertEquals(200, response.statusCode());
        //create jsonPath object
        JsonPath jsonPath = response.jsonPath();
        //get all emails from response
        List<String> AllEmails = jsonPath.getList("items.email");
        System.out.println("AllEmails = " + AllEmails);
        System.out.println("AllEmails.size() = " + AllEmails.size());
        //get all emails who is working as IT_PROG
        List<String> emailsOfItProg = jsonPath.getList("items.findAll {it.job_id=='IT_PROG'}.email");
        System.out.println("emailsOfItProg = " + emailsOfItProg);
        //get me all employees first names whose salary is more than 10000
        List<Objects> allEmpSalaryMoreThan10k = jsonPath.getList("items.findAll {it.salary>1000}.first_name");
        System.out.println("allEmpSalaryMoreThan10k = " + allEmpSalaryMoreThan10k);
        //get me all information from response who has max salary
        System.out.println("jsonPath.getString(\"items.max {it.salary}\") = " + jsonPath.getString("items.max {it.salary}"));
        //get me first name from response who has max salary
        System.out.println("jsonPath.getString(\"items.max {it.salary}, first_name\") = " + jsonPath.getString("items.max {it.salary}.first_name"));
        //get me firstname from response who has min salary
        System.out.println("jsonPath.getString(\"items.min {it.salary}.first_name\") = " + jsonPath.getString("items.min {it.salary}.first_name"));
    }

    @DisplayName("A Task")
    @Test
    public void HwTask() {
        //   TASK
        //    Given
        //             accept type is application/json
        //     When
        //             user sends get request to /locations
        Response response = given()
                .accept(ContentType.JSON)
                .get("/locations");
        //Then
// response status code must be 200
        assertEquals(200, response.statusCode());
        //content type equals to application/json
        assertEquals("application/json", response.contentType());
        //get the second city with JsonPath
        JsonPath jsonPath = response.jsonPath();
        System.out.println("jsonPath.getString(\"items[2].city\") = " + jsonPath.getString("items[2].city"));
        //get the last city with JsonPath
        System.out.println("jsonPath.getString(\"items[-1].city\") = " + jsonPath.getString("items[-1].city"));
        //get all country ids
        List<String> allIds = jsonPath.getList("items.country_id");
        System.out.println("allIds = " + allIds);
        // get all city where their country id is UK
        List<Objects> AllCityWhereCountryIdIsUK = jsonPath.getList("items.findAll {it.country_id == 'UK'}.city");
        System.out.println("AllCityWhereCountryIdIsUK = " + AllCityWhereCountryIdIsUK);

    }
}
