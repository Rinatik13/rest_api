package com.calisto.spring.rest_api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String web_adress;
    private String number;
    private String innZakaz;
    private int company_id;
    public Tender() {
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
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

    public String getWeb_adress() {
        return web_adress;
    }

    public void setWeb_adress(String web_adress) {
        this.web_adress = web_adress;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInnZakaz() {
        return innZakaz;
    }

    public void setInnZakaz(String innZakaz) {
        this.innZakaz = innZakaz;
    }
}
