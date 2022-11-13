package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.LoadDocumentToZip;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import com.calisto.spring.rest_api.entity.*;
import com.calisto.spring.rest_api.forms.obshie_spravki.GeneratorSpravok;
import com.calisto.spring.rest_api.forms.obshie_spravki.ListSpravok;
import com.calisto.spring.rest_api.forms.obshie_spravki.SpravkaDoc;
import com.calisto.spring.rest_api.forms.rosneft.*;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class BuildingDoc {
    @Autowired
    CopyDocument copyDoc;

    @Autowired
    GeneratorDoc generatorDoc;

    @Autowired
    SpravkaDoc spravkaDoc;

    public Link build(Company company, Tender tender, String date, double summ) throws IOException {
        ControllerCommunication controllerCommunication = new ControllerCommunication();
        // созраняем ардес архива
        String addressZip = "user_" + company.getUser_id() + "/company_" + company.getId() +"/"
                + "tenderId_" + tender.getId() + ".zip";
        // получаем ссылку для загрузки архива
        System.out.println("Создаём архив по адресу: "+ addressZip);
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
            System.out.println("Создаём поток документов: " + text[0]);
            SpravkaDoc doc = new GeneratorSpravok();
            doc.setNumDoc(a+1);
            doc.setNameDoc(text[0]);
            doc.setBodyDocCompany(text[2]);
            generatorDocList.add(doc);
        }
        System.out.println("Скачиваем файлы с яндекс диска");
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
        }
        // закрываем создание архива 
        zip.close();

        // загружаем созданный архив на сервер яндекс диска
        controllerCommunication.uploadFileByte(url,"PUT", zipStream.toByteArray());
        System.out.println("Начинаем получать Link для скачивания файла: " + addressZip);
        // получаем ссылку на скачивание заархивированного пакета документов
        ControllerCommunication communication = new ControllerCommunication();
        Link link = null;
        try{
            link = communication.getDownFile(addressZip);
            System.out.println(link);
        } catch (Exception e){
            System.out.println("Чёто какая то хуйня.");
            System.out.println(e);
        }
        return link;
    }

    private void addZipEntry(ZipOutputStream zip, GeneratorDoc generatorDoc, Company company, Tender tender, String date, double summ) {
        GeneratorDoc doc = generatorDoc;
        System.out.println("создаём поток документа: " + generatorDoc.getNameFile());
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
        System.out.println("Address: " + address );
        System.out.println("Создаём поток документа: " + documentPdf.getName());
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
