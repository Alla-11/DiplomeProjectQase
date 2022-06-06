package org.tms.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class QaseLoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='inputEmail']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='inputPassword']")
    private WebElement password;

    @FindBy(xpath = "//button[@id='btnLogin']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='form-control-feedback']")
    private WebElement loginErrorMessage;




    @Step ("Opening qase.io")
    public QaseLoginPage openPage(String url){
        driver.get(url);
        return this;
    }

    @Step ("Entering user name")
    public QaseLoginPage fillInUsername(String login){
        userName.sendKeys(login);
        return this;
    }

    @Step ("Entering password")
    public QaseLoginPage fillInPassword(String keyPassword){
        password.sendKeys(keyPassword);
        return this;
    }

    @Step("Click on button 'Login'")
    public void clickLoginButton(){
        loginButton.click();
    }

    @Step ("Login error message")
    public String getLoginErrorMessage(){
        waitVisibilityOf(loginErrorMessage);
        return loginErrorMessage.getText();
    }
}



