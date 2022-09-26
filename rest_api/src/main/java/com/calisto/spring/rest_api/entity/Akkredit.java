package com.calisto.spring.rest_api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Akkredit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String innGov;
    @NotEmpty(message = "Не указан номер лицензии.")
    @Size(min = 1, max = 255, message = "Не корректный размер номера.")
    private String number;
    @NotEmpty(message = "Не указана дата.")
    @Size(min = 9, max = 10, message = "Введён не корректный размер даты")
    private String date;
    @NotEmpty(message = "Не указана дата окончания действия лицензии.")
    @Size(min = 9, max = 10, message = "Введён некоректный расзмер даты")
    private String endDate;
    @NotEmpty (message = "Отсутствует id компании.")
    private int company_id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "akkredit_docs",
            joinColumns = @JoinColumn(name = "akkredit_id"),
            inverseJoinColumns = @JoinColumn(name = "docs_id"))
    private List<DocumentPdf> documentPdfList;

    public Akkredit() {
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

    public String getInnGov() {
        return innGov;
    }

    public void setInnGov(String innGov) {
        this.innGov = innGov;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<DocumentPdf> getDocumentPdfList() {
        return documentPdfList;
    }

    public void setDocumentPdfList(List<DocumentPdf> documentPdfList) {
        this.documentPdfList = documentPdfList;
    }
}