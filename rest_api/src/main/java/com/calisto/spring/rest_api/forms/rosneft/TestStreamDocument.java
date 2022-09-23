package com.calisto.spring.rest_api.forms.rosneft;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.entity.Link;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.text.pdf.PdfEFStream;
import com.itextpdf.text.pdf.codec.Base64;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TestStreamDocument {
    public void launch() throws IOException, InterruptedException {
        ControllerCommunication communication = new ControllerCommunication();
        String url = communication.getUploadFile("1234.zip").getHref();
        System.out.println(url);
        PdfWriter pdfWriter = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pdfWriter = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        Paragraph paragraph = new Paragraph("123");
        document.add(paragraph);
        document.close();
        System.out.println(byteArrayOutputStream.toByteArray());
        ByteArrayOutputStream zipStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(zipStream);
        ZipEntry zipEntry = new ZipEntry("123.pdf");
        zip.putNextEntry(zipEntry);
        zip.write(byteArrayOutputStream.toByteArray());
        zip.close();

        communication.uploadFileByte(url,"PUT", zipStream.toByteArray());

    }

    public void douwland (String address){

    }
}
