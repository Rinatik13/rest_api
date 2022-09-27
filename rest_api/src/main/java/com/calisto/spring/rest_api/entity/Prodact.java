package com.calisto.spring.rest_api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Prodact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Не указано имя продукта.")
    @Size(min = 1, max = 255, message = "Введён не корректный размер имени продукта.")
    private String name;
    @NotEmpty(message = "Не указано модель продукта.")
    @Size(min = 1, max = 255, message = "Введён не корректный размер модели продукта.")
    private String model;
    @NotEmpty(message = "Не указано id компании.")
    private int company_id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prodact_docs",
            joinColumns = @JoinColumn(name = "prodact_id"),
            inverseJoinColumns = @JoinColumn(name = "docs_id"))
    private List<DocumentPdf> documentPdfList;

    public Prodact() {
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

    public List<DocumentPdf> getDocumentPdfList() {
        return documentPdfList;
    }

    public void setDocumentPdfList(List<DocumentPdf> documentPdfList) {
        this.documentPdfList = documentPdfList;
    }
}
