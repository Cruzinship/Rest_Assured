package com.cydeo.day06DeserializationContinued.utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

public abstract class CydeoTestBase {
    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "https://api.training.cydeo.com";
    }
}
