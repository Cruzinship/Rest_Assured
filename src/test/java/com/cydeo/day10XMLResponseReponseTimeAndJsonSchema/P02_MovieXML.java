package com.cydeo.day10XMLResponseReponseTimeAndJsonSchema;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class P02_MovieXML {
    @Test
    public void test1(){
        Response response = given()
                .queryParam("apikey", "81815fe6")
                .queryParam("r", "xml")
                .queryParam("t", "Inception")
                .when().get("http://www.omdbapi.com").prettyPeek();

        XmlPath xmlPath = response.xmlPath();

        //get me year attribute
        System.out.println("xmlPath.get(\"root.movie.@year\") = " + xmlPath.get("root.movie.@year"));

        //get me movie title
        System.out.println("xmlPath.get(\"root.movie.@title\") = " + xmlPath.get("root.movie.@title"));

        //get me director
        System.out.println("xmlPath.get(\"root.movie.@director\") = " + xmlPath.get("root.movie.director"));

        //get me imdb rating
        System.out.println("xmlPath.get(\"root.movie.@imdbRating\") = " + xmlPath.get("root.movie.@imdbRating"));

    }

    /**
     * http://www.omdbapi.com?apikey=81815fe6&r=xml&s=Harry Potter
     * --Try to get all years and verify they are greater then 2000
     * --Print each title and make sure each of them contains Harry Potter
     * --verify total result is 127
     */

    @DisplayName("Little Homework Task")
    @Test
    public void test2(){
        Response response = given()
                .queryParam("apikey", "81815fe6")
                .queryParam("r", "xml")
                .queryParam("s", "Harry Potter")
                .when().get("http://www.omdbapi.com").prettyPeek();

        XmlPath xmlPath = response.xmlPath();

        List<Integer> allYears = xmlPath.getList("root.result.@year");
        System.out.println("allYears = " + allYears);

        List<String> allTitle = xmlPath.getList("root.result.@title");


    }
}
