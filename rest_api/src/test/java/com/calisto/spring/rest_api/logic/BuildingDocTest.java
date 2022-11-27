package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.TestCompany;
import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BuildingDocTest extends BuildingDoc {

    @Test
    public void testBuild() throws IOException {
        TestCompany testCompany = new TestCompany();
//        Company company = testCompany.getCompany();
        Tender tender = new Tender();
        tender.setName("Clear");
        tender.setNumber("1234");
        tender.setId(1);
//        build(company,tender,"24.09.2022",2000);
    }
}