package com.calisto.spring.rest_api.forms.rosneft;

import com.calisto.spring.rest_api.TestCompany;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.entity.Tender;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TestStreamDocument {
    public void launch() throws IOException, InterruptedException {
        ControllerCommunication communication = new ControllerCommunication();
        String url = communication.getUploadFile("docs.zip").getHref();
        System.out.println(url);
        PdfWriter pdfWriter = null;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pdfWriter = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        Paragraph paragraph = new Paragraph("123");
        document.add(paragraph);
        document.close();

        ByteArrayOutputStream zipStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(zipStream);
        ZipEntry zipEntry = new ZipEntry("test/123.pdf");
        zip.putNextEntry(zipEntry);
        zip.write(byteArrayOutputStream.toByteArray());

        TestCompany testCompany = new TestCompany();

        Tender tender = new Tender();
        tender.setName("Новый тендер");
        tender.setNumber("РН202124");


//        GeneratorDocForm17TableStream generatorDocForm17TableStream = new GeneratorDocForm17TableStream();
//        ByteArrayOutputStream streamDoc17 = generatorDocForm17TableStream.launch(testCompany.getCompany(),null,tender, 200000);

//        ZipOutputStream zip2 = new ZipOutputStream(streamDoc17);
        ZipEntry zipEntry2 = new ZipEntry("test/doc17.pdf");
        zip.putNextEntry(zipEntry2);
//        zip.write(streamDoc17.toByteArray());
        zip.close();



        communication.uploadFileByte(url,"PUT", zipStream.toByteArray());

    }

}
