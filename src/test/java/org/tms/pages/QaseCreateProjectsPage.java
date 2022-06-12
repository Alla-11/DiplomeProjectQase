package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QaseCreateProjectsPage extends BasePage {

    @FindBy(xpath = "//input[@id='inputTitle']")
    private WebElement nameProjectInput;

    @FindBy(xpath = "//input[@id='inputCode']")
    private WebElement codeProjectInput;

    @FindBy(xpath = "//textarea[@id='inputDescription']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//input[@id='public-access-type']")
    private WebElement publicRadioButton;

    @FindBy(xpath = "//input[@id='private-access-type']")
    private WebElement privateRadioButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createProjectButton;


    @Step("Entering name project")
    public QaseCreateProjectsPage fillInProject(String nameProject){
        waitVisibilityOf(nameProjectInput);
        nameProjectInput.clear();
        nameProjectInput.sendKeys(nameProject);
        return this;
    }

    @Step("Entering code project")
    public QaseCreateProjectsPage fillInCode(String codeProject){
        codeProjectInput.clear();
        codeProjectInput.sendKeys(codeProject);
        return this;
    }

    @Step("Entering description project")
    public QaseCreateProjectsPage fillInDescription(String descriptionProject){
        descriptionInput.clear();
        descriptionInput.sendKeys(descriptionProject);
        return this;
    }

    @Step("Click on public radio button")
    public QaseCreateProjectsPage clickOnPublicRadioButton(){
        publicRadioButton.click();
        return this;
    }

    @Step("Click on private radio button")
    public QaseCreateProjectsPage clickOnPrivateRadioButton(){
        privateRadioButton.click();
        return this;
    }

    @Step("Click create project")
    public void clickCreateProject(){
        createProjectButton.click();
    }

}

