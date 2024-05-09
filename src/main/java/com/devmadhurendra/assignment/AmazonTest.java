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

    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = Logger.getLogger(AmazonTest.class.getName());

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(AMAZON_URI);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findAll(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    @Test(priority = 1)
    public void clickOnTodaysDeals() {
        click(By.xpath(TODAY_DEAL_XPATH));
    }

    @Test(priority = 2)
    public void getThirdDealAndAddToCart() {
        WebElement top3rdDeal = findAll(By.cssSelector(TOP_3_RD_DEAL)).get(2);
        top3rdDeal.click();
        try {
            click(By.xpath(PRODUCT_TO_BE_ADDED));
        } catch (TimeoutException e) {
            click(By.xpath(ADD_TO_CART_BUTTON_ELEMENT));
        } finally {
            click(By.xpath(ADD_TO_CART_BUTTON_ELEMENT));
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CART_BUTTON_ELEMENT))).click();
        } catch (TimeoutException e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ANOTHER_CART_ELEMENT))).click();
        }
        Assert.assertEquals("1", find(By.xpath(QUANTITY_ELEMENT)).getText());
    }

    @Test(priority = 3)
    public void searchForMobilesAndScroll() {
        WebElement searchedBox = find(By.xpath(SEARCH_INPUT_ELEMENT));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchedBox)
                .click()
                .sendKeys(VALUE_TO_SEARCH)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.ENTER)
                .perform();
        List<WebElement> allProducts = findAll(By.xpath(ALL_PRODUCTS));
        String details = allProducts.get(allProducts.size() - 1).getText();
        logger.log(Level.INFO, details);
    }

    @Test(priority = 4)
    public void navigateToMobilePhones() {
        WebElement mobileElement = find(By.xpath(MOBILES_NAV));
        mobileElement.click();
        driver.navigate().back();
    }

    @Test(priority = 5)
    public void selectPrimeDeliveryCheckbox() {
        click(By.cssSelector(ANOTHER_CART_ELEMENT));
        click(By.cssSelector(PROCEED_TO_BUY));
    }

    @Test(priority = 6)
    public void login() {
        find(By.cssSelector(EMAIL_LOGIN)).sendKeys(AMAZON_USERNAME);
        click(By.cssSelector(CONTINUE));
        find(By.cssSelector(PASSWORD_LOGIN)).sendKeys(AMAZON_PASSWORD);
        click(By.cssSelector(SIGN_IN));
    }

    @Test(priority = 7)
    public void getITemDeliveryDate() {
        WebElement element = find(By.cssSelector(ITEM_DELIVERY_DATE));
        String date = element.getText();
        System.out.println(date);
        Assert.assertTrue(element.isDisplayed());
    }

    @Test(priority = 8)
    public void goToOrdersAndSelectPastOneYearOrders() {
        String[] cssSelectors = {
                HOME_PAGE,
                RETURN_AND_ORDERS,
                SELECT_DROPDOWN,
                SELECT_PAST_ONE_YEAR
        };

        for (String cssSelectorValue: cssSelectors) {
            click(By.cssSelector(cssSelectorValue));
        }

        String ordersInOneYear = find(By.cssSelector(ORDERS_IN_ONE_YEAR)).getText();
        Assert.assertEquals("4 orders", ordersInOneYear);
    }

    @Test(priority = 9)
    public void addNewAddress() {
        String[][] cssSelectorAndValues = {
                {YOUR_ACCOUNTS, ""},
                {YOUR_ADDRESSES, ""},
                {ADD_ADDRESS, ""},
                {FULL_NAME, FULL_NAME_VALUE},
                {MOBILE_NUMBER, MOBILE_NUMBER_VALUE},
                {PIN_CODE, PIN_CODE_VALUE},
                {ADDRESS_LINE_1, ADDRESS_LINE_1_VALUE},
                {ADDRESS_LINE_2, ADDRESS_LINE_2_VALUE},
                {LANDMARK, LANDMARK_VALUE},
                {TOWN_CITY, TOWN_CITY_VALUE},
                {CHOOSE_CITY, ""},
                {UTTAR_PRADESH, ""},
                {ADD_ADDRESS_BUTTON, ""}
        };

        // Loop through the CSS selectors and perform actions accordingly
        for (String[] cssSelectorAndValue : cssSelectorAndValues) {
            String cssSelector = cssSelectorAndValue[0];
            String value = cssSelectorAndValue[1];

            if (value.isEmpty()) {
                click(By.cssSelector(cssSelector));
            } else {
                find(By.cssSelector(cssSelector)).sendKeys(value);
            }
        }

        // Verify the number of addresses added
        List<WebElement> addressesAdded = findAll(By.cssSelector(ADDRESS_COLUMN));
        Assert.assertEquals(4, addressesAdded.size());
    }

    @Test(priority = 10)
    public void addNewPaymentsMethod() {
        click(By.cssSelector(YOUR_ACCOUNT_TREE));
        click(By.cssSelector(PAYMENT_OPTIONS));
        click(By.cssSelector(EDIT_PAYMENT));
    }
}
