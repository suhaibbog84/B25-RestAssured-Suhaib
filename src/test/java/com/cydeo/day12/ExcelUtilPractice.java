package com.cydeo.day12;

import com.cydeo.utilities.ExcelUtil;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class ExcelUtilPractice {

    @Test
    public void test1(){

        ExcelUtil vyTrackFile = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        List<Map<String, String>> dataList = vyTrackFile.getDataList();



    }
}
