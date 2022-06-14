package org.tms.tests.API;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.adapters.QaseCasesAdapter;
import org.tms.adapters.QaseProjectsAdapter;
import org.tms.adapters.QaseSuitesAdapter;
import org.tms.models.API.Cases;
import org.tms.models.API.Project;
import org.tms.models.API.Suite;

import static org.tms.utils.StringConstant.*;

public class QaseAPITest {

    @Test(description = "Create new project")
    public void createProjectTest(){
        Project project = Project.builder()
                                 .title(namePublicProject)
                                 .code(codePublicProject)
                                 .description(descriptionPublicProject)
                                 .access(accessProject)
                                 .build();
        String actualCodeProject = new QaseProjectsAdapter().createProject(project);
        Assert.assertEquals(actualCodeProject, codePublicProject,"Public project not created");
    }

    @Test(description = "Delete project", dependsOnGroups = "InProject")
    public void deleteProjectTest(){
        Boolean actualStatusDeleteProject = new QaseProjectsAdapter().getStatus(new QaseProjectsAdapter().deleteProject(codePublicProject));
        Assert.assertTrue(actualStatusDeleteProject, "Public project not deleted");
    }

    @Test(description = "Create suite", dependsOnMethods = "createProjectTest", groups = "InProject")
    public void createSuiteTest(){
        Suite suite = Suite.builder()
                .title(namePublicSuite)
                .build();
        Boolean actualStatusCreateSuite = new QaseSuitesAdapter().createSuite(codePublicProject, suite);
        Assert.assertTrue(actualStatusCreateSuite, "Suite not created");
    }

    @Test (description = "Create case", dependsOnMethods = "createProjectTest", groups = "InProject")
    public void createCaseTest(){
        Cases oneCases = Cases.builder().title(namePublicCase).build();
        Boolean actualStatusCreateCase = new QaseCasesAdapter().createCase(codePublicProject, oneCases);
        Assert.assertTrue(actualStatusCreateCase, "Case not created");
    }

}


