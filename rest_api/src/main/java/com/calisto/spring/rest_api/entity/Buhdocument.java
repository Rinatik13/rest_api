package com.calisto.spring.rest_api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
@Entity

public class Buhdocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Не указана дата.")
    @Size(min = 9, max = 10, message = "Введён не корректный размер даты")
    private String dateName;
    @NotEmpty
    private double oborotiDate;
    @NotEmpty(message = "Не указана дата.")
    @Size(min = 1, max = 255, message = "Введён не корректное количество сотрудников")
    private String countEmployeeDate;

    @NotEmpty(message = "Отсутствует id компании.")
    private int company_id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "buh_docs",
            joinColumns = @JoinColumn(name = "buh_id"),
            inverseJoinColumns = @JoinColumn(name = "docs_id"))
    List<DocumentPdf> documentPdfList;

    public Buhdocument() {
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

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public double getOborotiDate() {
        return oborotiDate;
    }

    public void setOborotiDate(double oborotiDate) {
        this.oborotiDate = oborotiDate;
    }

    public String getCountEmployeeDate() {
        return countEmployeeDate;
    }

    public void setCountEmployeeDate(String countEmployeeDate) {
        this.countEmployeeDate = countEmployeeDate;
    }

    public List<DocumentPdf> getDocumentPdfList() {
        return documentPdfList;
    }

    public void setDocumentPdfList(List<DocumentPdf> documentPdfList) {
        this.documentPdfList = documentPdfList;
    }

}
