package com.calisto.spring.rest_api.DaO.owner;

import com.calisto.spring.rest_api.entity.owners.Owner;

import java.util.List;

public interface OwnerDaO {
    public List<Owner> getAll();

    public Owner add(Owner owner);

    public Owner getOwner(int id);

    public void delete(int id);
}
