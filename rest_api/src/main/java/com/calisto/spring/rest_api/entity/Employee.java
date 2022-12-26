package com.calisto.spring.rest_api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

// расширяем класс человек до сотрудника
@Entity
public class Employee {

    // ид человека
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // фамилия
//    @NotEmpty(message = "Не указана фамилия.")
//    @Size(min = 1, max = 255, message = "Введён не корректный размер фамилии.")
    @Column(name = "surname")
    private String surname;

    // имя
//    @NotEmpty(message = "Не указано имя.")
//    @Size(min = 1, max = 255, message = "Введён не корректный размер имени.")
    @Column(name = "name")
    private String name;

    // отчество
//    @Size(min = 1, max = 255, message = "Введён не корректный размер отчества.")
    @Column(name = "patronymic")
    private String patronymic;

    // серийный номер паспорта
//    @NotEmpty(message = "Не указана серия паспорта.")
//    @Size(min = 4, max = 4, message = "Введён не корректный размер серии паспорта.")
    @Column(name = "passport_serial")
    private String passportSerial;

    // номер паспорта
//    @NotEmpty(message = "Не указан номер паспорта")
//    @Size(min = 6, max = 6, message = "Введён не корректный размер номера паспорта.")
    @Column(name = "passport_number")
    private String passportNumber;

    // кем выдан
//    @NotEmpty(message = "Не указано кем выдан паспорт.")
//    @Size(min = 1, max = 255, message = "Введён не корректный размер органа выдавшего паспорт.")
    @Column(name = "passport_gov_name")
    private String passportGovName;

    // дата выдачи
//    @NotEmpty(message = "Не указана дата выдачи паспорта.")
//    @Size(min = 10, max = 10, message = "Введён не корректный размер даты выдачи паспорта.")
    @Column(name = "date_gov")
    private String passportGovDate;

    // день рождения
//    @NotEmpty(message = "Не указана дата рождения.")
//    @Size(min = 10, max = 10, message = "Введён не корректный размер даты рождения.")
    @Column(name = "date_happy")
    private String heppyDate;

    // адрес регистрации
//    @NotEmpty(message = "Не указан адрес регистрации.")
//    @Size(min = 1, max = 255, message = "Введён не корректный размер адреса регистрации.")
    @Column(name = "address_reg")
    private String addressReg;

    // телефонный номер
    @Size(min = 12, max = 12, message = "Введён не корректный размер телефонный номер.")
    @Column(name = "telephone_number")
    private String telephoneNumber;

    // инн физ лица
//    @NotEmpty(message = "Не указан ИНН.")
//    @Size(min = 1, max = 255, message = "Введён не корректный размер ИНН.")
    @Column(name = "inn")
    private String inn;

    // снилс очень важный всем нужный номер и документ
//    @NotEmpty(message = "Не указан СНИЛС.")
//    @Size(min = 1, max = 255, message = "Введён не корректный размер СНИЛС.")
    @Column(name = "snils")
    private String snils;

    // гражданство
//    @NotEmpty(message = "Не указано гражданство.")
//    @Size(min = 1, max = 255, message = "Введён не корректный размер гражданства.")
    @Column(name = "goverment_status")
    private String govermentStatus;

    // должность
//    @NotEmpty(message = "Не указана должность.")
//    @Size(min = 1, max = 255, message = "Введён не корректный размер должности.")
    @Column(name = "position_com")
    private String positionCom;

    //     дата трудоустройства
    //     надо реализовать работу с датами
//    @NotEmpty(message = "Не указана дата трудоустройства.")
//    @Size(min = 10, max = 10, message = "Введён не корректный размер даты трудоустройства.")
    @Column(name = "date_trud")
    private String dateTrud;

    // ид компании
//    @NotEmpty(message = "Не указан id компании.")
    @Column(name = "company_id")
    private int company_id;

    // список сканов документов
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_docs",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "docs_id"))
    List<DocumentPdf> documentPdfList;

    private int vid_position;

    public Employee() {
    }

    public int getVid_position() {
        return vid_position;
    }

    public void setVid_position(int vid_position) {
        this.vid_position = vid_position;
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
