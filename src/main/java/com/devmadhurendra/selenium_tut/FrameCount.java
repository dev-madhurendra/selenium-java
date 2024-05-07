package com.devmadhurendra.selenium_tut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FrameCount {
    public static void main(String[] args) {

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        // Open the webpage
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

        // Find all iframe elements on the page
        List<WebElement> frames = driver.findElements(By.tagName("iframe"));

        // Print the count of frames
        System.out.println("Number of frames: " + frames.size());

        // Close the browser
        driver.quit();
    }
}
