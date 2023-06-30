package com.cydeo.day03ParametersAndResponsePath;

import com.cydeo.day06DeserializationContinued.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class PO2_HrWithParameters extends HrTestBase {
/*
Given Content type is Json
And parameters: q = "{region_id:2}"
When users sends a GET request to "/countries"
Then status code is 200
And Content type is application/json
And PayLoad should contain "United States of American"
 */
@DisplayName("GET request /counties with Region_id")
@Test
        public void test1(){
    Response response = given()
            .accept(ContentType.JSON)
            .queryParam("q", "{\"region_id\":2}")
            .when().get("/countries");

    response.prettyPrint();
//Then status code is 200
    assertEquals(200, response.statusCode());
//And Content type is application/json
    assertEquals("application/json", response.contentType());
//And PayLoad should contain "United States of America"
    assertTrue(response.body().asString().contains("United States of America"));
}


}
