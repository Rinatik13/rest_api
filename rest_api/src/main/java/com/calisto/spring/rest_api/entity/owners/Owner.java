package com.calisto.spring.rest_api.entity.owners;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int company_id;
    private int main_owner_id;
    private String name;
    private String country;
    private String identifier;
    private int share;
    private String recvisites;
    @ManyToMany
    @JoinTable(name = "owner",
    joinColumns = @JoinColumn(name = "main_owner_id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Owner> owners = new ArrayList<>();

    public Owner() {
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getMain_owner_id() {
        return main_owner_id;
    }

    public void setMain_owner_id(int main_owner_id) {
        this.main_owner_id = main_owner_id;
    }

    public void setRecvisites(String recvisites) {
        this.recvisites=recvisites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getShare() {
        return share;
    }

    public String getRecvisites() {
        return this.recvisites;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", main_owner_id=" + main_owner_id +
                ", owners=" + owners +
                "}\n";
    }
}
