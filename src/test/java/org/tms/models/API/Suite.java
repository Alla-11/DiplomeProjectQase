package org.tms.models.API;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
    private String title;
    private String description;
    private String precondition;
    @SerializedName("parent_id")
    private Integer parentId;

}
