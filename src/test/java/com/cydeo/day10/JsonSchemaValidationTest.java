package com.cydeo.day10;

import com.cydeo.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JsonSchemaValidationTest extends SpartanAuthTestBase {


    @DisplayName("GET request to verify one spartan against to schema")
    @Test
    public void test1(){

            given()
                    .accept(ContentType.JSON)
                    .and()
                    .pathParam("id",10)
                    .and()
                    .auth().basic("admin","admin")
            .when()
                    .get("/api/spartans/{id}")
            .then()
                    .statusCode(200)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SingleSpartanSchema.json"))
                    .log().all();

    }

    @Test
    public void test2(){
        given()
                .accept(ContentType.JSON)
                .and()
                .auth().basic("admin","admin")
                .when()
                .get("/api/spartans/")
                .then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/com/cydeo/day10/allSpartansSchema.json")));



    }




}
