package com.calisto.spring.rest_api.entity;

import javax.persistence.*;
import java.util.List;

// расширяем класс человек до сотрудника
@Entity
public class Employee {

    // ид человека
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // фамилия
    @Column(name = "surname")
    private String surname;

    // имя
    @Column(name = "name")
    private String name;

    // отчество
    @Column(name = "patronymic")
    private String patronymic;

    // серийный номер паспорта
    @Column(name = "passport_serial")
    private String passportSerial;

    // номер паспорта
    @Column(name = "passport_number")
    private String passportNumber;

    // кем выдан
    @Column(name = "passport_gov_name")
    private String passportGovName;

    // дата выдачи
    @Column(name = "date_gov")
    private String passportGovDate;

    // день рождения
    @Column(name = "date_happy")
    private String heppyDate;

    // адрес регистрации
    @Column(name = "address_reg")
    private String addressReg;

    // телефонный номер
    @Column(name = "telephone_number")
    private String telephoneNumber;

    // инн физ лица
    @Column(name = "inn")
    private String inn;

    // снилс очень важный всем нужный номер и документ
    @Column(name = "snils")
    private String snils;

    // гражданство
    @Column(name = "goverment_status")
    private String govermentStatus;

    // должность
    @Column(name = "position_com")
    private String positionCom;

    //     дата трудоустройства
    //     надо реализовать работу с датами
    @Column(name = "date_trud")
    private String dateTrud;

    // ид компании
    @Column(name = "company_id")
    private int company_id;

    // список сканов документов
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_docs",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "docs_id"))
    List<DocumentPdf> documentPdfList;

    public Employee() {
    }

    public String giveFullName(){
        return surname + " " + name + " " + patronymic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportGovName() {
        return passportGovName;
    }

    public void setPassportGovName(String passportGovName) {
        this.passportGovName = passportGovName;
    }

    public String getPassportGovDate() {
        return passportGovDate;
    }

    public void setPassportGovDate(String passportGovDate) {
        this.passportGovDate = passportGovDate;
    }

    public String getHeppyDate() {
        return heppyDate;
    }

    public void setHeppyDate(String heppyDate) {
        this.heppyDate = heppyDate;
    }

    public String getAddressReg() {
        return addressReg;
    }

    public void setAddressReg(String addressReg) {
        this.addressReg = addressReg;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getGovermentStatus() {
        return govermentStatus;
    }

    public void setGovermentStatus(String govermentStatus) {
        this.govermentStatus = govermentStatus;
    }

    public String getPositionCom() {
        return positionCom;
    }

    public void setPositionCom(String positionCom) {
        this.positionCom = positionCom;
    }

    public String getDateTrud() {
        return dateTrud;
    }

    public void setDateTrud(String dateTrud) {
        this.dateTrud = dateTrud;
    }

    public List<DocumentPdf> getDocumentPdfList() {
        return documentPdfList;
    }

    public void setDocumentPdfList(List<DocumentPdf> documentPdfList) {
        this.documentPdfList = documentPdfList;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
