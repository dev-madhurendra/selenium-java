package com.devmadhurendra.testng_tut;

import org.testng.annotations.Test;

public class PriorityExample {

    @Test(priority = 2)
    void test5() {
        System.out.println(">> Test 5");
    }

    @Test(priority = 1)
    void test6() {
        System.out.println(">> Test 6");
    }


}
