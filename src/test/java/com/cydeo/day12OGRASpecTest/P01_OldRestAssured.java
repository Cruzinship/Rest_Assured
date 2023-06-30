package com.cydeo.day12OGRASpecTest;

import com.cydeo.day06DeserializationContinued.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class P01_OldRestAssured extends SpartanAuthTestBase {

    @Test
    public void getAllSpartans(){
        given().accept(ContentType.JSON).
                auth().basic("admin", "admin")
                .when()
                .get("/spartans")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id[0]", is(1))
                .body("id[1]", is(2))
                .log().body();
    }
    @Test
    public void getAllSpartansOldWay(){
        given().accept(ContentType.JSON)
                .auth().basic("admin", "admin")
                .expect()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id[0]", is(1))
                .body("id[1]", is(2))
                .when()
                .get("/spartans");
    }
    /*
    OLD WAY --> EXPECT()
        -It works like soft assertion
        Also the get request is written after everything
    NEW WAY --> then() (this is one that we are using)
        -It works like hard assertion
  */
}
