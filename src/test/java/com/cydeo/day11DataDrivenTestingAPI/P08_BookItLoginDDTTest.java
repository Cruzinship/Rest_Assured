package com.cydeo.day11DataDrivenTestingAPI;

import com.cydeo.day06DeserializationContinued.utilities.ExcelUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class P08_BookItLoginDDTTest {


    //create a method to read bookitqa3 excel file information (QA3 Sheet)
    //use those information as an email and password to send a get request to /sign endpoint
    //verify you got 200 for each request
    //print accessToken for each request

    //@ParameterizedTest
    //@CsvFileSource(resources = "/BookItQa3.xlsx", numLinesToSkip = 1)
    @Test
    public void test1(){
        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/BookItQa3.xlsx", "QA3 Sheet");

        System.out.println("excelUtil.getDataList() = " + excelUtil.getDataList());

        for (Map<String, String> row : excelUtil.getDataList()){
            System.out.println("row = " + row);

        }//mid i need excel
    }

}
