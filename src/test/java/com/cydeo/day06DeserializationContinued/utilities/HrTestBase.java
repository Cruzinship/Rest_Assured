package com.cydeo.day06DeserializationContinued.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class HrTestBase {
    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "http://54.89.119.143:1000/ords/hr";
        //My IP Address:1000/ords/hr
    }
}
