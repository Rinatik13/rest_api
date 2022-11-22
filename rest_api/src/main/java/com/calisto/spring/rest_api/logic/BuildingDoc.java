package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.RestApiApplication;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.LoadDocumentToZip;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import com.calisto.spring.rest_api.entity.*;
import com.calisto.spring.rest_api.forms.obshie_spravki.GeneratorSpravok;
import com.calisto.spring.rest_api.forms.obshie_spravki.ListSpravok;
import com.calisto.spring.rest_api.forms.obshie_spravki.SpravkaDoc;
import com.calisto.spring.rest_api.forms.rosneft.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class BuildingDoc {

    private static final Logger log = Logger.getLogger(BuildingDoc.class);

    @Autowired
    CopyDocument copyDoc;

    @Autowired
    GeneratorDoc generatorDoc;

    @Autowired
    SpravkaDoc spravkaDoc;

    public Link build(Company company, Tender tender, String date, double summ) throws IOException {
        ControllerCommunication controllerCommunication = new ControllerCommunication();
        // сохраняем адрес архива
        String addressZip = "user_" + company.getUser_id() + "/company_" + company.getId() +"/"
                + "tenderId_" + tender.getId() + ".zip";
        // получаем ссылку для загрузки архива
        log.info("создаём архив по адресу: " + addressZip);
        String url = controllerCommunication.getUploadFile(addressZip).getHref();

        // создаём общий поток для создания архива
        ByteArrayOutputStream zipStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(zipStream);

        List<GeneratorDoc> generatorDocList = new ArrayList<>();
        generatorDocList.add(new GeneratorDocForm1a());
        generatorDocList.add(new GeneratorDocForm2());
        generatorDocList.add(new GeneratorDocForm3());
        generatorDocList.add(new GeneratorDocForm4());
        generatorDocList.add(new GeneratorDocForm5());
        generatorDocList.add(new GeneratorDocForm6());
        generatorDocList.add(new GeneratorDocForm7());
        generatorDocList.add(new GeneratorDocForm8());
        generatorDocList.add(new GeneratorDocForm9());
        generatorDocList.add(new GeneratorDocForm10());
        generatorDocList.add(new GeneratorDocForm11());
        generatorDocList.add(new GeneratorDocForm15());
        generatorDocList.add(new GeneratorDocForm16());
        generatorDocList.add(new GeneratorDocForm17());
        generatorDocList.add(new GeneratorDocForm17Table());

        List<String[]> listSpravok = ListSpravok.getListSpravok(company,tender);
        // добавляем в лист справки
        for (int a = 0; a < listSpravok.size(); a++){
            String[] text = new String[3];
            text = listSpravok.get(a);
            log.info("создаём файл: " + text[0]);
            SpravkaDoc doc = new GeneratorSpravok();
            doc.setNumDoc(a+1);
            doc.setNameDoc(text[0]);
            doc.setBodyDocCompany(text[2]);
            generatorDocList.add(doc);
        }
        log.info("запускаем скачиваение файлов с яндекс диска");
        // добавляем цикл скачивания всех документов в архив
        List<DocumentPdf> documentPdfList = new ArrayList<>();
        documentPdfList.addAll(company.getDocumentPdfList());

        List<Buhdocument> buhdocuments = company.getBuhdocumentList();

        for (Buhdocument buhdocument : buhdocuments){
            List<DocumentPdf> documentPdfs = buhdocument.getDocumentPdfList();
            for (DocumentPdf documentPdf:documentPdfs){
                documentPdfList.add(documentPdf);
            }
        }

        List<Akkredit> akkredits = company.getAkkreditList();

        for (Akkredit akkredit : akkredits){
            List<DocumentPdf> documentPdfs = akkredit.getDocumentPdfList();
            for (DocumentPdf documentPdf:documentPdfs){
                documentPdfList.add(documentPdf);
            }
        }

        List<Contract> contracts = company.getContractList();

        for (Contract contract:contracts){
            List<DocumentPdf> documentPdfs = contract.getDocumentPdfList();
            for (DocumentPdf documentPdf:documentPdfs){
                documentPdfList.add(documentPdf);
            }
        }

        List<Employee> employees = company.getEmployeeList();
        for (Employee employee : employees){
            List<DocumentPdf> documentPdfs = employee.getDocumentPdfList();
            for (DocumentPdf documentPdf:documentPdfs){
                documentPdfList.add(documentPdf);
            }
        }

        List<License> licenses = company.getLicenseList();
        for (License license:licenses){
            List<DocumentPdf> documentPdfs = license.getDocumentPdfList();
            for (DocumentPdf documentPdf:documentPdfs){
                documentPdfList.add(documentPdf);
            }
        }

        List<Oborudovanie> oborudovanies = company.getOborudovanieList();
        for (Oborudovanie oborudovanie:oborudovanies){
            List<DocumentPdf> documentPdfs = oborudovanie.getDocumentPdfList();
            for (DocumentPdf documentPdf:documentPdfs){
                documentPdfList.add(documentPdf);
            }
        }

        List<Prodact> prodacts = company.getProdactList();
        for (Prodact prodact:prodacts){
            List<DocumentPdf> documentPdfs = prodact.getDocumentPdfList();
            for (DocumentPdf documentPdf:documentPdfs){
                documentPdfList.add(documentPdf);
            }
        }

        for (DocumentPdf documentPdf : documentPdfList) {
            addZipEntryDocumentCopy(zip, documentPdf, tender);
        }

        // создаём документы для сохранения в архив

        for (GeneratorDoc doc : generatorDocList){
            addZipEntry(zip, doc, company, tender,date,summ);
            log.info("добавляем файл: " + doc.getNameFile());
        }
        // закрываем создание архива
        zip.close();

        // загружаем созданный архив на сервер яндекс диска
        controllerCommunication.uploadFileByte(url,"PUT", zipStream.toByteArray());
        log.info("получаем link для скачивания файла: " + addressZip);
        // получаем ссылку на скачивание заархивированного пакета документов
        ControllerCommunication communication = new ControllerCommunication();
        Link link = null;
        try{
            link = communication.getDownFile(addressZip);
        } catch (Exception e){
            log.error("ошибка с получением link адреса: " + addressZip + " \n сама ошибка: " + e.toString());
        }
        return link;
    }

    private void addZipEntry(ZipOutputStream zip, GeneratorDoc generatorDoc, Company company, Tender tender, String date, double summ) {
        GeneratorDoc doc = generatorDoc;
        log.info("создаём поток документа: " + generatorDoc.getNameFile());
        ByteArrayOutputStream streamDoc = doc.launch(company,tender,date,summ);
        ZipEntry zipEntry = new ZipEntry(tender.getId() + "/" + generatorDoc.getPath() + "/" + generatorDoc.getNameFile() +".pdf");
        try {
            zip.putNextEntry(zipEntry);
            zip.write(streamDoc.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addZipEntryDocumentCopy(ZipOutputStream zip, DocumentPdf documentPdf, Tender tender) {
        LoadDocumentToZip loadDocumentToZip = new LoadDocumentToZip();
        String address = documentPdf.getAddress() + "/" + documentPdf.getName() + ".pdf";
        log.info("добавляем файл с адресом: " + address);
        ByteArrayOutputStream streamDoc = loadDocumentToZip.getLoadDocument(address);
        ZipEntry zipEntry = new ZipEntry(tender.getId() + "/Квалификационная часть/" + documentPdf.getName() +".pdf");
        try {
            zip.putNextEntry(zipEntry);
            zip.write(streamDoc.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
