package org.tms.tests.UI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.models.UI.Projects;
import org.tms.pages.QaseRepositoryPage;
import org.tms.services.QaseAccessToProjectsServise;
import org.tms.services.QaseProjectsServise;
import org.tms.services.QaseLoginServise;
import org.tms.utils.Retry;

import static org.tms.utils.StringConstant.*;

public class QaseProjectsTest extends BaseTest {

    private QaseProjectsServise qaseProjectsServise;
    private QaseAccessToProjectsServise qaseAccessToProjectsServise;

    @BeforeClass
    public void openProjectsPageTest(){
        QaseLoginServise qaseLoginServise = new QaseLoginServise();
        qaseLoginServise.loginOnQaseMainPageWithValidData();
        qaseProjectsServise = new QaseProjectsServise();
        qaseAccessToProjectsServise = new QaseAccessToProjectsServise();
    }

    @Test
    public void createPublicProjectTest(){
        Projects publicProject = Projects.builder()
                                    .nameProject(namePublicProject)
                                    .codeProject(codePublicProject)
                                    .descriptionProject(descriptionPublicProject)
                                    .build();
        QaseRepositoryPage qaseRepositoryPage = qaseProjectsServise.createPublicProject(publicProject);
        String actualPublicNameProject = qaseRepositoryPage.getNameProject(namePublicProject);
        String expectedPublicNameProject = namePublicProject;
        Assert.assertEquals(actualPublicNameProject,expectedPublicNameProject);
    }


    @Test
    public void createPrivateProjectTest(){
        Projects privateProject = Projects.builder()
                                          .nameProject(namePrivateProject)
                                          .codeProject(codePrivateProject)
                                          .descriptionProject(descriptionPrivateProject)
                                          .build();
        QaseRepositoryPage qaseRepositoryPage = qaseProjectsServise.createPrivateProject(privateProject);
        String actualPrivateNameProject = qaseRepositoryPage.getNameProject(namePrivateProject);
        String expectedPrivateNameProject = namePrivateProject;
        Assert.assertEquals(actualPrivateNameProject,expectedPrivateNameProject);
    }

    @Test(dependsOnMethods = "createPublicProjectTest", retryAnalyzer = Retry.class)
    public void showAccessToPublicProjectTest(){
        Assert.assertTrue(qaseAccessToProjectsServise.showAccessToPublicProject());

    }

    @Test(dependsOnMethods = "createPrivateProjectTest", retryAnalyzer = Retry.class)
    public void showAccessToPrivateProjectTest(){
        Assert.assertFalse(qaseAccessToProjectsServise.showAccessToPrivateProject());
    }

    @Test(dependsOnMethods = "showAccessToPublicProjectTest")
    public void deletePublicProjectTest(){
        qaseProjectsServise.deletePublicProject();
        Assert.assertTrue(qaseProjectsServise.displayedPublicProjectsOnProjectsPage());

    }

    @Test(dependsOnMethods = "showAccessToPrivateProjectTest")
    public void deletePrivateProjectTest(){
        qaseProjectsServise.deletePrivateProject();
        Assert.assertTrue(qaseProjectsServise.displayedPrivateProjectsOnProjectsPage());
    }
}


