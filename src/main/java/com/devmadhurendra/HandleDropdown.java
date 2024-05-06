package com.devmadhurendra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDropdown {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        Thread.sleep(1000);

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

    }

}
