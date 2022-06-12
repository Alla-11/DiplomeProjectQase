package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class QaseSittingsProjectsPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(),'Project Access')]")
    private WebElement projectAccessButton;

    @FindBy(xpath = "//a[@title='Webhooks']")
    private WebElement webhooksButton;


    @Step("Show button 'Project Access'")
    public boolean showProjectAccessButton() {
        waitVisibilityOf(webhooksButton);
        return displayedElement(projectAccessButton);
    }
}

