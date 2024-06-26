package com.devmadhurendra.selenium_tut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HandleFrames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage()
                .window()
                .maximize();

        // Implicit Waits
        driver.manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);

        // Get the url
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

        driver.findElement(By.id("name"))
                .sendKeys("Hello");

        // Handle dropdown

        // Create instance of select to handle select options

        // Shift main focus to this frame
        driver.switchTo().frame(
                driver.findElement(By.id("frm1"))
        );

        // If we will not handle frame before this code then
        // This will not able to find the element because it is in iframe
        // Giving no such element found exception

         Select courseDD = new Select(
               driver.findElement(By.id("course"))
        );

        // Selecting the options according to visible text
        courseDD.selectByVisibleText("Java");

        // Switch back to default content
        driver.switchTo().defaultContent();

        driver.findElement(By.id("name"))
                .sendKeys(" World");


    }
}
