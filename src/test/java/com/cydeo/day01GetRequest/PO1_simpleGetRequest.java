package com.cydeo.day01GetRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PO1_simpleGetRequest {
String url = "http://54.89.119.143:8000/api/spartans";
/*
When users send request to /api/spartans endpoint
Then user should be able to see status code is 200
and Print our response body into screen
 */


    @Test
    public void simpleGetRequest(){
//send request to url and get Response interface
        Response response = RestAssured.get(url);
//both same no difference, this get the response status code
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        ///verify that status code is 200
        int statusCode = response.statusCode();
        //assert that is 200
        Assertions.assertEquals(200, statusCode);

        //how to print json response body on console
        response.prettyPrint();
    }
}
