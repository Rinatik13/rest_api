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

        String address = null;
        ControllerCommunication controller = new ControllerCommunication();
        System.out.println("Загрузка файла размером: " + body.length());

        Company company;

        // Вытаскиваем данные по id компании / блоку / id блока
        int companyId = documentPdf.getCompany_id();
        String blockCompany = documentPdf.getBlock();
        int blockId = documentPdf.getBlock_id();

        // создаём объект компания с актуальными данными на компанию
        company = companyDaO.getCompany(companyId);
        address = "user_" + company.getUser_id() + "/company_" + company.getId() + "/" + documentPdf.getBlock();
        documentPdf.setAddress(address);
        // проверяем какой блок
        company = companyAddNewDocument(company,documentPdf,blockCompany, blockId);

        // сохраняем файл по адресу
        // если файл имеет адрес компании(уставные документы и прочее)

//        documentPdf.setBody(body);
//        documentPdf.setAddress(address);
////        documentPdfDaO.add(documentPdf);
//        //добавили такое решение, вносим изменения в саму компанию.
//        company.getDocumentPdfList().add(documentPdf);
        companyDaO.add(company);
        String url = controller.getUploadFile(address + "/" + documentPdf.getName() + ".pdf")
                .getHref();
        controller.uploadFile(url,"PUT", body);

        return documentPdf;
    }

    private Company companyAddNewDocument(Company company, DocumentPdf documentPdf, String nameBlock, int blockId) {
        switch (nameBlock){
            case "employees": {
                company.getEmployeeList().get(blockId).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "all_docs": {
                company.getDocumentPdfList().add(documentPdf);
                break;
            }
            case "akkredit": {
                company.getAkkreditList().get(blockId).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "buhdocuments": {
                company.getBuhdocumentList().get(blockId).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "contracts": {
                company.getContractList().get(blockId).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "licenses": {
                company.getLicenseList().get(blockId).getDocumentPdfList().add(documentPdf);
                break;
            }case "oborudovanies": {
                company.getOborudovanieList().get(blockId).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "prodacts": {
                company.getProdactList().get(blockId).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "tenders": {

                break;
            }
            case "signatureStamp": {

                break;
            }
            default:{

            }
        }
        return company;
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
