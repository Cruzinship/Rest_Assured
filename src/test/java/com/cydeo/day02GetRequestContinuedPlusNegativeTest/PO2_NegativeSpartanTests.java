package com.cydeo.day02GetRequestContinuedPlusNegativeTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class PO2_NegativeSpartanTests {

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://54.89.119.143:8000";
    }
@DisplayName("GET - ALL SPARTANS")
    @Test
    public void getAllSpartans(){
      Response response  = given()
                .accept(ContentType.JSON) // hey api please send me json response
                .when()
                .get( "/api/spartans");

        assertEquals(200,response.statusCode());

        response.prettyPrint();

    }
@DisplayName("GET- ALL Spartans -Accept, application/xml - 406")
    @Test
    public void xmlTest(){
        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartan/10");

//verify status code is 406

        assertEquals(404, response.statusCode());

//response Content Type must be application/xml;charset=UFT-8;

        assertEquals("application/xml;charset=UTF-8", response.contentType());

    }
}

