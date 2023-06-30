package com.cydeo.HomeWork;

import com.cydeo.day06DeserializationContinued.utilities.HW;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HomeWork4_2 extends HW {
    /*
- Given accept type is json
- When user send request /constructorStandings/1/constructors.json
- Then verify status code is 200
- And content type is application/json; charset=utf-8
- And total is 17
- And limit is 30
- And each constructor has constructorId
- And constructor has name
- And size of constructor is 17
- And constructor IDs has “benetton”, “mercedes”,”team_lotus”
     */

    @DisplayName("Solution with Json")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
        .when().get("/constructorStandings/1/constructors.json")
        .then()
        .statusCode(200)
        .contentType("application/json; charset=utf-8")
        .extract().response();

        JsonPath jsonPath = response.jsonPath();

        int total = jsonPath.getInt("MRData.total");
        System.out.println("total = " + total);

        int limit = jsonPath.getInt("MRData.limit");
        System.out.println("limit = " + limit);

        List<String> constructorIds = jsonPath.getList("MRData.ConstructorTable.Constructors.constructorId");
        for (String constructors: constructorIds) {
            System.out.println("constructors = " + constructors);
        }

        List<String> constructorSize = jsonPath.getList("MRData.ConstructorTable.Constructors");
        Assertions.assertEquals(17, constructorSize.size());

        System.out.println("constructorIds.contains(\"benetton\") = " + constructorIds.contains("benetton"));
        System.out.println("constructorIds.contains(\"mercedes\") = " + constructorIds.contains("mercedes"));
        System.out.println("constructorIds.contains(\"team_lotus\") = " + constructorIds.contains("team_lotus"));

    }
    @DisplayName("Solution with HAMCREST MATCHERS")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/constructorStandings/1/constructors.json")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("MRData.total", is("17"))
                .body("MRData.limit", is("30"))
                .body("MRData.ConstructorTable.Constructors",hasSize(17))
                .extract().response();


    }
    @DisplayName("Solution with JavaStructure/Maps")
    @Test
    public void test3(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/constructorStandings/1/constructors.json")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

       // Map<String , Object> total = jsonPath.getMap("MRData", Map.class);
        //System.out.println("total = " + total);
    }

    @DisplayName("Solution with POJO Class")
    @Test
    public void test4(){

    }

}
