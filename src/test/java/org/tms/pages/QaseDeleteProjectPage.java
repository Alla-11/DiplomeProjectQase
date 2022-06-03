package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QaseDeleteProjectPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement deleteProjectButton;



    @Step("Click on 'Delete Project' button")
    public QaseProjectsPage clickOnDeleteProject(){
        waitVisibilityOf(deleteProjectButton);
        deleteProjectButton.click();
        return new QaseProjectsPage();
    }

}



