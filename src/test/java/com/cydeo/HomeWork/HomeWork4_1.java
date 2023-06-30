package com.cydeo.HomeWork;

import com.cydeo.pojo.HomeWork1.MRData;
import com.cydeo.day06DeserializationContinued.utilities.HW;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HomeWork4_1 extends HW {
    /*
    - Given accept type is json
    - And path param driverId is alonso
    - When user send request /drivers/{driverId}.json
    - Then verify status code is 200
    - And content type is application/json; charset=utf-8
    - And total is 1
    - And givenName is Fernando
    - And familyName is Alonso
    - And nationality is Spanish
     */
    @DisplayName("Solution with Json")
    @Test
    public void test1() {
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("driverId", "alonso")
                .when()
                .get("/drivers/{driverId}.json")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        int total = jsonPath.getInt("MRData.total");
        System.out.println("total = " + total);

        String givenName = jsonPath.getString("MRData.DriverTable.Drivers.givenName");
        System.out.println("givenName = " + givenName);

        String familyName = jsonPath.getString("MRData.DriverTable.Drivers.familyName");
        System.out.println("familyName = " + familyName);

        String nationality = jsonPath.getString("MRData.DriverTable.Drivers.nationality");
        System.out.println("nationality = " + nationality);
    }

    @DisplayName("Solution With HamCrest Matchers")
    @Test
    public void test2() {
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("driverId", "alonso")
                .when()
                .get("/drivers/{driverId}.json")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("MRData.total", is("1"))
                .body("MRData.DriverTable.Drivers.familyName", is(contains("Alonso")))
                .body("MRData.Driver.givenName", is(contains("Fernando")))
                .body("MRData.DriverTable.Drivers.nationality", is(contains("Spanish")))
                .extract().response();
    }

    @DisplayName("Solution with Maps")
    @Test
    public void test3() {
        Response response = given()
                .accept(ContentType.JSON)
                .pathParam("driverId", "alonso")
                .when()
                .get("/drivers/{driverId}.json")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Map<String, Object> allDriversData = jsonPath.getMap("MRData");
        System.out.println("allDriversData = " + allDriversData);
        System.out.println("allDriversData.get(\"total\") = " + allDriversData.get("total"));
    }

    @DisplayName("Solution with POJO")
    @Test
    public void test4() {
        JsonPath jsonPath = given()
                .accept(ContentType.JSON)
                .pathParam("driverId", "alonso")
                .when()
                .get("/drivers/{driverId}.json")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract().jsonPath();

       MRData mrDataTotal = jsonPath.getObject("MRData" , MRData.class);
        System.out.println("mrDataTotal.total = " + mrDataTotal.total);

        System.out.println("mrDataTotal.driverTable.drivers.get().familyName = " + mrDataTotal.driverTable.drivers.get(0).familyName);
        System.out.println("mrDataTotal.driverTable.drivers.get(0).givenName = " + mrDataTotal.driverTable.drivers.get(0).givenName);
        System.out.println("mrDataTotal.driverTable.drivers.get(0).nationality = " + mrDataTotal.driverTable.drivers.get(0).nationality);

    }
}
