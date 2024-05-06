package com.devmadhurendra.testng_tut;

import org.testng.annotations.*;

public class TC2 {

    @BeforeClass
    public void runBeforeClass() {
        System.out.println(">> Run before class : TC2");
    }

    @AfterClass
    public void runAfterClass() {
        System.out.println(">> Run after class : TC2");
    }

    @BeforeTest
    public void runBeforeTest() {
        System.out.println(">> Run before tests : TC2");
    }

    @AfterTest
    public void runAfterTest() {
        System.out.println(">> Run after tests: TC2");
    }

    @Test
    void test3() {
        System.out.println(">> This is tes3");
    }

    @Test
    void test4() {
        System.out.println(">> This is test4");
    }


}
