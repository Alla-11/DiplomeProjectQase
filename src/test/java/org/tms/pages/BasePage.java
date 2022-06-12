package org.tms.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tms.driver.DriverSingleton;

import static org.tms.utils.StringConstant.TIMEOUT;


public abstract class BasePage {

    protected WebDriver driver = DriverSingleton.getInstance().getDriver();

    protected BasePage(){
        PageFactory.initElements(driver,this);
    }

    protected void waitVisibilityOf(WebElement element){
        new WebDriverWait(driver,TIMEOUT).until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean displayedElement(WebElement element){
        try {
            element.isDisplayed();
            return false;
        } catch (NoSuchElementException e){
            return true;
        }
    }

}







