package org.tms.tests.UI;

import lombok.extern.log4j.Log4j2;
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

@Log4j2
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
        log.info("Create public project");
        Assert.assertEquals(actualPublicNameProject,namePublicProject,"Public project didn't create");
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
        log.info("Create private project");
        Assert.assertEquals(actualPrivateNameProject,namePrivateProject,"Private project didn't create");
    }

    @Test(dependsOnMethods = "createPublicProjectTest", retryAnalyzer = Retry.class)
    public void showAccessToPublicProjectTest(){
        log.info("Access to public project");
        Assert.assertTrue(qaseAccessToProjectsServise.showAccessToPublicProject(),"No access to public project");
    }

    @Test(dependsOnMethods = "createPrivateProjectTest", retryAnalyzer = Retry.class)
    public void showAccessToPrivateProjectTest(){
        log.info("Access to private project");
        Assert.assertFalse(qaseAccessToProjectsServise.showAccessToPrivateProject(),"Everyone has access to a private project");
    }

    @Test(dependsOnMethods = "showAccessToPublicProjectTest")
    public void deletePublicProjectTest(){
        qaseProjectsServise.deletePublicProject();
        log.info("Public project deleted");
        Assert.assertTrue(qaseProjectsServise.displayedPublicProjectsOnProjectsPage(),"Public project didn't delete");
    }

    @Test(dependsOnMethods = "showAccessToPrivateProjectTest")
    public void deletePrivateProjectTest(){
        qaseProjectsServise.deletePrivateProject();
        log.info("Private project deleted");
        Assert.assertTrue(qaseProjectsServise.displayedPrivateProjectsOnProjectsPage(),"Private project didn't delete");
    }
}


