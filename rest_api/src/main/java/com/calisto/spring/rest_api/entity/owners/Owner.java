package com.calisto.spring.rest_api.entity.owners;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner{
    @Id
    private int id;
    private String name;
    private String country;
    private String identifier;
    private int share;
    private String recvisites;
    @ManyToMany
    @JoinTable(name = "owner_owners",
    joinColumns = @JoinColumn(name = "owner_id"),
    inverseJoinColumns = @JoinColumn(name = "owners_id"))
    private List<Owner> owners;


    public Owner() {
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
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", identifier='" + identifier + '\'' +
                ", share=" + share +
                ", owners=" + owners +
                '}';
    }
}
