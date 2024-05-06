package com.devmadhurendra.testng_tut;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestCases {

    @BeforeTest
    void runBefore() {
        System.out.println(">> Run before all test");
    }

    @AfterTest
    void runAfter() {
        System.out.println(">> Run after all test");
    }

    // @Test(priority = 1)
    @Test
    void setup() {
        System.out.println(">> Setup test");
    }

    @Test(groups = {"auth"})
    void signup() {
        System.out.println(">> Signup Test");
    }

    // @Test(priority = 2)
    @Test(groups = {"auth"})
    void login() {
        System.out.println(">> Login test");
    }

    // @Test(priority = 3)
    @Test
    void exit() {
        System.out.println(">> Bye");
    }
}
