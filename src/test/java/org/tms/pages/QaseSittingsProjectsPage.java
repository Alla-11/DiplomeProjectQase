package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QaseSittingsProjectsPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(),'Project Access')]")
    private WebElement projectAccessButton;

    @FindBy(xpath = "//a[contains(text(),'Environments')]")
    private WebElement environmentsButton;


    @Step("Show button 'Project Access'")
    public boolean showProjectAccessButton() {
        waitVisibilityOf(environmentsButton);
        try {
            this.projectAccessButton.isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}

