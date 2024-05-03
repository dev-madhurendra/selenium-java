package com.devmadhurendra;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HandleException {
    public static WebDriver driver = null;
    private static Logger logger = Logger.getLogger(HandleException.class.getName());

    public static void handleWebDriverException() {
        try {
            // Initialize WebDriver
            driver = new ChromeDriver();

            // Perform actions that may cause WebDriverException
            driver.get("https://testing-website.com");

        } catch (WebDriverException e) {
            // Handle WebDriverException
            System.out.println("WebDriverException occurred: " + e.getMessage());
            // e.printStackTrace();
        } finally {
            // Quit the driver to clean up resources
            if (driver != null) {
                driver.quit();
            }
        }
    }
    public static void handleNoSuchElementException() {
        driver = new ChromeDriver();

        driver.get("https://www.youtube.com");

        try {
            WebElement element = driver.findElement(By.id("nonExistentElement"));
        }
        catch (NoSuchElementException e) {
            // Handle NoSuchElementException
            System.out.println("Element not found: " + e.getMessage());
            logger.log(Level.SEVERE, "Element not found", e);
        }
    }
    public static void handleTimeoutException() {
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nonExistentElement")));
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for element: " + e.getMessage());
            logger.log(Level.SEVERE, "Timeout waiting for element", e);
        }
    }
    public static void handleStaleElementReferenceException() {
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com");

        try {
            WebElement element = driver.findElement(By.id("staleElement"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException: " + e.getMessage());
            logger.log(Level.SEVERE, "StaleElementReferenceException", e);
        }
    }
    public static void handleXPathLookupException() {
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com");

        try {
            WebElement element = driver.findElement(By.xpath("//nonExistentElement"));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("XPathLookupException: " + e.getMessage());
            logger.log(Level.SEVERE, "XPathLookupException", e);
        }
    }

    public static void main(String[] args) {
        // handleWebDriverException();
        // handleNoSuchElementException();
        // handleTimeoutException();
        // handleStaleElementReferenceException();
        // handleXPathLookupException();
    }
}
