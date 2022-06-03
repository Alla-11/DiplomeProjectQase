package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.tms.utils.StringConstant.namePublicSuite;


public class QaseRepositoryPage extends BasePage{

    @FindBy(xpath = "//p[@class='header']")
    private WebElement nameProject;

    @FindBy(xpath = "//a[@id='create-suite-button']")
    private WebElement createSuiteButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameSuiteInput;

    @FindBy(xpath = "//button[@id='save-suite-button']")
    private WebElement cteateSuiteButton;

    @FindBy(xpath = "//a[@title='%s']")
    private WebElement nameSuite;

    @FindBy(xpath = "//a[@id='create-case-button']")
    private WebElement createCaseButton;

    @FindBy(xpath = "//div[@class='style_case_count-1fC9v']")
    private WebElement numberCases;

    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    private WebElement sittingsButton;





    @Step("Get name project on repository page")
    public String getNameProject(){
        waitVisibilityOf(nameProject);
        return nameProject.getText();
    }

    @Step("Get form to create suite")
    public QaseRepositoryPage getFormToCreateSuiteInPublicProject(){
        waitVisibilityOf(createSuiteButton);
        createSuiteButton.click();
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
        cteateSuiteButton.click();
        return this;
    }

    @Step("Get name suite in publick project")
    public String getNameSuiteInPublicProject(){
        waitVisibilityOf(nameProject);
        return String.format(namePublicSuite, nameSuite);
    }

    @Step("Click on create case button")
    public QaseCreateCasePage clickOnCreateCaseButtonInPublicProject(){
        createCaseButton.click();
        return new QaseCreateCasePage();
    }

    @Step("Get number of cases")
    public String getNumberOfCases(){
        waitVisibilityOf(numberCases);
        return numberCases.getText();
    }

    @Step("Click on Sittings button in Project")
    public QaseSittingsProjectsPage clickSittingsButton(){
        waitVisibilityOf(sittingsButton);
        sittingsButton.click();
        return new QaseSittingsProjectsPage();
    }
}


