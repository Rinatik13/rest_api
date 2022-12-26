package com.calisto.spring.rest_api.service.owner;

import com.calisto.spring.rest_api.DaO.owner.OwnerDaO;
import com.calisto.spring.rest_api.entity.owners.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService{
    @Autowired
    OwnerDaO ownerDaO;
    @Override
    @Transactional
    public List<Owner> getAll() {
        return ownerDaO.getAll();
    }

    @Override
    @Transactional
    public Owner add(Owner owner) {
        ownerDaO.add(owner);
        return owner;
    }

    @Override
    @Transactional
    public Owner getOwner(int id) {
        return ownerDaO.getOwner(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        ownerDaO.delete(id);
    }

    @Override
    @Transactional
    public Owner editOwner(Owner owner) {
        return ownerDaO.add(owner);
    }
}
