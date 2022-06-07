package org.tms.tests.UI;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.adapters.QaseProjectsAdapter;
import org.tms.models.API.Project;
import org.tms.models.UI.Projects;
import org.tms.pages.QaseProjectsPage;
import org.tms.services.QaseAccessToProjectsServise;
import org.tms.services.QaseLoginServise;
import org.tms.services.QaseProjectsServise;


import static org.tms.utils.StringConstant.*;

@Log4j2
public class QaseAccessToProjectsTest extends BaseTest{

    private QaseLoginServise qaseLoginServise;
    private QaseProjectsServise qaseProjectsServise;
    private QaseAccessToProjectsServise qaseAccessToProjectsServise;
    private QaseProjectsPage qaseProjectsPage;

    @BeforeClass
    public void openPublicProjectTest(){
        qaseLoginServise = new QaseLoginServise();
        qaseLoginServise.loginOnQaseMainPageWithValidData();
        qaseProjectsServise = new QaseProjectsServise();
        Projects publicProject = Projects.builder()
                                         .nameProject(namePublicProject)
                                         .codeProject(codePublicProject)
                                         .descriptionProject(descriptionPublicProject)
                                         .build();
        qaseProjectsServise.createPublicProject(publicProject);
        log.info("Created public project before test methods");

        Projects privateProject = Projects.builder()
                                          .nameProject(namePrivateProject)
                                          .codeProject(codePrivateProject)
                                          .descriptionProject(descriptionPrivateProject)
                                          .build();
        qaseProjectsServise.createPrivateProject(privateProject);
        log.info("Created private project before test methods");
        qaseAccessToProjectsServise = new QaseAccessToProjectsServise();
        qaseProjectsPage = new QaseProjectsPage();
    }

    @Test
    public void showAccessToPublicProjectTest(){
        Assert.assertTrue(qaseAccessToProjectsServise.showAccessToPublicProject());

    }
    @Test
    public void showAccessToPrivateProjectTest(){
        Assert.assertFalse(qaseAccessToProjectsServise.showAccessToPrivateProject());
    }



    @AfterClass
    public void deletePublicProjectTest(){
        //qaseProjectsPage.getProjectsPage();
        qaseProjectsServise.deletePublicProject();
        qaseProjectsServise.deletePrivateProject();
    }
}


