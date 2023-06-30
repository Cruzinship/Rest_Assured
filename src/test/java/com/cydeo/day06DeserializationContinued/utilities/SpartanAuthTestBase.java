package com.cydeo.day06DeserializationContinued.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.*;

public abstract class SpartanAuthTestBase {
    @BeforeAll
    public static void init(){
        baseURI = "http://54.89.119.143";
        port = 7000;
        basePath = "api/";
    }

}
