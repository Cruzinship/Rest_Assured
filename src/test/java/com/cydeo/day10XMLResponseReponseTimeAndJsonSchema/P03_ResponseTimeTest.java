package com.cydeo.day10XMLResponseReponseTimeAndJsonSchema;

import com.cydeo.day06DeserializationContinued.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class P03_ResponseTimeTest extends SpartanAuthTestBase {

    @Test
    public void test1() {
        Response response = given()
                .accept(ContentType.JSON)
                .auth().basic("admin", "admin")
                .when().get("/api/spartans")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                //.time(lessThan(500L))//this method is storing actual response time
                //.time(greaterThan(100L));
                .time(both(greaterThan(100L)).and(lessThan(500L))).extract().response();

        System.out.println("response.getTime() = " + response.getTime());

        System.out.println("response.getTimeIn(TimeUnit.NANOSECONDS) = " + response.getTimeIn(TimeUnit.NANOSECONDS));
    }
}