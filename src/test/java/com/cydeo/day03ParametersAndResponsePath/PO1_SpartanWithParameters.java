package com.cydeo.day03ParametersAndResponsePath;

import com.cydeo.day06DeserializationContinued.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class PO1_SpartanWithParameters extends SpartanTestBase {
    /*
    Given Content type is Json
    And id parameter value is 26
    When user sends GET request to /api/spartans/{id}
    Then response status code should be 200
    And response content-type: application/json
    And "Julio should be in response(body)
     */

    @DisplayName("GET Spartan /api/spartans/{id} path param with 26")
    @Test
    public void test1() {
        Response response = given()
                .accept(ContentType.JSON)
                .and().pathParam("id", 24)
                .when()
                .get("/api/spartans/{id}");

        response.prettyPrint();
//Then response status code should be 200
        assertEquals(200, response.statusCode());
//And response content should be application/json
        assertEquals("application/json", response.contentType());
        //And "Julio should be in response(body)
        assertTrue(response.body().asString().contains("Julio"));
    }
    /*
    TASK
    Given accept type is Json
    And Id parameter value is 500
    Whe  user sends Get request to /api/spartans/{id}
    Then response status code should be 404
    And response content-type: application/json
    And "Not Found" message should be in response payload
     */

    @DisplayName("GET Spartan /api/spartan/{id} with invalid ID")
    @Test
    public void Task2() {
        Response response = given()
                .accept(ContentType.JSON)
                .and() //Syntactic sugar --> to increase readability of code, not needed
                .pathParam("id", 500)
                .when()
                .get("/api/spartans/{id}");
        response.prettyPrint();

//Then response status code should be 404
        assertEquals(404, response.statusCode());
//same as above but a different way to put it
        assertEquals(HttpStatus.SC_NOT_FOUND, response.statusCode());

//And response content-type: application/json
        assertEquals("application/json", response.getContentType());

//And "Not Found" message should be in response payload
        assertTrue(response.body().asString().contains("Not Found"));
    }

    /*
    Given Content type is Json
    And query parameter values are;
        gender|Female
        nameContains|e
    When user sends GET request to /api/spartans/search
    Then response status code should be 200
    And response content-type: application/json
    And "Female" should be in response payload
    And "Janette" should be in response payload
     */
    @DisplayName("GET Request to /api/spartans/search with Query Params")
    @Test
    public void Task3() {
        Response response = given().
                accept(ContentType.JSON)
                .and()
                .queryParam("gender", "Female")
                .and()
                .queryParam("nameContains", "e")
                .when()
                .get("/api/spartans/search");
        response.prettyPrint();
//    Then response status code should be 200
        assertEquals(200, response.statusCode());
//    And response content-type: application/json
        assertEquals("application/json", response.contentType());
//    And "Female" should be in response payload
        assertTrue(response.body().asString().contains("Female"));
//    And "Janette" should be in response payload
        assertTrue(response.body().asString().contains("Janette"));

        //assertTrue(response.body().asString().contains("Janette"));

        /*
        We are just doing exercise to verify something in Response. THI is not the proper way
        all Spartans gender are Female, or name field is Janette, We will learn different method to get specific data.
         */
    }
}
