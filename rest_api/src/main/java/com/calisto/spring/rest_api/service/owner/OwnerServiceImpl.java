package com.calisto.spring.rest_api.service.owner;

import com.calisto.spring.rest_api.DaO.company.CompanyDaO;
import com.calisto.spring.rest_api.DaO.owner.OwnerDaO;
import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.owners.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService{
    @Autowired
    OwnerDaO ownerDaO;

    @Autowired
    CompanyDaO companyDaO;

    Company company = new Company();
    List<Owner> owners = new ArrayList<>();
    Owner owner;

    @Override
    @Transactional
    public List<Owner> getAll() {
        return ownerDaO.getAll();
    }

    @Override
    @Transactional
    public Owner add(Owner owner1) {
        System.out.println(owner1);
        System.out.println(owner1.getName());
        Company company1 = new Company();
        Owner owner2 = new Owner();
        ownerDaO.add(owner1);
        owner2 = owner1;
        company1 = companyDaO.getCompany(owner2.getCompany_id());
        if (owner2.getMain_owner_id()==0){
            company1.getOwners().add(owner2);
        }
        else{
            addNewOwner();
            companyDaO.add(company1);
        }

        return owner2;
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
    public void addNewOwner() {
        this.owners = company.getOwners();
        getMainOwnerList(owners);
        System.out.println(owners);
        company.setOwners(owners);
    }

        private void getMainOwnerList (List<Owner> ownersList){
            for (int i = 0; i<ownersList.size();i++){
                if (chekOwner(ownersList.get(i))){
                    addOwner(ownersList.get(i).getOwners());
                }
                if (!chekOwner(ownersList.get(i))) {
                    getMainOwnerList(ownersList.get(i).getOwners());
                }
            }
        }

    public boolean chekOwner(Owner chekOwner){
        return owner.getMain_owner_id() == chekOwner.getId();
    }

    public void addOwner(List<Owner> ownerList){
        ownerList.add(owner);
    }

}
