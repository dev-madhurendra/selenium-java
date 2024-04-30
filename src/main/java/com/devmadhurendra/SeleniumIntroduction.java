package com.devmadhurendra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumIntroduction {
    public static void main(String[] args) {
        // Invoking Web Browser
        // Chrome - ChromeDriver -> Methods
        // Create object of ChromeDriver to access all the methods of that driver

        // This chrome driver only work with chrome
        // ChromeDriver driver = new ChromeDriver();

        // Set the path to the ChromeDriver executable
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // This driver work with any browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the web page
        driver.get("https://dev-madhurendra.vercel.app");

        // Close the browser - Closes the current window or tab
        // driver.close();

        // Quit the driver - Close all the window or tab
        driver.quit();

    }
}
