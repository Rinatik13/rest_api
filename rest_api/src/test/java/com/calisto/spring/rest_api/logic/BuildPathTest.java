package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.TestCompany;
import com.calisto.spring.rest_api.entity.*;
import org.junit.Test;

public class BuildPathTest extends BuildPath {
    @Test
    public void buildPathTest(){
        TestCompany testCompany = new TestCompany();
    }

    @Test
    public void testBuildUserPath() {
        User user = new User();
        user.setId(1);
        BuildPath.buildUserPath(user);
    }
}
