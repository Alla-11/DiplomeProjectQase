package org.tms.tests.UI;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.pages.QaseProjectsPage;
import org.tms.services.QaseLoginServise;


import static org.tms.utils.StringConstant.errorTextOnLoginPage;
import static org.tms.utils.StringConstant.textOnProjectsPage;

@Log4j2
public class QaseLoginTest extends BaseTest{

    private QaseLoginServise qaseServise;


    @BeforeClass
    public void setUp(){
        qaseServise = new QaseLoginServise();
    }


    @Test
    public void loginQaseMainPageWhitValidDataTest(){
        QaseProjectsPage projectsPage = qaseServise.loginOnQaseMainPageWithValidData();
        String expectedTextOfProjectsPage = textOnProjectsPage;
        String actualTextOfProjectsPage = projectsPage.getTextProjects();
        log.info("Logging with valid data");
        Assert.assertEquals(actualTextOfProjectsPage,expectedTextOfProjectsPage,"User not logged in");
    }

    @Test
    public void loginErrorQaseMainPageTest(){
        String expectedTextOnLoginPage = errorTextOnLoginPage;
        String actualTextOnLoginPage = qaseServise.loginOnQaseMainPageWithInvalidData();
        log.info("Logging with invalid data");
        Assert.assertEquals(actualTextOnLoginPage,expectedTextOnLoginPage, "The actual result does not match the expected");
    }
}




