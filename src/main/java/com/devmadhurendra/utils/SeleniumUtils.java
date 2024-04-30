package com.devmadhurendra.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class SeleniumUtils {

    private static WebDriver driver;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickElementByCssSelector(String cssSelector) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.click();
    }

    public static void fillInputFieldByCssSelector(String cssSelector, String value) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.sendKeys(value);
    }

    public static void clickElementByClassName(String classname) {
        WebElement element = driver.findElement(By.className(classname));
        element.click();
    }

    public static void waitForSecond(int second) {
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    public static void clickOnLinkText(String text) {
        WebElement element = driver.findElement(By.linkText(text));
        element.click();
    }

    public static WebElement waitForElementVisibility(By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void clickElementByXPath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void clickById(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.click();
    }
    public static String getSolutionCode(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.getText();

    }
    public static void clearCodeAreaAndWrite(String xpath, String code) {
        WebElement element = driver.findElement(By.xpath(xpath));

        // Select all the text in the code area
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click()
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(code)
                .perform();

    }

    public static void formatCode(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click()
                .keyDown(Keys.ALT)
                .keyDown(Keys.SHIFT)
                .sendKeys("f")
                .perform();
    }

    public static void removeExtraLines(String xpath) {
        System.out.println(">>> started");
        WebElement element = driver.findElement(By.xpath(xpath));
        Actions actions = new Actions(driver);

        // Move to the editor
        actions.moveToElement(element).click();

        // Perform keyboard shortcuts to select and delete extra lines
        actions.keyDown(Keys.CONTROL)
                .sendKeys("f")
                .keyUp(Keys.CONTROL)
                .sendKeys("}:") // Search for `}:`
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.ARROW_DOWN) // Select text from `}:{` to the end
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.DELETE) // Delete selected text
                .perform();
    }


    public static void submitSolution(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click()
                .keyDown(Keys.CONTROL)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.ENTER)
                .keyUp(Keys.CONTROL)
                .keyUp(Keys.SHIFT)
                .perform();
    }

    public static void runSolution(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click()
                .keyDown(Keys.CONTROL)
                .sendKeys("'")
                .keyUp(Keys.CONTROL)
                .perform();
    }
}
