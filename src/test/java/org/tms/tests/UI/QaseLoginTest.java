package org.tms.tests.UI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.pages.QaseProjectsPage;
import org.tms.services.QaseLoginServise;


import static org.tms.utils.StringConstant.errorTextOnLoginPage;
import static org.tms.utils.StringConstant.textOnProjectsPage;


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
        Assert.assertEquals(actualTextOfProjectsPage,expectedTextOfProjectsPage);
    }

    @Test
    public void loginErrorQaseMainPageTest(){
        String expectedTextOnLoginPage = errorTextOnLoginPage;
        String actualTextOnLoginPage = qaseServise.loginOnQaseMainPageWithInvalidData();
        Assert.assertEquals(actualTextOnLoginPage,expectedTextOnLoginPage);

    }
}




