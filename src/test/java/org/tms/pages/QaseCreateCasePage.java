package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QaseCreateCasePage extends BasePage{

    @FindBy(xpath = "//input[@id='title']")
    private WebElement nameCaseInput;

    @FindBy(xpath = "//button[@id='save-case']")
    private WebElement saveButton;

    @Step("Entering name case in input from create new case in public project")
    public QaseCreateCasePage fillInTitle(String title){
        waitVisibilityOf(nameCaseInput);
        nameCaseInput.sendKeys(title);
        return this;
    }

    @Step("Click on save button")
    public QaseCreateCasePage clickOnSaveButton(){
        saveButton.click();
        return this;
    }
}

