package com.devmadhurendra.testng_tut;

import org.testng.annotations.Test;

public class GroupingTest {

    @Test(groups = {"Group1"})
    void test8() {
        System.out.println(">> test 8");
    }

    @Test(groups = {"Group2"})
    void test9() {
        System.out.println(">> test 9");
    }

    @Test(groups = {"Group1"})
    void test10() {
        System.out.println(">> test 10");
    }

    @Test(groups = {"Group2"})
    void test11() {
        System.out.println(">> test 11");
    }

    @Test(groups = {"Group1"})
    void test12() {
        System.out.println(">> test 12");
    }

    @Test(groups = {"Group2"})
    void test13() {
        System.out.println(">> test 13");
    }

}
