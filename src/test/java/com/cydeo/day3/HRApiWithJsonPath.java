package com.cydeo.day3;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HRApiWithJsonPath extends HrTestBase {

    @DisplayName("GET one HR with JsonPath")
    @Test
    public void test1() {
        Response response = get("countries");

        //items[3].country_name

        //we want to use JsonPath to get that value
        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getString("items[3].country_name"));

        //get all country names
        //items.country_name

        List<String> list = jsonPath.getList("items.country_name");

        //Print countries one by one
        for (String s : list) {
            System.out.println(s);
        }

        //get me all country names where their region id is 2

    }
}