package com.cydeo.utilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookitTestBase {

    public static String generateToken(String role){
        Map<String, String> credentials = new HashMap<>();

        switch (role){

            case "teacher":
                credentials.put("email", ConfigurationReader.getProperty("teacher_email"));
                credentials.put("password",ConfigurationReader.getProperty("teacher_password"));
                break;

            case "team-leader":
                credentials.put("email",ConfigurationReader.getProperty("team_leader_email"));
                credentials.put("password",ConfigurationReader.getProperty("team_leader_password"));
                break;

            case "student-member":
                credentials.put("email",ConfigurationReader.getProperty("team_member_email"));
                credentials.put("password",ConfigurationReader.getProperty("team_member_password"));
                break;

        }

        String accessToken = given().log().uri()
                .queryParams(credentials)
                .when()
                .get("/sign").
                then()
                .statusCode(200)
                .extract().jsonPath().getString("accessToken");

        return "Bearer "+accessToken;
    }

}
