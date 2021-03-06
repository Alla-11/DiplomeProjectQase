package org.tms.services;

import io.qameta.allure.Step;
import org.tms.models.UI.Projects;
import org.tms.pages.QaseCreateProjectsPage;
import org.tms.pages.QaseDeleteProjectPage;
import org.tms.pages.QaseProjectsPage;
import org.tms.pages.QaseRepositoryPage;

public class QaseProjectsServise {

    protected QaseProjectsPage qaseProjectsPage = new QaseProjectsPage();
    protected QaseCreateProjectsPage qaseCreateProjectsPage = new QaseCreateProjectsPage();
    protected QaseDeleteProjectPage qaseDeleteProjectPage = new QaseDeleteProjectPage();



    @Step("Create public project")
    public QaseRepositoryPage createPublicProject(Projects publicProjects){
        qaseProjectsPage.getProjectsPage();
        qaseProjectsPage.getPageToCreateProject();
        qaseCreateProjectsPage.fillInProject(publicProjects.getNameProject())
                              .fillInCode(publicProjects.getCodeProject())
                              .fillInDescription(publicProjects.getDescriptionProject())
                              .clickOnPublicRadioButton()
                              .clickCreateProject();
        return new QaseRepositoryPage();
    }

    @Step("Create private project")
    public QaseRepositoryPage createPrivateProject(Projects privateProjects){
        qaseProjectsPage.getProjectsPage();
        qaseProjectsPage.getPageToCreateProject();
        qaseCreateProjectsPage.fillInProject(privateProjects.getNameProject())
                              .fillInCode(privateProjects.getCodeProject())
                              .fillInDescription(privateProjects.getDescriptionProject())
                              .clickOnPrivateRadioButton()
                              .clickCreateProject();
        return new QaseRepositoryPage();
    }


    @Step("Delete public project")
    public void deletePublicProject(){
        qaseProjectsPage.getProjectsPage();
        qaseProjectsPage.clickDropdownDeletePublicProject();
        qaseDeleteProjectPage.clickOnDeleteProject();
    }

    @Step("Delete private project")
    public void deletePrivateProject(){
        qaseProjectsPage.getProjectsPage();
        qaseProjectsPage.clickDropdownDeletePrivateProject();
        qaseDeleteProjectPage.clickOnDeleteProject();
    }

    @Step("Displayed projects")
    public boolean displayedPublicProjectsOnProjectsPage(){
        return qaseProjectsPage.displayedPublicProject();
    }

    @Step("Displayed projects")
    public boolean displayedPrivateProjectsOnProjectsPage(){
        return qaseProjectsPage.displayedPrivateProject();
    }

}


