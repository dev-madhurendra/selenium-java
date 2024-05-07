package com.devmadhurendra.assignment;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.devmadhurendra.assignment.AmazonTestConstants.*;

public class AmazonTest {

    WebDriver driver;
    WebDriverWait wait;
    Logger logger = Logger.getLogger(AmazonTest.class.getName());

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Navigate to Amazon.in
        driver.get(AMAZON_URI);
    }

    @Test(priority = 1)
    public void clickOnTodaysDeals() {
        // Click on Today's Deals
        WebElement todayDealsButton =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TODAY_DEAL_XPATH)));
        todayDealsButton.click();
    }

    @Test(priority = 2)
    public void getThirdDealAndAddToCart() {
        try {
            // Get the 3rd deal
            WebElement top3rdDeal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TOP_3_RD_DEAL)));
            top3rdDeal.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRODUCT_TO_BE_ADDED))).click();

            // String productAddedInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PRODUCT_HAVE_TO_ADD_IN_CART))).getText();

            // Add minimum quantities required item to cart
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADD_TO_CART_BUTTON_ELEMENT))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SKIP_ELEMENT))).click();

            // Verify if the quantity is as expected in the cart
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CART_BUTTON_ELEMENT))).click();

            // String productAvailableInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADDED_ITEM_IN_CART_PRODUCT))).getText();
            // productAvailableInCart = productAvailableInCart.substring(0, productAddedInCart.length());

            // Verifying product name
            // Assert.assertEquals(productAddedInCart, productAvailableInCart);

            // Verifying product quantity
            String quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(QUANTITY_ELEMENT))).getText();
            logger.log(Level.INFO, quantity);
            Assert.assertEquals("1", quantity);

        } catch (TimeoutException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Test(priority = 3)
    public void searchForMobilesAndScroll() {
        // Search for Mobiles
        WebElement searchedBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_INPUT_ELEMENT)));
        Actions actions = new Actions(driver);

        actions.moveToElement(searchedBox)
                .click()
                .sendKeys(VALUE_TO_SEARCH)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER)
                .perform();

        List<WebElement> allProducts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(ALL_PRODUCTS)));

        String details = allProducts.get(allProducts.size() - 1).getText();

        logger.log(Level.INFO, details);
    }

    @Test(priority = 4)
    public void navigateToMobilePhones() {
        WebElement mobileElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MOBILES_NAV)));

        // Navigate from left nav to Mobiles and select Mobile phones
        mobileElement.click();
        driver.navigate().back();
    }

    @AfterClass
    public void tearDown() {
        // Quit WebDriver
        // driver.quit();
    }
}
