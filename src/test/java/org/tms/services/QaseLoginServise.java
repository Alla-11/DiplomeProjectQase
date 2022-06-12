package org.tms.services;

import io.qameta.allure.Step;
import org.tms.models.UI.Users;
import org.tms.pages.QaseProjectsPage;
import org.tms.pages.QaseLoginPage;

public class QaseLoginServise {

    private static final String URL_QASE_MAIN_PAGE = "https://app.qase.io/login";


    private final QaseLoginPage qaseLoginPage = new QaseLoginPage();
    private final Users user = new Users();

    @Step ("Autorization on qase.io with valid data")
    public QaseProjectsPage loginOnQaseMainPageWithValidData(){
        qaseLoginPage.openPage(URL_QASE_MAIN_PAGE)
                     .fillInUsername(user.getValidName())
                     .fillInPassword(user.getValidPassword())
                     .clickLoginButton();
        return new QaseProjectsPage();
    }

    @Step("Autorization on qase.io with invalid password")
    public String loginOnQaseMainPageWithInvalidData(){
        qaseLoginPage.openPage(URL_QASE_MAIN_PAGE)
                     .fillInUsername(user.getValidName())
                     .fillInPassword(user.getInvalidPassword())
                     .clickLoginButton();
        return qaseLoginPage.getLoginErrorMessage();
    }

}






