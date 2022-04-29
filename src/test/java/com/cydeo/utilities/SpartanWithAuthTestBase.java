package com.cydeo.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class SpartanWithAuthTestBase {

    //beforeAll is the same thing with beforeClass in testng
    @BeforeAll
    public static void init(){
        RestAssured.baseURI ="http://54.235.2.232:7000";

        String dbUrl ="jdbc:oracle:thin:@54.235.2.232:1521:XE";
        String dbUsername ="SP";
        String dbPassword = "SP";

        //DBUtils.createConnection(dbUrl,dbUsername,dbPassword);
    }

    @AfterAll
    public static void close(){
        // DBUtils.destroy();
    }
}
