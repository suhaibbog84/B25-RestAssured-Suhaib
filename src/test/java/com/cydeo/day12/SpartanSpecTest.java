package com.cydeo.day12;

import com.cydeo.utilities.SpartanNewBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class SpartanSpecTest extends SpartanNewBase {

    //all tests in this class will use admin credentials
    //all test in this class will expect json result from response

    //all test in this class response status code is 200
    //all test in this class response conten type header is json


    @Test
    public void test1(){
        given()
                .accept(ContentType.JSON)
                .and()
                .auth().basic("admin","admin")
                .log().all()
                .when()
                .get("/spartans")
                .then()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);


    }

    @Test
    public void test2(){
        given()
                .accept(ContentType.JSON)
                .and()
                .auth().basic("admin","admin")
                .pathParam("id",8)
                .log().all()
                .when()
                .get("/spartans/{id}")
                .then()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);


    }


}
