package org.tms.tests.UI;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.models.UI.Projects;
import org.tms.pages.QaseRepositoryPage;
import org.tms.services.QaseProjectsServise;
import org.tms.services.QaseLoginServise;
import org.tms.services.QasePublicRepositoryServise;
import org.tms.utils.DataProviders;

import static org.tms.utils.StringConstant.*;

@Log4j2
public class QasePublicRepositoryTest extends BaseTest{

    private QasePublicRepositoryServise qasePublicRepositoryServise;


    @BeforeClass
    public void openPublicProjectTest(){
        QaseLoginServise qaseLoginServise = new QaseLoginServise();
        qaseLoginServise.loginOnQaseMainPageWithValidData();
        QaseProjectsServise qaseProjectsServise = new QaseProjectsServise();
        Projects publicProject = Projects.builder()
                .nameProject(namePublicProject)
                .codeProject(codePublicProject)
                .descriptionProject(descriptionPublicProject)
                .build();
        qaseProjectsServise.createPublicProject(publicProject);
        log.info("Create public project before test methods");
        qasePublicRepositoryServise = new QasePublicRepositoryServise();
    }

    @Test(groups = "create")
    public void createSuiteInPublicProjectTest(){
        QaseRepositoryPage qaseRepositoryPage = qasePublicRepositoryServise.createNewSuiteInPublicRepository(namePublicSuite);
        String actualNameSuiteInPublicRepository = qaseRepositoryPage.getNameSuiteInPublicProject();
        String expectedNameSuiteInPublicRepository = namePublicSuite;
        log.info("Create suite in public project");
        Assert.assertEquals(actualNameSuiteInPublicRepository,expectedNameSuiteInPublicRepository,"Suite didn't create");
    }

    @Test (dataProvider = "SuiteData",dataProviderClass = DataProviders.class, groups = "create")
    public void createSomeSuiteInPublicProjectTest(String suiteNames){
        QaseRepositoryPage qaseRepositoryPage = qasePublicRepositoryServise.createNewSuiteInPublicRepository(suiteNames);
        String actualNamesSuiteInPublicRepository = qaseRepositoryPage.getNameSuiteInPublicProject();
        String expectedNamesSuiteInPublicRepository = namePublicSuite;
        log.info("Create some suites in public project");
        Assert.assertEquals(actualNamesSuiteInPublicRepository,expectedNamesSuiteInPublicRepository, "Some suites didn't create");
    }

    @Test(dependsOnMethods = "createSuiteInPublicProjectTest",groups = "create")
    public void createCaseInPublicProjectSuiteTest(){
        QaseRepositoryPage qaseRepositoryPage = qasePublicRepositoryServise.createNewCaseInPublicRepository(namePublicCase);
        String actualNameCaseInPublicRepository = qaseRepositoryPage.getNameOfCases(namePublicCase);
        log.info("Create case in public project");
        Assert.assertEquals(actualNameCaseInPublicRepository,namePublicCase,"Case didn't create");
      }

    @Test(dependsOnMethods = "createSuiteInPublicProjectTest",dataProvider = "CaseData",dataProviderClass = DataProviders.class, groups = "create")
    public void createSomeCaseInPublicProjectSuiteTest(String nameCases){
        QaseRepositoryPage qaseRepositoryPage = qasePublicRepositoryServise.createNewCaseInPublicRepository(nameCases);
        String actualNamesCaseInPublicRepository = qaseRepositoryPage.getNameOfCases(nameCases);
        log.info("Create some cases in public project");
        Assert.assertEquals(actualNamesCaseInPublicRepository,nameCases,"Some cases didn't create");
    }
}





