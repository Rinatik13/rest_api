package com.calisto.spring.rest_api.DaO.documentpdf;

import com.calisto.spring.rest_api.controller.UserController;
import com.calisto.spring.rest_api.entity.DocumentPdf;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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
        log.info("удаление файла из бд с id: " + id);
        session.delete(documentPdf);
    }
}
