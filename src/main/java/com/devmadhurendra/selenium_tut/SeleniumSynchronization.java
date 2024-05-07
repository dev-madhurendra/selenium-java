package com.devmadhurendra.selenium_tut;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.devmadhurendra.utils.SeleniumUtils.getCurrentTime;

public class SeleniumSynchronization {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.cssSelector("textarea[title='Search']"));
        searchBox.sendKeys("madhurendra tech odyssey");

        Actions actions = new Actions(driver);

        actions.moveToElement(searchBox)
                .keyDown(Keys.ENTER)
                .perform();

        getCurrentTime();

        // Implicit
        driver.manage()
                .timeouts()
                .implicitlyWait(60, TimeUnit.SECONDS);

        getCurrentTime();

        driver.findElement(By.cssSelector("a[href='https://dev-madhurendra.vercel.app/']")).click();
        String name = driver.findElement(By.cssSelector("div[class='name']")).getText();
        System.out.println(">> Name " + name);

        // Explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("a[href='https://github.com/dev-madhurendra']")));
        element.click();

        driver.findElement(By.xpath("//a[normalize-space()='Resume']")).click();

        // Thread
        getCurrentTime();
        Thread.sleep(5000);
        getCurrentTime();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(">> Current Url " + currentUrl);

        // Switch to next tab
        Set<String> windowHandles = driver.getWindowHandles();
        driver.switchTo().window((String) windowHandles.toArray()[1]);

        // Fluent Wait
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // Maximum wait time
                .pollingEvery(Duration.ofMillis(500)) // Polling interval
                .ignoring(NoSuchElementException.class); // Ignore specific exceptions

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/dev-madhurendra?tab=repositories']"))).click();
        driver.findElement(By.cssSelector("input[type='Search']")).sendKeys("100");
        Thread.sleep(5000);
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='user-repositories-list']/ul/li/div/div/h3/a"))).click();

        String deployedUrlOfRepo = driver.findElement(By.xpath("//*[@id='repo-content-pjax-container']/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/span")).getText();
        System.out.println(">> This is the deployed url of this repo : " + deployedUrlOfRepo);

    }
}
