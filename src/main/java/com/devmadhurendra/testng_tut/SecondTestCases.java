package com.devmadhurendra.testng_tut;

import org.testng.annotations.Test;

public class SecondTestCases {

    @Test
    void setup() {
        System.out.println(">> Setup");
    }

    @Test
    void searchCustomer() {
        System.out.println(">> Search customer");
    }

    @Test
    void addCustomer() {
        System.out.println(">> Add customer");
    }

    @Test
    void exit() {
        System.out.println(">> Exit");
    }
}
