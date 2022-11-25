package com.calisto.spring.rest_api.DaO.documentpdf;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.controller.UserController;
import com.calisto.spring.rest_api.entity.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DocumentPdfDaOImpl implements DocumentPdfDaO{
    private static final Logger log = Logger.getLogger(DocumentPdfDaOImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<DocumentPdf> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<DocumentPdf> documentPdfQuery = session.createQuery("from DocumentPdf",
                DocumentPdf.class);
        return documentPdfQuery.getResultList();
    }

    @Override
    public DocumentPdf add(DocumentPdf documentPdf) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(documentPdf);
        log.info("добавление файла в бд с id: " + documentPdf.getId());
        return documentPdf;
    }

    @Override
    public DocumentPdf getDocumentPdf(int id) {
        Session session = entityManager.unwrap(Session.class);
        log.info("загрузка файла из бд с id: " + id);
        return session.get(DocumentPdf.class,id);

    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        DocumentPdf documentPdf = session.get(DocumentPdf.class,id);
        deleteBlock(documentPdf);

        log.info("удаление файла из бд с id: " + id);
        session.delete(documentPdf);
    }

    private void deleteBlock(DocumentPdf documentPdf) {
        ControllerCommunication communication = new ControllerCommunication();
        String address = documentPdf.getAddress() + "/" + documentPdf.getName() + ".pdf";
        Session session = entityManager.unwrap(Session.class);
        Company company = session.get(Company.class,documentPdf.getCompany_id());
        int blockId = documentPdf.getId();

        switch (documentPdf.getBlock()){
            case "employees": {
                List<Employee> employees = company.getEmployeeList();
                for (int i = 0; i<employees.size();i++){
                    if (employees.get(i).getId()==blockId){
                        Employee employee = company.getEmployeeList().get(i);
                        List<DocumentPdf> documentPdfs = employee.getDocumentPdfList();
                        for (int a = 0; a<documentPdfs.size();a++){
                            if (documentPdfs.get(a).getId()==documentPdf.getId()){
                                company.getEmployeeList().get(i).getDocumentPdfList().remove(a);
                                communication.delete(address);
                                break;
                            }
                        }
                    }
                }
                break;
            }
            case "all_docs": {
                company.getDocumentPdfList().remove(documentPdf);
                communication.delete(address);
                break;
            }
            case "akkredit": {
                List<Akkredit> akkredits = company.getAkkreditList();
                for (int i = 0; i<akkredits.size();i++){
                    if (akkredits.get(i).getId()==blockId){
                        Akkredit akkredit = company.getAkkreditList().get(i);
                        List<DocumentPdf> documentPdfs = akkredit.getDocumentPdfList();
                        for (int a = 0; a<documentPdfs.size();a++){
                            if (documentPdfs.get(a).getId()==documentPdf.getId()){
                                company.getAkkreditList().get(i).getDocumentPdfList().remove(a);
                                communication.delete(address);
                                break;
                            }
                        }
                    }
                }
                break;
            }
            case "buhdocuments": {
                List<Buhdocument> buhdocuments = company.getBuhdocumentList();
                for (int i = 0; i<buhdocuments.size();i++){
                    if (buhdocuments.get(i).getId()==blockId){
                        Buhdocument buhdocument = company.getBuhdocumentList().get(i);
                        List<DocumentPdf> documentPdfs = buhdocument.getDocumentPdfList();
                        for (int a = 0; a<documentPdfs.size();a++){
                            if (documentPdfs.get(a).getId()==documentPdf.getId()){
                                company.getBuhdocumentList().get(i).getDocumentPdfList().remove(a);
                                communication.delete(address);
                                break;
                            }
                        }
                    }
                }
                break;
            }
            case "contracts": {
                List<Contract> contracts = company.getContractList();
                for (int i = 0; i<contracts.size();i++){
                    if (contracts.get(i).getId()==blockId){
                        Contract contract = company.getContractList().get(i);
                        List<DocumentPdf> documentPdfs = contract.getDocumentPdfList();
                        for (int a = 0; a<documentPdfs.size();a++){
                            if (documentPdfs.get(a).getId()==documentPdf.getId()){
                                company.getContractList().get(i).getDocumentPdfList().remove(a);
                                communication.delete(address);
                                break;
                            }
                        }
                    }
                }
                break;
            }
            case "licenses": {
                List<License> licenses = company.getLicenseList();
                for (int i = 0; i<licenses.size();i++){
                    if (licenses.get(i).getId()==blockId){
                        License license = company.getLicenseList().get(i);
                        List<DocumentPdf> documentPdfs = license.getDocumentPdfList();
                        for (int a = 0; a<documentPdfs.size();a++){
                            if (documentPdfs.get(a).getId()==documentPdf.getId()){
                                company.getLicenseList().get(i).getDocumentPdfList().remove(a);
                                communication.delete(address);
                                break;
                            }
                        }
                    }
                }
                break;
            }
            case "oborudovanies": {
                List<Oborudovanie> oborudovanies = company.getOborudovanieList();
                for (int i = 0; i<oborudovanies.size();i++){
                    if (oborudovanies.get(i).getId()==blockId){
                        Oborudovanie oborudovanie = company.getOborudovanieList().get(i);
                        List<DocumentPdf> documentPdfs = oborudovanie.getDocumentPdfList();
                        for (int a = 0; a<documentPdfs.size();a++){
                            if (documentPdfs.get(a).getId()==documentPdf.getId()){
                                company.getOborudovanieList().get(i).getDocumentPdfList().remove(a);
                                communication.delete(address);
                                break;
                            }
                        }
                    }
                }
                break;
            }
            case "prodacts": {
                List<Prodact> prodacts = company.getProdactList();
                for (int i = 0; i<prodacts.size();i++){
                    if (prodacts.get(i).getId()==blockId){
                        Prodact prodact = company.getProdactList().get(i);
                        List<DocumentPdf> documentPdfs = prodact.getDocumentPdfList();
                        for (int a = 0; a<documentPdfs.size();a++){
                            if (documentPdfs.get(a).getId()==documentPdf.getId()){
                                company.getProdactList().get(i).getDocumentPdfList().remove(a);
                                communication.delete(address);
                                break;
                            }
                        }
                    }
                }
                break;
            }
            case "tenders": {

                break;
            }
            default:{

            }
        }

    }
}
