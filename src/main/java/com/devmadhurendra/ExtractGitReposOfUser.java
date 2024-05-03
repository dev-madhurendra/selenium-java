package com.devmadhurendra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.List;

public class ExtractGitReposOfUser {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Take github user name
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you github username : ");
        String username = sc.nextLine();
        String URL = "https://www.github.com/" + username + "/";
        driver.get(URL);

        // Fluent Wait
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // Maximum wait time
                .pollingEvery(Duration.ofMillis(500)) // Polling interval
                .ignoring(NoSuchElementException.class); // Ignore specific exceptions

        WebElement repTab = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/" + username + "?tab=repositories']")));
        int totalRepositories = Integer.parseInt(repTab.getText().substring(13));
        int repositoriesPerPage = 30;

        // Calculate the number of full pages
        int fullPages = totalRepositories / repositoriesPerPage;

        // Calculate the remaining repositories after filling full pages
        int remainingRepositories = totalRepositories % repositoriesPerPage;

        // If there are remaining repositories, add one more page
        int totalPages = (remainingRepositories == 0) ? fullPages : fullPages + 1;
        repTab.click();

        WebDriverWait implicitWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
        List<WebElement> reposListWebElement = implicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='user-repositories-list']/ul/li/div/div/h3/a")));

        // Iterate through each element and extract its text
        for (WebElement element : reposListWebElement) {
            String text = element.getText();
            System.out.println(text);
        }


        for (int i = 1; i < totalPages; i++) {
            // Click on the pagination link
            WebElement paginationLink = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/" + username + "?page=" + (i+1) + "&tab=repositories']")));
            paginationLink.click();

            // Wait for the URL to contain the expected page number
            fluentWait.until(ExpectedConditions.urlContains("?page=" + (i+1) + "&tab=repositories"));

            // Wait for repositories list to be visible
            List<WebElement> reposListWebElement1 = implicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='user-repositories-list']/ul/li/div/div/h3/a")));

            // Iterate through each element and extract its text
            for (WebElement element : reposListWebElement1) {
                String text = element.getText();
                System.out.println(text);
            }
        }
    }
}
