package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class SpartanTestBase {

        //beforeAll is the same thing with beforeClass in testng
        @BeforeAll
        public static void init(){
            RestAssured.baseURI ="http://54.235.2.232:8000";
        }
}
