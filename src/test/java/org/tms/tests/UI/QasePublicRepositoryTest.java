package org.tms.tests.UI;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.models.Projects;
import org.tms.pages.QaseRepositoryPage;
import org.tms.services.QaseProjectsServise;
import org.tms.services.QaseLoginServise;
import org.tms.services.QasePublicRepositoryServise;
import org.tms.utils.DataProviders;

import static org.tms.utils.StringConstant.*;

@Log4j2
public class QasePublicRepositoryTest extends BaseTest{

    private QaseLoginServise qaseLoginServise;
    private QaseProjectsServise qaseProjectsServise;
    private QasePublicRepositoryServise qasePublicRepositoryServise;

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
        log.info("Create public project before test methods");
        qasePublicRepositoryServise = new QasePublicRepositoryServise();
    }

    @AfterClass
    public void deletePublicProjectTest(){
        qaseProjectsServise.deletePublicProject();
        log.info("delete public project after test methods");
    }

    @Test
    public void createSuiteInPublicProject(){
        QaseRepositoryPage qaseRepositoryPage = qasePublicRepositoryServise.createNewSuiteInPublicRepository(namePublicSuite);
        String actualNameSuiteInPublicRepository = qaseRepositoryPage.getNameSuiteInPublicProject();
        String expectedNameSuiteInPublicRepository = namePublicSuite;
        Assert.assertEquals(actualNameSuiteInPublicRepository,expectedNameSuiteInPublicRepository);
    }

    @Test (dataProvider = "SuiteData",dataProviderClass = DataProviders.class)
    public void createSomeSuiteInPublicProjectTest(String suiteNames){
        QaseRepositoryPage qaseRepositoryPage = qasePublicRepositoryServise.createNewSuiteInPublicRepository(suiteNames);
        String actualNamesSuiteInPublicRepository = qaseRepositoryPage.getNameSuiteInPublicProject();
        String expectedNamesSuiteInPublicRepository = namePublicSuite;
        Assert.assertEquals(actualNamesSuiteInPublicRepository,expectedNamesSuiteInPublicRepository);
    }

    @Test(dependsOnMethods = "createSuiteInPublicProject")
    public void createCaseInPublicProjectSuiteTest(){
        QaseRepositoryPage qaseRepositoryPage = qasePublicRepositoryServise.createNewCaseInPublicRepository(namePublicCase);
        Integer actualNamberCaseInPublicRepository = Integer.valueOf(qaseRepositoryPage.getNumberOfCases());
        Assert.assertTrue(actualNamberCaseInPublicRepository > 0);
    }

    @Test(dependsOnMethods = "createSuiteInPublicProject",dataProvider = "CaseData",dataProviderClass = DataProviders.class)
    public void createSomeCaseInPublicProjectSuiteTest(String nameCases){
        QaseRepositoryPage qaseRepositoryPage = qasePublicRepositoryServise.createNewCaseInPublicRepository(nameCases);
        Integer actualNamberCaseInPublicRepository = Integer.valueOf(qaseRepositoryPage.getNumberOfCases());
        Assert.assertTrue(actualNamberCaseInPublicRepository > 0);
    }
}

