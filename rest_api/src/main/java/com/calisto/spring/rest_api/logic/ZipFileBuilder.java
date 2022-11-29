package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.communication.ApiDiskYandex.LoadDocumentToZip;
import com.calisto.spring.rest_api.entity.DocumentPdf;
import com.calisto.spring.rest_api.entity.Tender;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileBuilder implements Runnable{
    private final Object lock = new Object();
    private DocumentPdf documentPdf;
    private Tender tender;
    private ZipOutputStream zip;

    public ZipFileBuilder(DocumentPdf documentPdf, Tender tender,ZipOutputStream zip) {
        this.documentPdf = documentPdf;
        this.tender = tender;
        this.zip = zip;
    }

    private void addZipEntryDocumentCopy() {
        synchronized (lock){
            LoadDocumentToZip loadDocumentToZip = new LoadDocumentToZip();
            String address = documentPdf.getAddress() + "/" + documentPdf.getName() + ".pdf";
            ByteArrayOutputStream streamDoc = loadDocumentToZip.getLoadDocument(address);
            ZipEntry zipEntry = new ZipEntry(tender.getId() +
                    "/Квалификационная часть/" +
                    documentPdf.getName() +
                    ".pdf");
            try {
                zip.putNextEntry(zipEntry);
                zip.write(streamDoc.toByteArray());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        addZipEntryDocumentCopy();
    }
}
