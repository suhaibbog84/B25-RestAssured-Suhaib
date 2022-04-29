package com.cydeo.day7;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class SpartanWithAuthHomeWork extends SpartanWithAuthTest{

    /*
        As a homework,write a detailed test for Role Base Access Control(RBAC)
            in Spartan Auth app (7000)
            Admin should be able to take all CRUD
            Editor should be able to take all CRUD
                other than DELETE
            User should be able to only READ data
                not update,delete,create (POST,PUT,PATCH,DELETE)
       --------------------------------------------------------
        Can guest even read data ? 401 for all

     */

    @DisplayName("GET /api/spartans as admin user expect 200")
    @Test
    public void testAdminGet(){

        given()
                .auth().basic("admin","admin")
                .and().accept(ContentType.JSON)
                .log().all()
                .when()
                .get("/api/spartans")
                .then().statusCode(200).log().all();
    }

    @DisplayName("POST /api/spartans as admin user expect 201")
    @Test
    public void testAdminPost(){

        String requestedBody = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"Malik\",\n" +
                "  \"phone\": 1234567890\n" +
                "}";

        Response response = given()
                .auth().basic("admin","admin")
                .and().accept(ContentType.JSON)
                .body(requestedBody)
                .log().all()
                .when()
                .post("/api/spartans");

        //verify status code
        assertThat(response.contentType(),is("application/json;charset=UTF-8"));
    }

}
