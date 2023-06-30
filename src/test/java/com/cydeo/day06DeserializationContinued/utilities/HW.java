package com.cydeo.day06DeserializationContinued.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class HW {

    @BeforeAll
    public static void init(){
      RestAssured.baseURI = "http://ergast.com/api/f1";
    }

}
