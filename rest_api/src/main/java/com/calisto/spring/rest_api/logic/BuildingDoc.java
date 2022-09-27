package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
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

        // создаём документы для сохранения в архив

        for (GeneratorDoc doc : generatorDocList){
            addZipEntry(zip, doc, company, tender,date,summ);
        }

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
}
