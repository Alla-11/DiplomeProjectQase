package org.tms.tests.UI;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.tms.driver.DriverSingleton;
import org.tms.utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void startBrowser(){
        driver = DriverSingleton.getInstance().getDriver();
    }

    @AfterTest
    public void stopBrowser(){
        DriverSingleton.getInstance().closeDriver();
    }

}

