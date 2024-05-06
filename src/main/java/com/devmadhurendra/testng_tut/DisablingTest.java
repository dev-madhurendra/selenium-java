package com.devmadhurendra.testng_tut;

import org.testng.annotations.Test;

public class DisablingTest {

    @Test
    void test7() {
        System.out.println(">> Test 7");
    }

    @Test(enabled = false)
    void test9() {
        System.out.println(">> Test 9");
    }

}
