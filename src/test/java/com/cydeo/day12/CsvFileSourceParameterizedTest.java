package com.cydeo.day12;

import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class CsvFileSourceParameterizedTest {

    // Write a parameterized test for this request
    // Get the data from csv source
    // GET https://api.zippopotam.us/us/{state}/{city}

    @ParameterizedTest
    @CsvFileSource(resources = "/postalcode.csv",numLinesToSkip = 1)
    public void zipCodeTestWithFile(String state, String city, int zipCount){

        System.out.println("state = " + state);
        System.out.println("city = " + city);
        System.out.println("zipCount = " + zipCount);

        given()
                .accept(ContentType.JSON)
                .baseUri("https://api.zippopotam.us")
                .and().pathParam("state",state)
                .and().pathParam("city", city)
        .when()
                .get("/us/{state}/{city}")
        .then()
                .statusCode(200)
                .and().body("places",hasSize(zipCount));


    }
}
