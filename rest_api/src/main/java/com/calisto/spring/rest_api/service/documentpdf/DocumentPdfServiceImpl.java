package com.calisto.spring.rest_api.service.documentpdf;

import com.calisto.spring.rest_api.DaO.company.CompanyDaO;
import com.calisto.spring.rest_api.DaO.documentpdf.DocumentPdfDaO;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.DocumentPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URL;
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
        System.out.println(body);

        Company company = new Company();

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
        }
        documentPdf.setBody(body);
        documentPdf.setAddress(address);
        documentPdfDaO.add(documentPdf);
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
