package com.cydeo.day12;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class MockApiTest {

    //https://208fd6bd-7c27-4d1d-9786-298c14c4a088.mock.pstmn.io

    //https://982f0464-c81a-4171-8fc5-0fca112bd77a.mock.pstmn.io

    @Test
    public void test1(){

        given()
                .baseUri("https://982f0464-c81a-4171-8fc5-0fca112bd77a.mock.pstmn.io")
                .and()
                .accept(ContentType.JSON)
                .when()
                .get("/customer")
                .then()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .body("firstName",is("John"));

    }

    @Test
    public void test2(){
        given()
                .baseUri("https://982f0464-c81a-4171-8fc5-0fca112bd77a.mock.pstmn.io")
                .accept(ContentType.JSON)
                .when()
                .get("/employees")
                .then()
                .statusCode(401)
                .and()
                .body("batch",endsWith("25"));


    }


}
