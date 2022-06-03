package org.tms.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    public DataProviders() {
    }

    @DataProvider(name = "SuiteData")
    public static Object[][] suiteNames() {
        return new Object[][]{
                {"DEMO-2.SuitePublic"},
                {"DEMO-3.SuitePublic"},
                {"DEMO-4.SuitePublic"}
        };
    }

    @DataProvider(name = "CaseData")
    public static Object[][] caseNames() {
        return new Object[][]{
                {"DEMO-2.CasePublic"},
                {"DEMO-3.CasePublic"},
                {"DEMO-4.CasePublic"}
        };
    }
}


