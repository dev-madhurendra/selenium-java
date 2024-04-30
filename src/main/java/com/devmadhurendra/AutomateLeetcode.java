package com.devmadhurendra;

import com.devmadhurendra.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

import static com.devmadhurendra.utils.SeleniumConstants.*;
import static com.devmadhurendra.utils.SeleniumUtils.*;

public class AutomateLeetcode {

    private static WebDriver driver;

    private static void automateLeetcode(
            String username,
            String password,
            String problemNo
    ) {

        // Set up WebDriver
        WebDriver driver = new ChromeDriver();

        // Go to the leetcode home page
        driver.get(URL);

        // Instantiate SeleniumUtils
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);

        // Sign in to the application
        clickElementByCssSelector(LOGIN_ELEMENT);

        // Wait for few seconds
        waitForSecond(5);

        // Enter credentials
        fillInputFieldByCssSelector(LOGIN_EMAIL_INPUT_FIELD,username);
        fillInputFieldByCssSelector(LOGIN_PASSWORD_INPUT_FIELD,password);

        // Wait for few seconds
        Scanner sc = new Scanner(System.in);
        System.out.println(">> Please provide code you wanna submit ");
        String code  = sc.next();

        // Click on SignIn button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIGN_IN_BUTTON_CLASS_NAME)));
        WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SIGN_IN_BUTTON_CLASS_NAME)));
        signInElement.click();
        // clickElementByCssSelector(SIGN_IN_BUTTON_CLASS_NAME);

        clickById(PROFILE_ELEMENT);

        clickElementByCssSelector(USER_NAME_ELEMENT);
        clickElementByCssSelector(LEETCODE_PROBLEM_SET);

        // clickElementByXPath(PICK_ONE);
        fillInputFieldByCssSelector(SEARCH_QUES, problemNo);
        waitForSecond(40);
        clickElementByXPath(PROBLEM_URL);
        // clickElementByXPath(SOLUTIONS_HREF);
        // clickElementByXPath(CPP_SOLUTION);
        // clickElementByXPath(SOLUTION_1);

        // String code = getSolutionCode(SOLUTION_CODE);
        // System.out.println(code);
        waitForSecond(40);
        clearCodeAreaAndWrite(CODE_AREA, code);

        formatCode(CODE_AREA);

        waitForSecond(20);

        // clickElementByCssSelector(SUBMIT_BUTTON_ELEMENT);
        runSolution(CODE_AREA);


        // Quit the driver
        // driver.quit();
    }
    public static void main(String[] args) {

        automateLeetcode(
                LOGIN_EMAIL_INPUT_FIELD_VALUE,
                LOGIN_PASSWORD_INPUT_FIELD_VALUE,
                "1123"
        );
    }
}
