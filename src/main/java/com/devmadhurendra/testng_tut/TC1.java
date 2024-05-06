package com.devmadhurendra.testng_tut;

import org.testng.annotations.*;

public class TC1 {

    @BeforeClass
    public void runBeforeClass() {
        System.out.println(">> Run before class : TC1");
    }

    @AfterClass
    public void runAfterClass() {
        System.out.println(">> Run after class : TC1");
    }

    @BeforeMethod
    public void runBeforeEachTests() {
        System.out.println(">> Before each test");
    }

    @AfterMethod
    public void runAfterEachTests() {
        System.out.println(">> Run after each test");
    }


    @Test
    void test1() {
        System.out.println(">> This is tes1");
    }

    @Test
    void test2() {
        System.out.println(">> This is test2");
    }


}
