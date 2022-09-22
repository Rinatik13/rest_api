package com.calisto.spring.rest_api.entity;

import javax.persistence.*;
import java.util.List;

// компания
// в данном классе содержится вся необходимая информация о компании
@Entity
@Table(name = "company")
public class Company {
    // ид компании
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // полное название формы организации
    @Column(name = "full_name_form_com")
    private String fullNameFormCompany;

    // полное название организации
    @Column(name = "full_name_com")
    private String fullNameCompany;

    // сокращённое название организации
    @Column(name = "small_name_com")
    private String smallNameCompany;

    // юридический адрес организации
    @Column(name = "address_com")
    private String addressCompany;

    // почтовый адрес организации
    @Column(name = "mail_address_com")
    private String mailAddressCompany;

    // инн
    @Column(name = "inn_com")
    private String innCompany;

    // кпп
    @Column(name = "kpp_com")
    private String kppCompany;

    // огрн
    @Column(name = "registration_number_com")
    private String registrationNumberCompany;

    // орган выдавший свидетельство о регистрации
    @Column(name = "registration_number_gov_com")
    private String registrationNumberGovCompany;

    // дата выдачи регистрации
    @Column(name = "date_registration_number_gov_doc")
    private String dateRegistrationNumberGovDoc;

    // дата регистрации организации
    @Column(name = "date_registration_com")
    private String dateRegistrationCompany;

    // бик банка
    @Column(name = "bank_number")
    private String bankNumber;

    // название формы банка
    @Column(name = "name_form_bank")
    private String nameFormBank;

    // название банка
    @Column(name = "name_bank")
    private String nameBank;

    // адрес банка
    @Column(name = "address_bank")
    private String addressBank;

    // расчётный счёт в банке
    @Column(name = "checking_account_bank")
    private String checkingAccountBank;

    // корреспонденский счёт в банке
    @Column(name = "correspondent_account_bank")
    private String correspondentAccountBank;

    // ОКПО
    @Column(name = "okpo_com")
    private String okpoCompany;

    // ОКАТО
    @Column(name = "okato_com")
    private String okatoCompany;

    // ОКВЭД (основной)
    @Column(name = "okved_com")
    private String okvedCompany;

    // электронная почта
    @Column(name = "email_com")
    private String emailCompany;

    // телефон
    @Column(name = "telephone_com")
    private String telephoneCompany;

    // сайт
    @Column(name = "web_site_com")
    private String webSiteCompany;

    // уставный капитал
    @Column(name = "summ")
    private double summ;

    // стоимость активов
    @Column(name = "aktiv_summ")
    private double aktivSumm;

    // смп статус
    private int smpstatus;

    // ид пользователя
    private int user_id;

    // список сотрудников
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Employee> employeeList;

    // список бухгалтерских документов
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "buhdocument",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Buhdocument> buhdocumentList;

    // список оборудования
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "oborudovanie",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Oborudovanie> oborudovanieList;

    // список товаров
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "prodact",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Prodact> prodactList;

    // список договоров
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "contract",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Contract> contractList;

    // список допусков, лицензий и прочего
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "license",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<License> licenseList;

    // список аккредитаций
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "akkredit",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Akkredit> akkreditList;

    // список основных документов (устав, приказы, решения и прочее)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_docs",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "docs_id"))
    private List<DocumentPdf> documentPdfList;

    // список подписей
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_signature",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "docs_id"))
    private List<DocumentPdf> signatureList;

    // список печатей
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_stamp",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "docs_id"))
    private List<DocumentPdf> stampList;



    public Company() {
    }

    public int getSmpstatus() {
        return smpstatus;
    }

    public void setSmpstatus(int smpstatus) {
        this.smpstatus = smpstatus;
    }

    public double getAktivSumm() {
        return aktivSumm;
    }

    public void setAktivSumm(double aktivSumm) {
        this.aktivSumm = aktivSumm;
    }

