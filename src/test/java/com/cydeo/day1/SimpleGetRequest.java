package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class SimpleGetRequest {

    String url = "http://54.235.2.232:8000/api/spartans";

    @Test
    public void test1(){

        //send a get request and save response inside the Response object
        Response response = RestAssured.get(url);

        //Print response status code
        System.out.println("response.statusCode() = " + response.statusCode());

        //Print response body
        response.prettyPrint();

        Assertions.assertEquals(200, response.statusCode());
    }



}
