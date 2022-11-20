package com.calisto.spring.rest_api.DaO.signatureStamp;

import com.calisto.spring.rest_api.entity.Image_jpg;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SignatureStampDaOImpl implements SignatureStampDaO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Image_jpg> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Image_jpg> imageJPGQuery = session.createQuery("from Image_jpg",
                Image_jpg.class);
        return imageJPGQuery.getResultList();
    }

    @Override
    public Image_jpg add(Image_jpg imageJpg) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(imageJpg);
        return imageJpg;
    }

    @Override
    public Image_jpg getImageJPG(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Image_jpg.class,id);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Image_jpg imageJpg = session.get(Image_jpg.class,id);
        session.delete(imageJpg);
    }
}
