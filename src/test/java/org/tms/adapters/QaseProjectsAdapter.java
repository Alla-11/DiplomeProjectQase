package org.tms.adapters;

import com.google.gson.Gson;
import io.qameta.allure.Step;
import org.tms.models.API.Project;
import org.tms.models.API.ProjectResponse;

import static org.tms.utils.StringConstant.*;

public class QaseProjectsAdapter extends BaseAdapter{

    @Step("Create project")
    public String createProject(Project project){
        return post(PROJECT_API_ENDPOINT,converter.toJson(project)).body().path(CODE_RESULT);
    }

    @Step("Delete project")
    public String deleteProject (String projectCode){
        return delete(String.format(NUMBER_PROJECT_API_ENDPOINT,projectCode));
    }

    @Step("Get value of status")
    public Boolean getStatus(String body) {
        ProjectResponse project = new Gson().fromJson(body, ProjectResponse.class);
        Boolean status = project.getStatus();
        return status;
    }

}