    public double getSumm() {
        return summ;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullNameFormCompany() {
        return fullNameFormCompany;
    }

    public void setFullNameFormCompany(String fullNameFormCompany) {
        this.fullNameFormCompany = fullNameFormCompany;
    }

    public String getFullNameCompany() {
        return fullNameCompany;
    }

    public void setFullNameCompany(String fullNameCompany) {
        this.fullNameCompany = fullNameCompany;
    }

    public String getSmallNameCompany() {
        return smallNameCompany;
    }

    public void setSmallNameCompany(String smallNameCompany) {
        this.smallNameCompany = smallNameCompany;
    }

    public String getAddressCompany() {
        return addressCompany;
    }

    public void setAddressCompany(String addressCompany) {
        this.addressCompany = addressCompany;
    }

    public String getMailAddressCompany() {
        return mailAddressCompany;
    }

    public void setMailAddressCompany(String mailAddressCompany) {
        this.mailAddressCompany = mailAddressCompany;
    }

    public String getInnCompany() {
        return innCompany;
    }

    public void setInnCompany(String innCompany) {
        this.innCompany = innCompany;
    }

    public String getKppCompany() {
        return kppCompany;
    }

    public void setKppCompany(String kppCompany) {
        this.kppCompany = kppCompany;
    }

    public String getRegistrationNumberCompany() {
        return registrationNumberCompany;
    }

    public void setRegistrationNumberCompany(String registrationNumberCompany) {
        this.registrationNumberCompany = registrationNumberCompany;
    }

    public String getRegistrationNumberGovCompany() {
        return registrationNumberGovCompany;
    }

    public void setRegistrationNumberGovCompany(String registrationNumberGovCompany) {
        this.registrationNumberGovCompany = registrationNumberGovCompany;
    }

    public String getDateRegistrationNumberGovDoc() {
        return dateRegistrationNumberGovDoc;
    }

    public void setDateRegistrationNumberGovDoc(String dateRegistrationNumberGovDoc) {
        this.dateRegistrationNumberGovDoc = dateRegistrationNumberGovDoc;
    }

    public String getDateRegistrationCompany() {
        return dateRegistrationCompany;
    }

    public void setDateRegistrationCompany(String dateRegistrationCompany) {
        this.dateRegistrationCompany = dateRegistrationCompany;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getNameFormBank() {
        return nameFormBank;
    }

    public void setNameFormBank(String nameFormBank) {
        this.nameFormBank = nameFormBank;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public String getAddressBank() {
        return addressBank;
    }

    public void setAddressBank(String addressBank) {
        this.addressBank = addressBank;
    }

    public String getCheckingAccountBank() {
        return checkingAccountBank;
    }

    public void setCheckingAccountBank(String checkingAccountBank) {
        this.checkingAccountBank = checkingAccountBank;
    }

    public String getCorrespondentAccountBank() {
        return correspondentAccountBank;
    }

    public void setCorrespondentAccountBank(String correspondentAccountBank) {
        this.correspondentAccountBank = correspondentAccountBank;
    }

    public String getOkpoCompany() {
        return okpoCompany;
    }

    public void setOkpoCompany(String okpoCompany) {
        this.okpoCompany = okpoCompany;
    }

    public String getOkatoCompany() {
        return okatoCompany;
    }

    public void setOkatoCompany(String okatoCompany) {
        this.okatoCompany = okatoCompany;
    }

    public String getOkvedCompany() {
        return okvedCompany;
    }

    public void setOkvedCompany(String okvedCompany) {
        this.okvedCompany = okvedCompany;
    }

    public String getEmailCompany() {
        return emailCompany;
    }

    public void setEmailCompany(String emailCompany) {
        this.emailCompany = emailCompany;
    }

    public String getTelephoneCompany() {
        return telephoneCompany;
    }

    public void setTelephoneCompany(String telephoneCompany) {
        this.telephoneCompany = telephoneCompany;
    }

    public String getWebSiteCompany() {
        return webSiteCompany;
    }

    public void setWebSiteCompany(String webSiteCompany) {
        this.webSiteCompany = webSiteCompany;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Buhdocument> getBuhdocumentList() {
        return buhdocumentList;
    }

    public void setBuhdocumentList(List<Buhdocument> buhdocumentList) {
        this.buhdocumentList = buhdocumentList;
    }

    public List<Oborudovanie> getOborudovanieList() {
        return oborudovanieList;
    }

    public void setOborudovanieList(List<Oborudovanie> oborudovanieList) {
        this.oborudovanieList = oborudovanieList;
    }

    public List<Prodact> getProdactList() {
        return prodactList;
    }

    public void setProdactList(List<Prodact> prodactList) {
        this.prodactList = prodactList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<License> getLicenseList() {
        return licenseList;
    }

    public void setLicenseList(List<License> licenseList) {
        this.licenseList = licenseList;
    }

    public List<Akkredit> getAkkreditList() {
        return akkreditList;
    }

    public void setAkkreditList(List<Akkredit> akkreditList) {
        this.akkreditList = akkreditList;
    }

    public List<DocumentPdf> getDocumentPdfList() {
        return documentPdfList;
    }

    public void setDocumentPdfList(List<DocumentPdf> documentPdfList) {
        this.documentPdfList = documentPdfList;
    }

    public List<DocumentPdf> getSignatureList() {
        return signatureList;
    }

    public void setSignatureList(List<DocumentPdf> signatureList) {
        this.signatureList = signatureList;
    }

    public List<DocumentPdf> getStampList() {
        return stampList;
    }

    public void setStampList(List<DocumentPdf> stampList) {
        this.stampList = stampList;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
