package com.cydeo.day06DeserializationContinued;

import com.cydeo.pojo.Employee;
import com.cydeo.pojo.Region;
import com.cydeo.day06DeserializationContinued.utilities.HrTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.given;

public class P03_HrDeserializationPOJO extends HrTestBase {
@DisplayName("GET regions to deserialize to POJO - LOMBOK - JSON PROPERTY")
    @Test
    public void test1(){
JsonPath jsonPath = get("/regions")
        .then().statusCode(200)
        .extract().jsonPath();

//get first region from items array and convert it to Region class
    Region region1 = jsonPath.getObject("items[0]", Region.class);
    System.out.println("region1 = " + region1);

    System.out.println("region1.getRegion_id() = " + region1.getRegionId());
    System.out.println("region1.getRegion_name() = " + region1.getRegionName());
    System.out.println("region1.getLinks().get(0) = " + region1.getLinks().get(0));

}
@DisplayName("GET employee to deserialization to POJO with only required fields")
    @Test
    public void test2(){
    JsonPath jsonPath = get("/employees")
            .then().statusCode(200)
            .extract().jsonPath();

    Employee employee1 = jsonPath.getObject("items[0]", Employee.class);
    System.out.println("employee1 = " + employee1);
}
}
