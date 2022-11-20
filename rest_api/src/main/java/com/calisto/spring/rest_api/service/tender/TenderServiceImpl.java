package com.calisto.spring.rest_api.service.tender;

import com.calisto.spring.rest_api.DaO.company.CompanyDaO;
import com.calisto.spring.rest_api.DaO.tender.TenderDaO;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.logic.BuildingDoc;
import com.calisto.spring.rest_api.logic.filecontroller.NoFileController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
@Service
public class TenderServiceImpl implements TenderService{
    @Autowired
    TenderDaO tenderDaO;

    @Autowired
    NoFileController noFileController;

    @Autowired
    CompanyDaO companyDaO;

    @Override
    @Transactional
    public List<Tender> getAll() {
        return tenderDaO.getAll();
    }

    @Override
    @Transactional
    public Tender add(Tender tender) {
        tenderDaO.add(tender);
        return tender;
    }

    @Override
    @Transactional
    public Tender getTender(int id) {
        return tenderDaO.getTender(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        tenderDaO.delete(id);
    }

    @Override
    @Transactional
    public Link getLink(int id) throws IOException {
        System.out.println("запрос пришёл");
        Tender tender = tenderDaO.getTender(id);
        Company company = companyDaO.getCompany(tender.getCompany_id());
        System.out.println("сборка архива");
        BuildingDoc buildingDoc = new BuildingDoc();
        // надо от-куда то взять дату и сумму
        System.out.println("отправляем ответ");
        Link link = buildingDoc.build(company,tender,"24.09.2022",200000);

        // тестовый запуск потока для удаления файла
        noFileController.setAddressFile("user_5/company_17/1.pdf");
        noFileController.start();
        return link;
    }
}
