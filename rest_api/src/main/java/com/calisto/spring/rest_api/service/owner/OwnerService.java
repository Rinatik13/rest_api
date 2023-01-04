package com.calisto.spring.rest_api.service.owner;

import com.calisto.spring.rest_api.entity.owners.Owner;

import java.util.List;

public interface OwnerService {
    public List<Owner> getAll();
    public Owner add(Owner owner);
    public Owner getOwner(int id);
    public void delete(int id);
    public Owner editOwner(Owner owner);
//    public MainOwner addMainOwner(MainOwner owner);
//    public List<MainOwner> getAllMainOwner();
//    public MainOwner getMainOwner(int id);
//    public void deleteMainOwner(int id);
//    public MainOwner editMineOwner(MainOwner owner);

}
