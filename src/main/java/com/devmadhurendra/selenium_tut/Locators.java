package com.devmadhurendra.selenium_tut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Locators {

    private static WebDriver driver;

    public static void main(String[] args) {

        // Initialize WebDriver instance
        driver = new ChromeDriver();

        // Set implicit wait to 2 seconds
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Navigate to the web page
        driver.get("https://dev-madhurendra.vercel.app");

        // Get the title and current URL
        String pageTitle = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        // Print the title and current URL to the console
        System.out.println("Title of the web page is: " + pageTitle);
        System.out.println("Current Url: " + currentUrl);

        // Go to the about section
        clickElementByClassName("fa-info");

        // Get image of about section
        WebElement image = findElementByXPath("//img[@alt='about-image']");
        System.out.println(image.getAttribute("src"));

        // Click on the social github link
        clickElementByCssSelector("a[href='https://github.com/dev-madhurendra']");

        // Go to Contact Section
        clickElementByClassName("fa-envelope");

        // Fill in the contact form fields
        fillInputFieldByCssSelector("input[name='name']", "John Doe");
        fillInputFieldByCssSelector("input[name='phone']", "1234567890");
        fillInputFieldByCssSelector("input[name='email']", "example@example.com");
        fillInputFieldByCssSelector("input[name='subject']", "Test Subject");
        fillInputFieldByCssSelector("textarea[name='message']", "This is a test message.");

        // Click on the Send button
        clickElementByCssSelector("button[type='submit']");

        // Quit the WebDriver instance
        driver.quit();
    }

    // Function to click on an element by class name
    private static void clickElementByClassName(String className) {
        WebElement element = driver.findElement(By.className(className));
        element.click();
    }

    // Function to click on an element by CSS selector
    private static void clickElementByCssSelector(String cssSelector) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.click();
    }

    // Function to find an element by XPath
    private static WebElement findElementByXPath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    // Function to fill input field by CSS selector
    private static void fillInputFieldByCssSelector(String cssSelector, String value) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.sendKeys(value);
    }
}
