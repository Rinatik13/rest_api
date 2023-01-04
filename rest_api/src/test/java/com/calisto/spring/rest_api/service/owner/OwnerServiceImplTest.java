package com.calisto.spring.rest_api.service.owner;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.owners.Owner;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OwnerServiceImplTest{

    @Test
    public void addNewOwner() {
        Company company = new Company();
        List<Owner> mainOwners = new ArrayList<>();

        Owner owner1 = new Owner();
        owner1.setId(1);
        Owner owner2 = new Owner();
        owner2.setId(2);
        Owner owner3 = new Owner();
        owner3.setId(3);
        Owner owner4 = new Owner();
        owner4.setId(4);
        Owner owner5 = new Owner();
        owner5.setId(5);

        List<Owner> owners1 = new ArrayList<>();
        owners1.add(owner3);
        owners1.add(owner4);
        owner1.setOwners(owners1);

        List<Owner> owners2 = new ArrayList<>();
        owners2.add(owner5);
        owner2.setOwners(owners2);

        mainOwners.add(owner1);
        mainOwners.add(owner2);
        company.setOwners(mainOwners);

        Owner owner = new Owner();
        owner.setId(6);
        owner.setMain_owner_id(6);

        OwnerServiceImpl ownerService = new OwnerServiceImpl();
        ownerService.company=company;
        ownerService.owner=owner;
        ownerService.addNewOwner();
    }
}