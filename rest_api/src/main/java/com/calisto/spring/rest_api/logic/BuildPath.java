package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import com.calisto.spring.rest_api.entity.Company;


import java.util.ArrayList;
import java.util.List;

public class BuildPath {

    public static void buildCompanyPath(Company company) {
        ControllerCommunication controller = new ControllerCommunication();
        String companyPath = "user_" + company.getUser_id() + "/company_" + company.getId();
        List<String> lists = new ArrayList<>();
        List<Link> linkList = null;
        linkList = controller.createFolder(companyPath, null);
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

//                Thread.sleep(2000);}
            linkList = myController.createFolder(addres,companyPath);
        }
    }

}
