package com.cydeo.day10XMLResponseReponseTimeAndJsonSchema;

import com.cydeo.day06DeserializationContinued.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class P04_jsonSchemaValidation extends SpartanTestBase {

    @Test
    public void test1(){
        given().accept(ContentType.JSON)
                .pathParam("id",20)
                .when().get("/api/spartans/{id}").prettyPeek()
                .then().statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));
    }
    @DisplayName("GET /api/spartans/search to validate with JsonSchemaValidator")
    @Test
    public void test2() {
    given().accept(ContentType.JSON)
            .when().get("/api/spartans/search").prettyPeek()
            .then().statusCode(200)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SearchSpartansSchema.json"));
    }

    @DisplayName("GET /api/spartans/search to validate with JsonSchemaValidator with filePath")
    @Test
    public void test3(){
        given().accept(ContentType.JSON)
                .when().get("/api/spartans/search")
                .then().statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/SearchSpartansSchema.json")));
    }

    @DisplayName("Do schema validation for ALLSPARTANS")
    @Test
    public void test4(){
        given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("AllSpartansSchema.json"));

    }

    @DisplayName("Do schema validation for POST SINGLE SPARTAN")
    @Test
    public void test5(){
        given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SpartanPostSchema.json"));
    }

    /**
     *     Do schema validation for ALLSPARTANS and POST SINGLE SPARTAN
     *
     *     ALL SPARTANS
     *      1- Get all spartans by using /api/spartans
     *      2- Validate schema by using  JsonSchemaValidator
     *
     *
     *    POST SINGLE SPARTANS
     *       1- Post single spartan
     *       2- Validate schema by using  JsonSchemaValidator
     *
     */

}
