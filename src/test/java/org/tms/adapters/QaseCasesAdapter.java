package org.tms.adapters;

import io.qameta.allure.Step;
import org.tms.models.API.Cases;

import static org.tms.utils.StringConstant.CASE_API_ENDPOINT;
import static org.tms.utils.StringConstant.STATUS_NAME;

public class QaseCasesAdapter extends BaseAdapter{

    @Step("Create case")
    public Boolean createCase(String projectCode, Cases casesValue){
        return post(String.format(CASE_API_ENDPOINT,projectCode),converter.toJson(casesValue)).body().path(STATUS_NAME);
    }

}


