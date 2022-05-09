package com.cydeo.day12;

import com.cydeo.utilities.ExcelUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;

public class BookitTest {

    @ParameterizedTest
    @MethodSource("getBookitData")
    public void excelParamTest(Map<String,String> userInfo){
        System.out.println("userInfo.get(\"email\") = " + userInfo.get("email"));
        System.out.println("userInfo.get(\"password\") = " + userInfo.get("password"));

    }
    public static List<Map<String,String>> getBookitData(){

        ExcelUtil bookitQa3 = new ExcelUtil("src/test/resources/BookItQa3.xlsx","QA3");

        List<Map<String, String>> dataList = bookitQa3.getDataList();

        return dataList;
    }


}
