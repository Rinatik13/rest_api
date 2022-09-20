package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.TestCompany;
import com.calisto.spring.rest_api.entity.*;
import org.junit.Test;

public class BuildPathTest {
    @Test
    public void buildPathTest(){
        TestCompany testCompany = new TestCompany();
        Company company = testCompany.getCompany();

        BuildPath.buildCompanyPath(company);
    }
}
