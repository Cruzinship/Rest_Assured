package com.cydeo.day05HamCrestIntroToDeserialization;

import com.cydeo.day06DeserializationContinued.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class P04_DeserializationToCollections extends SpartanTestBase {

       /*
     Given accept type is application/json
     And Path param id = 10
     When I send GET request to /api/spartans
     Then status code is 200
     And content type is json
     And spartan data matching:
         id > 10
         name>Lorenza
         gender >Female
         phone >3312820936
     */

    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .when()
                .get("/api/spartans/{id}")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract().response();

        Map<String, Object> spartaMap = response.as(Map.class);

        System.out.println("spartaMap = " + spartaMap);

        int id = (int) spartaMap.get("id");
        String name = (String) spartaMap.get("name");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
//-------------------------------------------------------------------------
        JsonPath jsonPath = response.jsonPath();

        Map<String, Object> jsonPathMap = jsonPath.getMap("");
        System.out.println("jsonPathMap = " + jsonPathMap);

        int id1 = (int) jsonPathMap.get("id");
        System.out.println("id1 = " + id1);

    }

    @DisplayName("Get all Spartans with Java Collections")
    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/api/spartans/")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract().response();
        //Response style object

        List<Map<String, Object>> spartanList = response.as(List.class);
        for (Map<String, Object> map : spartanList) {
            //   System.out.println("map = " + map);
        }
        //how to find first spartan
        System.out.println("spartanList.get(9) = " + spartanList.get(9));

        //how to find first spartan name
        System.out.println("spartanList.get(0).get(\"name\") = " + spartanList.get(0).get("name"));

        //how to find first spartan name
        System.out.println("spartanList.get(0).get(\"id\") = " + spartanList.get(0).get("id"));


    }


}
