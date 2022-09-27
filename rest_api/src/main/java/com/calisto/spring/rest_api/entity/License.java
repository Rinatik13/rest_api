package com.calisto.spring.rest_api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Не указано имя лицензии.")
    @Size(min = 1, max = 255, message = "Введён не корректный размер имени.")
    private String name;
    @NotEmpty(message = "Не указана дата получения лицензии.")
    @Size(min = 10, max = 10, message = "Введён не корректный размер даты получения лицензии.")
    private String date;
    @NotEmpty(message = "Не указан номер лицензии.")
    @Size(min = 1, max = 255, message = "Введён не корректный размер номера лицензии.")
    private String number;
    @NotEmpty(message = "Не указана дата окончания лицензии.")
    @Size(min = 10, max = 10, message = "Введён не корректный размер даты окончания лицензии.")
    private String endDate;
    @NotEmpty(message = "Не указано имя органа выдавшего лицензию.")
    @Size(min = 1, max = 255, message = "Введён не корректный размер имени органа выдавшего лицензию.")
    private String nameGovCom;
    @NotEmpty(message = "Не указано id компании.")
    private int company_id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "licenzii_docs",
            joinColumns = @JoinColumn(name = "licenzii_id"),
            inverseJoinColumns = @JoinColumn(name = "docs_id"))
    private List<DocumentPdf> documentPdfList;

    public License() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNameGovCom() {
        return nameGovCom;
    }

    public void setNameGovCom(String nameGovCom) {
        this.nameGovCom = nameGovCom;
    }

    public List<DocumentPdf> getDocumentPdfList() {
        return documentPdfList;
    }

    public void setDocumentPdfList(List<DocumentPdf> documentPdfList) {
        this.documentPdfList = documentPdfList;
    }
}
