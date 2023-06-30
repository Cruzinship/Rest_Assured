package com.cydeo.day07HTTPRequest;

import com.cydeo.pojo.Student;
import com.cydeo.pojo.Students;
import com.cydeo.day06DeserializationContinued.utilities.CydeoTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P01_CydeoTrainingDeserializationPOJO extends CydeoTestBase {

    @DisplayName("GET /student/2")
    @Test
    public void test1() {
        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .contentType("application/json")
                .pathParam("id", 2)
                .then()
                .statusCode(200)
                .when()
                .get("/student/{id}");

        JsonPath jsonPath = response.jsonPath();
        //Deserialize to Student class

        Student student = jsonPath.getObject("students[0]", Student.class);
                /*
          And verify following
              firstName Mark
              batch 13
              major math
              emailAddress mark@email.com
              companyName Cydeo
              street 777 5th Ave
              zipCode 33222.( Except with POJO )
         */


        System.out.println("student.getFirstName() = " + student.getFirstName());
        System.out.println("student.getContact().getEmailAddress() = " + student.getContact().getEmailAddress());

        //              firstName | Mark
        assertEquals("Mark", student.getFirstName());
        //              batch | 13
        assertEquals(13, student.getBatch());
        //              major | math
        assertEquals("math", student.getMajor());
        //              emailAddress | mark@email.com
        assertEquals("mark@email.com", student.getContact().getEmailAddress());
        //              companyName | Cydeo
        assertEquals("Cydeo", student.getCompany().getCompanyName());
        //              street | 777 5th Ave
        assertEquals("777 5th Ave", student.getCompany().getAddress().getStreet());
        //              zipCode | 33222
        assertEquals(33222, student.getCompany().getAddress().getZipCode());

    }

    @DisplayName("GET /student/2")
    @Test
    public void test2() {
        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .contentType("application/json")
                .pathParam("id", 2)
                .then()
                .statusCode(200)
                .when()
                .get("/student/{id}");

        JsonPath jsonPath = response.jsonPath();
        //Deserialize to Student class

        Students students = jsonPath.getObject("", Students.class);
        //we deserialize everything to Students class which is holding list of Student
        System.out.println("students = " + students);
        Student student = students.getStudents().get(0);

        //if there is no path, we can use response.as method for deserilaztion
        //Students studentsWithAs = response.as(Students.class);

                /*
          And verify following
              firstName Mark
              batch 13
              major math
              emailAddress mark@email.com
              companyName Cydeo
              street 777 5th Ave
              zipCode 33222.( Except with POJO )
         */


        System.out.println("student.getFirstName() = " + student.getFirstName());
        System.out.println("student.getContact().getEmailAddress() = " + student.getContact().getEmailAddress());

        //              firstName | Mark
        assertEquals("Mark", student.getFirstName());
        //              batch | 13
        assertEquals(13, student.getBatch());
        //              major | math
        assertEquals("math", student.getMajor());
        //              emailAddress | mark@email.com
        assertEquals("mark@email.com", student.getContact().getEmailAddress());
        //              companyName | Cydeo
        assertEquals("Cydeo", student.getCompany().getCompanyName());
        //              street | 777 5th Ave
        assertEquals("777 5th Ave", student.getCompany().getAddress().getStreet());
        //              zipCode | 33222
        assertEquals(33222, student.getCompany().getAddress().getZipCode());


    }

    @DisplayName("GET /student/2")
    @Test
    public void test3() {
        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .pathParam("id", 2)
                .when().get("/student/{id}");
        //verify status code
        assertEquals(200, response.statusCode());
        JsonPath jsonPath = response.jsonPath();

        com.cydeo.pojo.ready.Student student = jsonPath.getObject("students[0]", com.cydeo.pojo.ready.Student.class);

        System.out.println("student.getJoinDate() = " + student.getJoinDate());
        System.out.println("student.company.startDate = " + student.getCompany().getStartDate());
        System.out.println("student.getCompany().getAddress().getState() = " + student.getCompany().getAddress().getState());


    }
}



