package com.cydeo.day14Log4jAndMockAPI;

import com.cydeo.day06DeserializationContinued.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P02_SpartanMock extends SpartanTestBase{

//Hey you, Mock API is used to create testable data related to your project even if the API isn't ready to test yet

//    @BeforeAll
//    public static void init(){
//        baseURI = "https://302f4ed0-efb4-4007-860c-a14638d736e4.mock.pstmn.io";
//    }

    @DisplayName("GET /api/hello")
    @Test
    public void test1(){
      Response response = given().accept(ContentType.TEXT)
                .log().all().get("/api/hello")
                .then().statusCode(200)
              .extract().response();

      assertEquals("Hello from Sparta",response.asString());

    }
@Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .log().all().get("api/spartans")
                .then().statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        response.prettyPrint();

}

}
