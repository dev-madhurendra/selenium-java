package com.devmadhurendra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Alert;

public class HandleAlert {
    public static void main(String[] args) throws
            NoAlertPresentException,InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.browserstack.com/users/sign_up");

        driver.findElement(By.id("user_full_name"))
                .sendKeys("username");

        driver.findElement(By.id("user_email_login"))
                .sendKeys("username");

        driver.findElement(By.id("user_password"))
                .sendKeys("user");

        Thread.sleep(5000);

        driver.findElement(By.id("user_submit")).click();

        Thread.sleep(10000);

        Alert alert = driver
                .switchTo()
                .alert(); // switch to alert

        String alertMessage = driver
                .switchTo()
                .alert()
                .getText(); // capture alert message

        System.out.println(alertMessage); // Print Alert Message
        Thread.sleep(5000);
        alert.accept();
    }
}