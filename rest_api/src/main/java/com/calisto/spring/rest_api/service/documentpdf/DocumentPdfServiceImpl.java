package com.calisto.spring.rest_api.service.documentpdf;

import com.calisto.spring.rest_api.DaO.company.CompanyDaO;
import com.calisto.spring.rest_api.DaO.documentpdf.DocumentPdfDaO;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.entity.*;
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
                List<Employee> employees = company.getEmployeeList();
                int idListPosition = 0;
                for (int i = 0; i<employees.size();i++){
                    if (employees.get(i).getId()==blockId){
                        idListPosition=i;
                    }
                }
                company.getEmployeeList().get(idListPosition).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "all_docs": {
                company.getDocumentPdfList().add(documentPdf);
                break;
            }
            case "akkredit": {
                List<Akkredit> akkredits = company.getAkkreditList();
                int idListPosition = 0;
                for (int i = 0; i<akkredits.size();i++){
                    if (akkredits.get(i).getId()==blockId){
                        idListPosition=i;
                    }
                }
                company.getAkkreditList().get(idListPosition).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "buhdocuments": {
                List<Buhdocument> buhdocuments = company.getBuhdocumentList();
                int idListPosition = 0;
                for (int i = 0; i<buhdocuments.size();i++){
                    if (buhdocuments.get(i).getId()==blockId){
                        idListPosition=i;
                    }
                }
                company.getBuhdocumentList().get(idListPosition).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "contracts": {
                List<Contract> contracts = company.getContractList();
                int idListPosition = 0;
                for (int i = 0; i<contracts.size();i++){
                    if (contracts.get(i).getId()==blockId){
                        idListPosition=i;
                    }
                }
                company.getContractList().get(idListPosition).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "licenses": {
                List<License> licenses = company.getLicenseList();
                int idListPosition = 0;
                for (int i = 0; i<licenses.size();i++){
                    if (licenses.get(i).getId()==blockId){
                        idListPosition=i;
                    }
                }
                company.getLicenseList().get(idListPosition).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "oborudovanies": {
                List<Oborudovanie> oborudovanies = company.getOborudovanieList();
                int idListPosition = 0;
                for (int i = 0; i<oborudovanies.size();i++){
                    if (oborudovanies.get(i).getId()==blockId){
                        idListPosition=i;
                    }
                }
                company.getOborudovanieList().get(idListPosition).getDocumentPdfList().add(documentPdf);
                break;
            }
            case "prodacts": {
                List<Prodact> prodacts = company.getProdactList();
                int idListPosition = 0;
                for (int i = 0; i<prodacts.size();i++){
                    if (prodacts.get(i).getId()==blockId){
                        idListPosition=i;
                    }
                }
                company.getProdactList().get(idListPosition).getDocumentPdfList().add(documentPdf);
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
