package com.cydeo.day02GetRequestContinuedPlusNegativeTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PO1_SpartanGetRequests {

    String url = "http://54.89.119.143:8000";

    /*
    Given content type is application/json
    * When user sends GEt request/api/spartans endpoint
    * Then status code should be 200
    * And Content type should be application/json
     */

    @Test
    public void getAllSpartans() {
        Response response = RestAssured.given()
                .accept(ContentType.JSON) // hey api please send me json response
                .when()
                .get(url + "/api/spartans");
        //print response body
        response.prettyPrint();
//how to get statusCode
        int actualStatusCode = response.statusCode();

        Assertions.assertEquals(200, actualStatusCode);


        //how to get response content type header ?
        String actualContentType = response.contentType();
        System.out.println(actualContentType);

        //assert the content type
        Assertions.assertEquals("application/json", actualContentType);

        //how to get Connection header value ?
        //if we want to get any response header value, we can use header("headerName")
        //method from response object. it Will return header value as string
        System.out.println(response.header("Content-type"));
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Date"));

        //how to verify header exist?
        //hasHeaderWithNameMethod help us to verify header exist or not
        //it is useful for dynamic header values like Date, we are only verifying header exist or not
        boolean isDate = response.headers().hasHeaderWithName("Date");
        Assertions.assertTrue(isDate);

    }

    @Test
    public void getSpartan() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(url + "/api/spartans/3");

        //verify status code
        Assertions.assertEquals(200, response.statusCode());

        //verify contentType is json
        Assertions.assertEquals("application/json", response.contentType());
        Assertions.assertEquals("application/json", response.getContentType());
        Assertions.assertEquals(ContentType.JSON.toString(), response.header("Content-type"));

        response.prettyPrint();
        //verify body contains "Fidole
        Assertions.assertTrue(response.body().asString().contains("Fidole"));

        /*
        This is not a good way to make an Assertion. In this way we are just converting response to String
        with the help of String contains method. We should be able to get Json "name" key value then
        verify that one is equal to Fidole
         */

                 /*
    Given content type is application/json
    * When user sends Get request/api/spartans endpoint
    * Then status code should be 200
    * And Content type should be application/json
    * And response body needs to contain Fidole
     */

    }
    @Test
    public void HelloFromSparta(){
Response response  = RestAssured.get(url + "/api/hello");

response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());

        String expectedContentType = "text/plain;charset=UTF-8";

        Assertions.assertEquals(expectedContentType, response.getContentType());

        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

        Assertions.assertEquals("17", response.header("Content-Length"));


    }
    /*
    Given no headers provided
    * When user sends Get request to /api/hello
    * Then response status code should be 200
    * And Content type should be "text/plain;charset=UTF-8"
    * And response body needs to contain Fidole
     */
}
