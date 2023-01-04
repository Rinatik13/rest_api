package com.calisto.spring.rest_api.DaO.owner;

import com.calisto.spring.rest_api.entity.owners.Owner;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class OwnerDaOImpl implements OwnerDaO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Owner> getAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Owner> ownerQuery = session.createQuery("from Owner",
                Owner.class);
        return ownerQuery.getResultList();
    }

    @Override
    public Owner add(Owner owner) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(owner);
        return owner;
    }

    @Override
    public Owner getOwner(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Owner.class,id);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Owner owner = session.get(Owner.class,id);
        session.delete(owner);
    }
//
//    @Override
//    public MainOwner addMainOwner(MainOwner owner) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(owner);
//        return owner;
//    }
//
//    @Override
//    public List<MainOwner> getAllMainOwner() {
//        Session session = entityManager.unwrap(Session.class);
//        Query<MainOwner> ownerQuery = session.createQuery("from MainOwner",
//                MainOwner.class);
//        return ownerQuery.getResultList();
//    }
//
//    @Override
//    public MainOwner getMainOwner(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        return session.get(MainOwner.class,id);
//    }
//
//    @Override
//    public void deleteMainOwner(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        MainOwner owner = session.get(MainOwner.class,id);
//        session.delete(owner);
//    }
//
//    @Override
//    public MainOwner editMineOwner(MainOwner owner) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(owner);
//        return owner;
//    }
}
