package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.tms.utils.StringConstant.namePublicSuite;


public class QaseRepositoryPage extends BasePage{

    @FindBy(xpath = "//div[contains(text(),'%s')]")
    private WebElement nameProjects;

    @FindBy(xpath = "//a[@id='create-suite-button']")
    private WebElement createSuitesButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameSuiteInput;

    @FindBy(xpath = "//button[@id='save-suite-button']")
    private WebElement createSuiteButton;

    @FindBy(xpath = "//a[@title='%s']")
    private WebElement nameSuite;

    @FindBy(xpath = "//a[@id='create-case-button']")
    private WebElement createCaseButton;

    @FindBy(xpath = " //div[contains(text(),'%s')]")
    private WebElement numberCases;

    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    private WebElement sittingsButton;





    @Step("Get name project on repository page")
    public String getNameProject(String nameProject){
        waitVisibilityOf(createSuitesButton);
        System.out.println(String.format(nameProject,nameProjects) + "имя нового проекта");
        return String.format(nameProject,nameProjects);
    }

    @Step("Get form to create suite")
    public QaseRepositoryPage getFormToCreateSuiteInPublicProject(){
        waitVisibilityOf(createSuitesButton);
        createSuitesButton.click();
        return this;
    }

    @Step("Entering name suite")
    public QaseRepositoryPage fillInNameSuiteInPublicProject(String nameSuite){
        waitVisibilityOf(nameSuiteInput);
        nameSuiteInput.sendKeys(nameSuite);
        return this;
    }

    @Step("Click on 'Create' suite button")
    public QaseRepositoryPage clickOnCreateSuiteButton(){
        waitVisibilityOf(createSuiteButton);
        createSuiteButton.click();
        return this;
    }

    @Step("Get name suite in publick project")
    public String getNameSuiteInPublicProject(){
        waitVisibilityOf(createSuitesButton);
        return String.format(namePublicSuite, nameSuite);
    }

    @Step("Click on create case button")
    public QaseCreateCasePage clickOnCreateCaseButtonInPublicProject(){
        waitVisibilityOf(createCaseButton);
        createCaseButton.click();
        return new QaseCreateCasePage();
    }

    @Step("Get name of cases")
    public String getNameOfCases(String nameCase){
        waitVisibilityOf(sittingsButton);
        return String.format(nameCase,numberCases);
    }

    @Step("Click on Sittings button in Project")
    public QaseSittingsProjectsPage clickSittingsButton(){
        waitVisibilityOf(sittingsButton);
        sittingsButton.click();
        return new QaseSittingsProjectsPage();
    }
}


