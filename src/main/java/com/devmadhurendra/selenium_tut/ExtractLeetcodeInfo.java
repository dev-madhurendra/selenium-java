package com.devmadhurendra.selenium_tut;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.devmadhurendra.utils.LeetcodeUtils.*;

public class ExtractLeetcodeInfo {

    private static Logger logger =
            Logger.getLogger(ExtractLeetcodeInfo.class.getName());

    public static void main(String[] args) {

        // Get the username from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter username : ");
        String username = sc.nextLine();

        // Initialize chrome driver
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();


        String URL = "https://leetcode.com/u/" + username + "/";

        try {
            // Visit the url
            driver.get(URL);

            // Explicit wait for 20 second
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Get the contest rating element
            List<WebElement> contestRatingElement =
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.xpath(CONTEST_RATING_ELEMENT)
                    ));

            List<String> problemCategories = new ArrayList<>();

            for (WebElement solveProblem:
                 contestRatingElement) {
                String solveValue = solveProblem.getText();

                // Get the problem value
                String noOfProblemSolved = solveValue.substring(0, solveValue.indexOf('/'));

                problemCategories.add(noOfProblemSolved);
            }

            for (String value:
                 problemCategories) {
                System.out.println(value);
            }

            WebElement showMoreElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(SHOW_MORE_ELEMENT)
            ));

            showMoreElement.click();

            List<WebElement> programmingLangs =
                    driver.findElements(By.xpath(LANGUAGES_USED));

            for (WebElement lang:
                 programmingLangs) {
                System.out.println(lang.getText());
            }

        } catch (WebDriverException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } finally {
            // Quit the driver
            driver.quit();
        }
    }
}
