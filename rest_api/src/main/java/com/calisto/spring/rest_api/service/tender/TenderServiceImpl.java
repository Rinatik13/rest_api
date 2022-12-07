package com.calisto.spring.rest_api.service.tender;

import com.calisto.spring.rest_api.DaO.company.CompanyDaO;
import com.calisto.spring.rest_api.DaO.tender.TenderDaO;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import com.calisto.spring.rest_api.controller.TenderController;
import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.logic.BuildingDoc;
import com.calisto.spring.rest_api.logic.filecontroller.NoFileController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
@Service
public class TenderServiceImpl implements TenderService{
    private static final Logger log = Logger.getLogger(TenderServiceImpl.class);
    @Autowired
    TenderDaO tenderDaO;

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
        Tender tender = tenderDaO.getTender(id);
        Company company = companyDaO.getCompany(tender.getCompany_id());
        BuildingDoc buildingDoc = new BuildingDoc();
        // надо от-куда то взять дату и сумму
        Link link = buildingDoc.build(company,tender,"24.09.2022",200000);

        // тестовый запуск потока для удаления файла
        // при большом количестве запросов всё летит в тартараты.
        // по какойто причине выходит ошибка потока!!!
        // надо исправить эту херню. без неё будет тяжко.
        NoFileController noFileController = new NoFileController();
        noFileController.setAddressFile("user_" + company.getUser_id() + "/company_" + company.getId() +
                "/tender" + tender.getNumber() + ".zip");
        noFileController.start();
        log.info("************************************************************************************\n");
        log.info("ЗАКОНЧИЛИ ПОДГОТОВКУ ПАКЕТА ДОКУМЕНТОВ ПО ТЕНДЕРУ ID №" + tender.getId());
        return link;
    }
}
