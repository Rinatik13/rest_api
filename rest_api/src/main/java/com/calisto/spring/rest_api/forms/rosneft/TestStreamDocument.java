package com.calisto.spring.rest_api.forms.rosneft;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfStream;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.*;

public class TestStreamDocument {
    public void launch(){
        ControllerCommunication communication = new ControllerCommunication();
        String url = communication.getUploadFile("123.pdf").getHref();
        System.out.println(url);
        PdfWriter pdfWriter = null;
        PdfStream pdfStream = new PdfStream();

        try {

            pdfWriter = new PdfWriter("name");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        Paragraph paragraph = new Paragraph("123");
        document.add(paragraph);
        document.close();
        communication.uploadFile(url,"PUT","");
    }
}
