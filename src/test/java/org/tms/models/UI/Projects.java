package org.tms.models.UI;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Projects {

    private String nameProject;
    private String codeProject;
    private String descriptionProject;


}
