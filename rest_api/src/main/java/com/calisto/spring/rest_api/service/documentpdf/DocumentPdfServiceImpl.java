package com.calisto.spring.rest_api.service.documentpdf;

import com.calisto.spring.rest_api.DaO.documentpdf.DocumentPdfDaO;
import com.calisto.spring.rest_api.communication.ApiDiskYandex.ControllerCommunication;
import com.calisto.spring.rest_api.entity.DocumentPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URL;
import java.util.List;

@Service
public class DocumentPdfServiceImpl implements DocumentPdfService{
    @Autowired
    DocumentPdfDaO documentPdfDaO;

    @Override
    @Transactional
    public List<DocumentPdf> getAll() {
        return documentPdfDaO.getAll();
    }

    @Override
    @Transactional
    public DocumentPdf add(DocumentPdf documentPdf) {
        String body = documentPdf.getBody();
        System.out.println(body);
        ControllerCommunication controller = new ControllerCommunication();
        documentPdfDaO.add(documentPdf);
        System.out.println(documentPdf);
        String url = controller.getUploadFile("123.pdf").getHref();
        controller.uploadFile(url,"PUT", body);
        documentPdf.setBody(body);
        return documentPdf;
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
