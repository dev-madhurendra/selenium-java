package com.devmadhurendra.testng_tut;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyExample {

    @Test
    void startCar() {
        System.out.println(">> Car started");
        Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar"})
    void driveCar() {
        System.out.println(">> Car driving");
    }

    @Test(dependsOnMethods = {"driveCar"})
    void stopCar() {
        System.out.println("Stopping car");
    }

    @Test(dependsOnMethods = {"driveCar", "stopCar"})
    void parkCar() {
        System.out.println(">> Parking car");
    }

}
