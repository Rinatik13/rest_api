package com.calisto.spring.rest_api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Tender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Не указано имя тендера.")
    @Size(min = 1, max = 255, message = "Введён не корректный размер имени тендера.")
    private String name;
    @Size(min = 3, max = 255, message = "Введён не корректный размер ссылки на сайт.")
    private String web_address;
    @NotEmpty(message = "Не указан номер закупки.")
    @Size(min = 1, max = 255, message = "Введён не корректный размер номера закупки.")
    private String number;
    @NotEmpty (message = "Не указан ИНН организации.")
    @Size(min = 5,max = 10, message = "Введён не корректный размер ИНН организации.")
    private String innZakaz;
    @NotEmpty (message = "Не указан название организации.")
    @Size(min = 1, max = 255, message = "Введён не корректный размер номера закупки.")
    private String name_company;
    @NotEmpty(message = "Не указан id компании.")
    private int company_id;
    private int countEmployee;
    public Tender() {
    }
    public String getName_company() {
        return name_company;
    }
    public void setName_company(String name_company) {
        this.name_company = name_company;
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
        return web_address;
    }

    public void setWeb_adress(String web_adress) {
        this.web_address = web_adress;
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

    public String getWeb_address() {
        return web_address;
    }

    public void setWeb_address(String web_address) {
        this.web_address = web_address;
    }

    public int getCountEmployee() {
        return countEmployee;
    }

    public void setCountEmployee(int countEmployee) {
        this.countEmployee = countEmployee;
    }
}
