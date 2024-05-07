package com.devmadhurendra.testng_tut;

import com.devmadhurendra.selenium_tut.ExtractLeetcodeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AssertionsExample {

    WebDriver webDriver;
    private static java.util.logging.Logger logger =
            Logger.getLogger(ExtractLeetcodeInfo.class.getName());

    @BeforeTest
    void setup() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.get("https://dev-madhurendra.vercel.app");
        Thread.sleep(2000);
    }

    @AfterTest
    void exit() {
        webDriver.quit();
    }

    @Test
    void testLogo_isPresent() {
        WebElement logo = webDriver.findElement(
                By.xpath("(//img[@alt='icon'])[1]")
        );

        Assert.assertTrue(
                logo.isDisplayed(),
                "Logo is not displaying on the page"
        );
    }

    @Test
    void testDeveloperName_isPresent() {
        String name = webDriver.findElement(
                By.xpath("//div[@class='name']")
        ).getText();

        logger.log(Level.INFO, name);

        Assert.assertTrue(
                name.equals("<MADHURENDRA/>"),
                "Name is not correct"
        );
    }
}
