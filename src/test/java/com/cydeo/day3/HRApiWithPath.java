package com.cydeo.day3;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HRApiWithPath extends HrTestBase {

    @DisplayName("GET request to countries with Path method")
    @Test
    public void test1(){
        Response response = given()
                .accept(ContentType.JSON)
                .queryParam("q", "{\"region_id\":2}")
                .when()
                .get("/countries");

        //response.prettyPrint();

        System.out.println(response.path("limit").toString());

        System.out.println(response.path("hasMore").toString());

        System.out.println(response.path("items[1].country_id").toString());

        System.out.println(response.path("items[3].country_name").toString());

        //get me all country names
        List<String> countryNames= response.path("items.country_name");
        System.out.println(countryNames);

        //assert that in the response all region_ids are 2
        //save all the regions ids inside the list
        List<Integer>  allRegionsIDs = response.path("items.region_id");

        //assert one by one that they are equal to 2
        for (Integer regionsID : allRegionsIDs) {
            assertEquals(2,regionsID);
        }
    }

    @DisplayName("")
    @Test
    public void test2() {

         /*
        send a GET request o employees endpoint, filter only Job_id IT_PROG
        then assert that all job_ids are IT_PROG
     */

        Response response = given()
                .accept(ContentType.JSON)
                .queryParam("q", "{\"job_id\":\"IT_PROG\"}")
                .when()
                .get("/employees");

        //All job_id are IT_PROG
        List<String> jobIDName = response.path("items.job_id");
        System.out.println(jobIDName);

        //assert one by one that they are equal to IT_PROG
        for (String jobID : jobIDName) {
            assertEquals("IT_PROG", jobID);

        }
    }

}
