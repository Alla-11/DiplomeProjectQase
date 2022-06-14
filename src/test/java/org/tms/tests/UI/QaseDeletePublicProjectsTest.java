package org.tms.tests.UI;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.services.QaseLoginServise;
import org.tms.services.QaseProjectsServise;

@Log4j2
public class QaseDeletePublicProjectsTest extends BaseTest{

    private QaseProjectsServise qaseProjectsServise;

    @BeforeClass
    public void openProjectsPageTest(){
        QaseLoginServise qaseLoginServise = new QaseLoginServise();
        qaseProjectsServise = new QaseProjectsServise();
        qaseLoginServise.loginOnQaseMainPageWithValidData();
    }

    @Test
    public void deletePublicProjectTest(){
        qaseProjectsServise.deletePublicProject();
        log.info("Public project deleted");
        Assert.assertTrue(qaseProjectsServise.displayedPublicProjectsOnProjectsPage(), "Public project didn't delete");
    }

}


