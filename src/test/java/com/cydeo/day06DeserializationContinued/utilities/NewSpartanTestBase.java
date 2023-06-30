package com.cydeo.day06DeserializationContinued.utilities;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.*;
public abstract class NewSpartanTestBase {

    public static RequestSpecification reqSpec;
    public static ResponseSpecification resSpec;
    public static RequestSpecification reqUserSpec;


    @BeforeAll
    public static void init() {
        baseURI = "http://54.89.119.143";
        port = 7000;
        basePath = "/api";

        //baseUri+port+basePath
        //http://54.86.2.212:7000/api

        reqSpec = given().
                log().all()
                .accept(ContentType.JSON)
                .auth().basic("admin", "admin");

        reqUserSpec = given(). //this is just a name used
                log().all()
                .accept(ContentType.JSON)
                .auth().basic("user", "user");

        resSpec =
                expect().statusCode(200)
                        .contentType(ContentType.JSON);

//Create dynamic method which is accepting username and password as a parameter and returning request specification

    }

    public static RequestSpecification dynamicReqSpec(String username, String password) {
        return given().log()
                .all()
                .accept(ContentType.JSON)
                .auth().basic(username, password);
    }
    public static ResponseSpecification dynamicReqSpec(int statusCode) {
        return expect().statusCode(statusCode)
                .contentType(ContentType.JSON);
    }
}