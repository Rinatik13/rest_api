package com.calisto.spring.rest_api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Oborudovanie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @NotEmpty(message = "Не указано имя оборудования.")
//    @Size(min = 1, max = 255, message = "Введён не корректный размер имени оборудования.")
    private String name;
//    @NotEmpty(message = "Не указана модель оборудования.")
//    @Size(min = 1, max = 255, message = "Введён не корректный размер имени модели оборудования.")
    private String model;
//    @NotEmpty(message = "Не указана дата регистрации оборудования.")
//    @Size(min = 10, max = 10, message = "Введён не корректный размер даты регистрации оборудования.")
    private String date;
//    @NotEmpty(message = "Не указан статус собственности оборудования.")
//    @Size(min = 1, max = 255, message = "Введён не корректный размер статуса собственности оборудования.")
    private String status;

//    @Size(min = 1, max = 255, message = "Введён не корректный размер прочего текста.")
    private String ps;
//    @NotEmpty(message = "Не указан id компании.")
    private int company_id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "oborudovanie_docs",
    joinColumns = @JoinColumn(name = "oborudovanie_id"),
    inverseJoinColumns = @JoinColumn(name = "docs_id"))
    private List<DocumentPdf> documentPdfList;

    public Oborudovanie() {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public List<DocumentPdf> getDocumentPdfList() {
        return documentPdfList;
    }
    public void setDocumentPdfList(List<DocumentPdf> documentPdfList) {
        this.documentPdfList = documentPdfList;
    }
}
