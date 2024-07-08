package com.selenideexample.ui_tests;

import com.selenideexample.commonconfigurations.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    @BeforeClass
    public void setUp() {
        DriverManager.getInstance();
    }

    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
    }
}
