package org.tms.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tms.driver.DriverSingleton;


import java.time.Duration;

import static org.tms.utils.StringConstant.TIMEOUT;


public abstract class BasePage {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();

    protected BasePage(){
        PageFactory.initElements(driver,this);
    }

    protected WebElement waitVisibilityOf(WebElement element){
        return new WebDriverWait(driver,TIMEOUT).until(ExpectedConditions.visibilityOf(element));
    }

    protected static void waitForElementToBeClickable(WebElement element) {
        new FluentWait<>(DriverSingleton.getInstance().getDriver()).withTimeout(Duration.ofSeconds(TIMEOUT))
                .pollingEvery(Duration.ofMillis(TIMEOUT)).ignoring(NoSuchElementException.class)
                .until((ExpectedCondition<Boolean>) webDriver -> element.isDisplayed() && element
                        .isEnabled());
    }

}




