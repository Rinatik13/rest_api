package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import com.calisto.spring.rest_api.entity.Akkredit;
import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.User;


import java.util.ArrayList;
import java.util.List;

public class BuildPath {

    public static void buildUserPath(User user){
        String address = "user_" + user.getId();
        ControllerCommunication communication = new ControllerCommunication();
        communication.createFolder(address,null);

    }

    public static void buildCompanyPath(Company company) {
        ControllerCommunication controller = new ControllerCommunication();
        String userPath = "user_" + company.getUser_id();
        String companyPath = "company_" + company.getId();
        String fullCompanyPath = "user_" + company.getUser_id() + "/company_" + company.getId();
        List<String> lists = new ArrayList<>();
        List<Link> linkList = null;
        linkList = controller.createFolder(companyPath, userPath);
        lists.add("employees");
        lists.add("all_docs");
        lists.add("akkredit");
        lists.add("buhdocuments");
        lists.add("contracts");
        lists.add("licenses");
        lists.add("oborudovanies");
        lists.add("prodacts");
        for (String addres : lists){
            ControllerCommunication myController = new ControllerCommunication();
            linkList = myController.createFolder(addres,fullCompanyPath);
        }
    }

}
