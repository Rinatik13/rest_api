package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.entity.DocumentPdf;
import org.junit.Test;

import static org.junit.Assert.*;

public class CopyDocumentTest extends CopyDocument {

    @Test
    public void testCopyDoc() {
        DocumentPdf doc = new DocumentPdf();
        doc.setName("Документ");
        doc.setAddress("C:\\java\\blank\\mypdf.pdf");
        String address = "C:\\java\\test2";
        copyDoc(doc,address);
    }
}