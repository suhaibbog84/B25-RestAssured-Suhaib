package com.cydeo.day2;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HRApiTestsWithParams extends HrTestBase {

    @Test
    public void test1(){

        Response response = get("/regions");

    }

    @DisplayName("GET request to / countries with query param")
    @Test
    public void test2(){

        /*
        Given accept type is Json
        And parameters: q = {"region_id":2}
        When users sends a GET request to "/countries"
        Then status code is 200
        And Content type is application/json
        And Payload should contain "United States of America"
     */

        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .queryParam("q","{\"region_id\":2}")
                .log().all() //optional
                .when()
                .get("/countries");

        //verify status code
        assertEquals(200,response.statusCode());
        //verify content type
        assertEquals("application/json",response.contentType());
        //verify "Blythe" inside the payload
        assertTrue(response.body().asString().contains("United States of America"));
    }

}
