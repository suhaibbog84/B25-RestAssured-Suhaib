package com.cydeo.day12;

import com.cydeo.utilities.BookitTestBase;
import com.cydeo.utilities.ConfigurationReader;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class BookitSpecTest extends BookitTestBase {

    @Test
    public void test1(){
        //send a get request to /api/users/me endpoint as a teacher
        //verify status code and content type
        given()
                .spec(teacherReqSpec)
                .when()
                .get("/api/users/me")
                .then()
                .spec(responseSpec);


    }

    @Test
    public void test2(){
        //send a get request to /api/users/me as a student-member
        //verify status code and content type
        given()
                .spec(userReqSpec("student-member"))
                .when().get("/api/users/me")
                .then()
                .spec(dynamicResponseSpec(200));



    }
