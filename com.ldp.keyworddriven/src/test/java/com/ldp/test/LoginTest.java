package com.ldp.test;

import com.ldp.keyworddriven.engine.TestEngine;
import org.testng.annotations.Test;


public class LoginTest {

    public TestEngine testEngine;

    @Test
    public void loginTest()  {

        testEngine = new TestEngine();
        testEngine.getExcelData("Sheet1");
    }










}
