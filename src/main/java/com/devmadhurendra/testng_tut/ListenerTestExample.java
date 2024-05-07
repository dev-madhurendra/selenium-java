package com.devmadhurendra.testng_tut;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListenerTest.class)
public class ListenerTestExample {

    @Test
    void test1() {
        System.out.println(">> This is test 1");
        Assert.assertEquals("A", "A");
    }

    @Test
    void test2() {
        System.out.println(">> This is test 2");
        Assert.assertEquals("A", "B");
    }
    @Test
    void test3() {
        System.out.println(">> This is test 3");
        throw new SkipException("Test skipping .... ");
    }
    @Test
    void test4() {
        System.out.println(">> This is test 4");
    }
    @Test
    void test5() {
        System.out.println(">> This is test 5");
    }

}
