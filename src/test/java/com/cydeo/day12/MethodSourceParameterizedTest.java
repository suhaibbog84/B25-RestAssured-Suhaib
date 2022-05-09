package com.cydeo.day12;

import com.cydeo.utilities.ExcelUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class MethodSourceParameterizedTest {

    @ParameterizedTest
    @MethodSource("getNames")
    public void testPrintNames(String name){

        System.out.println("name = " + name);

    }

    @ParameterizedTest
    @MethodSource("getExcelData")
    public void excelParamTest(Map<String,String> userInfo){
        System.out.println("userInfo.get(\"firstname\") = " + userInfo.get("firstname"));
        System.out.println("userInfo.get(\"lastname\") = " + userInfo.get("lastname"));

    }

    public static List<Map<String,String>> getExcelData(){

        ExcelUtil vyTrackFile = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        List<Map<String, String>> dataList = vyTrackFile.getDataList();

        return dataList;
    }


    public static List<String> getNames(){
        //you can get value from anywhere almost anytype and return to your test
        //DB
        //Other APIs
        //Excel file

        List<String> nameList = Arrays.asList("Muhtar","Asya","Gurhan","Adam","Akbar","Aysun","Zulfikar");
        return nameList;
    }


}
