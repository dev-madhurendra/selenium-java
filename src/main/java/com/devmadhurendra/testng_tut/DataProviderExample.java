package com.devmadhurendra.testng_tut;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Apart from Parameters, there is another way to achieve parameterization which is by using DataProvider in TestNG.
 * Data providers are used for data-driven testing, allowing the same test case to be run with different sets of data.
 * It is a powerful feature of TestNG and is effectively used during framework development.
 * <p>
 * Annotated method to return an array of Object.
 * Data provider can have a name, and it will be used in other methods by using its name.
 * Data provider can be implemented in the same class or different class.
 * Annotation used for DataProvider is @DataProvider.
 */

public class DataProviderExample {

    @Test(
            dataProvider = "LoginDataProvider",
            dataProviderClass = CustomDataProvider.class
    )
    public void loginTest(String email, String pwd) {
        System.out.println(email + "   " + pwd);
    }
}

