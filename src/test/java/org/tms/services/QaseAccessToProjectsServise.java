package org.tms.services;

import io.qameta.allure.Step;
import org.tms.pages.QaseProjectsPage;
import org.tms.pages.QaseRepositoryPage;
import org.tms.pages.QaseSittingsProjectsPage;

public class QaseAccessToProjectsServise {

    protected QaseProjectsPage qaseProjectsPage= new QaseProjectsPage();
    protected QaseRepositoryPage qaseRepositoryPage = new QaseRepositoryPage();
    protected QaseSittingsProjectsPage qaseSittingsProjectsPage = new QaseSittingsProjectsPage();


    @Step("Access to public project")
    public boolean showAccessToPublicProject(){
        qaseProjectsPage.getProjectsPage();
        qaseProjectsPage.clickOnPublicProject();
        qaseRepositoryPage.clickSittingsButton();
        boolean valueAccessToPublicProject = qaseSittingsProjectsPage.showProjectAccessButton();
        return valueAccessToPublicProject;
    }

    @Step("Access to private project")
    public boolean showAccessToPrivateProject(){
        qaseProjectsPage.getProjectsPage();
        qaseProjectsPage.clickOnPrivateProject();
        qaseRepositoryPage.clickSittingsButton();
        boolean valueAccessToPrivateProject = qaseSittingsProjectsPage.showProjectAccessButton();
        return valueAccessToPrivateProject;
    }

}


