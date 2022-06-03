package org.tms.services;

import io.qameta.allure.Step;
import org.tms.pages.QaseCreateCasePage;
import org.tms.pages.QaseRepositoryPage;



public class QasePublicRepositoryServise {

    protected QaseRepositoryPage qaseRepositoryPage = new QaseRepositoryPage();

    @Step("Create new suite in public repository")
    public QaseRepositoryPage createNewSuiteInPublicRepository(String suiteName){
        qaseRepositoryPage.getFormToCreateSuiteInPublicProject()
                           .fillInNameSuiteInPublicProject(suiteName)
                           .clickOnCreateSuiteButton();
        return new QaseRepositoryPage();
    }

    @Step("Create new case in public repository")
    public QaseRepositoryPage createNewCaseInPublicRepository(String caseName){
        QaseCreateCasePage qaseCreateCasePage = qaseRepositoryPage.clickOnCreateCaseButtonInPublicProject();
        qaseCreateCasePage.fillInTitle(caseName)
                          .clickOnSaveButton();
        return new QaseRepositoryPage();
    }

}



