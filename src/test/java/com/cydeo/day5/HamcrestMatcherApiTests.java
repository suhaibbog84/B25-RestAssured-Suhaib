package com.cydeo.day5;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class HamcrestMatcherApiTests {

     /*
       given accept type is Json
       And path param id is 15
       When user sends a get request to spartans/{id}
       Then status code is 200
       And content type is Json
       And json data has following
           "id": 15,
           "name": "Meta",
           "gender": "Female",
           "phone": 1938695106
        */
     @DisplayName("One Spartan with Hamcrest and Chaining")
     @Test
     public void test1() {
         given()
                 .accept(ContentType.JSON)
                 .and()
                 .pathParam("id", 15)
                 .when()
                 .get("http://54.235.2.232:8000/api/spartans/{id}")
                 .then()
                 .statusCode(200)
                 .and()
                 .contentType("application/json")
                 .and()
                 .body("id", is(15),
                         "name", is("Meta"),
                         "gender", equalTo("Female"),
                         "phone", is(1938695106));
     }


}
