package org.tms.adapters;

import io.qameta.allure.Step;
import org.tms.models.API.Suite;

import static org.tms.utils.StringConstant.STATUS_NAME;
import static org.tms.utils.StringConstant.SUITE_API_ENDPOINT;


public class QaseSuitesAdapter extends BaseAdapter{

    @Step("Create suite")
    public Boolean createSuite(String projectCode, Suite suiteValue){
        return post(String.format(SUITE_API_ENDPOINT,projectCode),converter.toJson(suiteValue)).body().path(STATUS_NAME);
    }

}

