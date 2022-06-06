package org.tms.tests.UI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.models.UI.Projects;
import org.tms.pages.QaseRepositoryPage;
import org.tms.services.QaseProjectsServise;
import org.tms.services.QaseLoginServise;

import static org.tms.utils.StringConstant.*;

public class QaseProjectsTest extends BaseTest {

    private QaseLoginServise qaseLoginServise;
    private QaseProjectsServise qaseProjectsServise;

    @BeforeClass
    public void openProjectsPageTest(){
        qaseLoginServise = new QaseLoginServise();
        qaseProjectsServise = new QaseProjectsServise();
        qaseLoginServise.loginOnQaseMainPageWithValidData();
    }

    @Test
    public void createPublicProjectTest(){
        Projects publicProject = Projects.builder()
                                    .nameProject(namePublicProject)
                                    .codeProject(codePublicProject)
                                    .descriptionProject(descriptionPublicProject)
                                    .build();
        QaseRepositoryPage qaseRepositoryPage = qaseProjectsServise.createPublicProject(publicProject);
        String actualPublicNameProject = qaseRepositoryPage.getNameProject();
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
        String actualPrivateNameProject = qaseRepositoryPage.getNameProject();
        String expectedPrivateNameProject = namePrivateProject;
        Assert.assertEquals(actualPrivateNameProject,expectedPrivateNameProject);
    }

    @Test(dependsOnMethods = "createPublicProjectTest")
    public void deletePublicProjectTest(){
        qaseProjectsServise.deletePublicProject();
        Assert.assertTrue(qaseProjectsServise.displayedPublicProjectsOnProjectsPage());

    }

    @Test(dependsOnMethods = "createPrivateProjectTest")
    public void deletePrivateProjectTest(){
        qaseProjectsServise.deletePrivateProject();
        Assert.assertTrue(qaseProjectsServise.displayedPrivateProjectsOnProjectsPage());
    }
}


