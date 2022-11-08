package com.calisto.spring.rest_api.service.documentpdf;

import com.calisto.spring.rest_api.DaO.company.CompanyDaO;
import com.calisto.spring.rest_api.DaO.documentpdf.DocumentPdfDaO;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.entity.Akkredit;
import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.DocumentPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DocumentPdfServiceImpl implements DocumentPdfService{
    @Autowired
    DocumentPdfDaO documentPdfDaO;

    @Autowired
    CompanyDaO companyDaO;

    @Override
    @Transactional
    public List<DocumentPdf> getAll() {
        return documentPdfDaO.getAll();
    }

    @Override
    @Transactional
    public DocumentPdf add(DocumentPdf documentPdf) {
        String body = documentPdf.getBody();
        String address = "";
        ControllerCommunication controller = new ControllerCommunication();
        System.out.println("Загрузка файла размером: " + body.length());

        Company company;

        // сохраняем файл по адресу
        // если файл имеет адрес компании(уставные документы и прочее)
        if (!documentPdf.getAddress().contains("/")){
            company = companyDaO.getCompany(Integer.parseInt(documentPdf.getAddress()));
            address = "user_" + company.getUser_id() + "/company_" + company.getId();

        }
        else {
            String [] addressPath = documentPdf.getAddress().split("/");
            company = companyDaO.getCompany(Integer.parseInt(addressPath[0]));
            address = "user_" + company.getUser_id() + "/company_" + company.getId() + "/" + addressPath[1];

            // добавить механизм добавления/прикрипления файла к тому или иному блоку в БД.

            // akkredit , buhdocuments , contracts , employees , licenses , oborudovanies , prodacts

            if ("akkredit".equals(addressPath[addressPath.length-1])){
//                Akkredit akkredit =
            }


        }
        documentPdf.setBody(body);
        documentPdf.setAddress(address);
//        documentPdfDaO.add(documentPdf);
        //добавили такое решение, вносим изменения в саму компанию.
        company.getDocumentPdfList().add(documentPdf);
        companyDaO.add(company);
        String url = controller.getUploadFile(address + "/" + documentPdf.getName() + ".pdf")
                .getHref();
        controller.uploadFile(url,"PUT", body);

        return documentPdf;
    }

    @Override
    @Transactional
    public DocumentPdf getDocumentPdf(int id) {
        return documentPdfDaO.getDocumentPdf(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        documentPdfDaO.delete(id);

    }
}
