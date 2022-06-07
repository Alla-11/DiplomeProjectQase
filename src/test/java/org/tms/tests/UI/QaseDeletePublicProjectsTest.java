package org.tms.tests.UI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.services.QaseLoginServise;
import org.tms.services.QaseProjectsServise;

public class QaseDeletePublicProjectsTest extends BaseTest{

    private QaseLoginServise qaseLoginServise;
    private QaseProjectsServise qaseProjectsServise;

    @BeforeClass
    public void openProjectsPageTest(){
        qaseLoginServise = new QaseLoginServise();
        qaseProjectsServise = new QaseProjectsServise();
        qaseLoginServise.loginOnQaseMainPageWithValidData();
    }

    @Test
    public void deletePublicProjectTest(){
        qaseProjectsServise.deletePublicProject();
        Assert.assertTrue(qaseProjectsServise.displayedPublicProjectsOnProjectsPage());
    }

}


