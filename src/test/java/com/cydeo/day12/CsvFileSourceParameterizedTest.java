package com.cydeo.day12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class CsvFileSourceParameterizedTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/postalcode.csv",numLinesToSkip = 1)
    public void zipCodeTestWithFile(String state, String city, int zipCount){

        System.out.println("state = " + state);
        System.out.println("city = " + city);
        System.out.println("zipCount = " + zipCount);


    }
}
