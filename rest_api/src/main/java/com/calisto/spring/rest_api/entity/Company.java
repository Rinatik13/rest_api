package com.calisto.spring.rest_api.entity;

import com.calisto.spring.rest_api.entity.owners.Owner;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
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
    @NotEmpty(message = "Не указана форма организации.")
    @Size(min = 2, max = 255, message = "Введён не корректный размер название формы организации.")
    @Column(name = "full_name_form_com")
    private String fullNameFormCompany;

    // полное название организации
    @NotEmpty(message = "Не указано название организации.")
    @Size(min = 2, max = 255, message = "Введён не корректный размер названия организации.")
    @Column(name = "full_name_com")
    private String fullNameCompany;

    // сокращённое название организации
    @NotEmpty(message = "Не указано название организации.")
    @Size(min = 2, max = 255, message = "Введён не корректный размер названия организации.")
    @Column(name = "small_name_com")
    private String smallNameCompany;

    // юридический адрес организации
    @NotEmpty(message = "Не указан адрес организации.")
    @Size(min = 2, max = 255, message = "Введён не корректный размер адреса организации.")
    @Column(name = "address_com")
    private String addressCompany;

    // почтовый адрес организации
    @NotEmpty (message = "Не указан почтовый адрес организации.")
    @Size(min = 2,max = 255, message = "Введён не корректный размер почтового адреса организации.")
    @Column(name = "mail_address_com")
    private String mailAddressCompany;

    // инн
    @NotEmpty (message = "Не указан ИНН организации.")
    @Size(min = 5,max = 10, message = "Введён не корректный размер ИНН организации.")
    @Column(name = "inn_com")
    private String innCompany;

    // кпп
    @NotEmpty (message = "Не указан КПП организации.")
    @Size(min = 8,max = 10, message = "Введён не корректный размер КПП организации.")
    @Column(name = "kpp_com")
    private String kppCompany;

    // огрн
    @NotEmpty (message = "Не указан ОГРН(ОРГНИП) организации.")
    @Size(min = 13,max = 15, message = "Введён не корректный размер ОГРН (ОГРНИП) организации.")
    @Column(name = "registration_number_com")
    private String registrationNumberCompany;

    // орган выдавший свидетельство о регистрации
    @NotEmpty (message = "Не указано имя организации выдавшего свидетельство.")
    @Size(min = 2, max = 255, message = "Введён не корректный размер названия органа выдавшего свидетельство.")
    @Column(name = "registration_number_gov_com")
    private String registrationNumberGovCompany;

    // дата выдачи регистрации
    @NotEmpty(message = "Не указана дата выдачи свидетельства о регистрации.")
    @Size(min = 10, max = 10, message = "Введён не корректный размер даты свидетельства о регистрации.")
    @Column(name = "date_registration_number_gov_doc")
    private String dateRegistrationNumberGovDoc;

    // дата регистрации организации
    @NotEmpty(message = "Не указана дата регистрации организации.")
    @Size(min = 10, max = 10, message = "Введён не корректный размер даты регистрации.")
    @Column(name = "date_registration_com")
    private String dateRegistrationCompany;

    // бик банка
//    @Size(min = 5,max = 10, message = "Введён не корректный размер ИНН Банка.")
    @Column(name = "bank_number")
    private String bankNumber;

    // название формы банка
//    @Size(min = 2, max = 255, message = "Введён не корректный размер названия формы Банка.")
    @Column(name = "name_form_bank")
    private String nameFormBank;

    // название банка
//    @Size(min = 2, max = 255, message = "Введён не корректный размер названия Банка.")
    @Column(name = "name_bank")
    private String nameBank;

    // адрес банка
//    @Size(min = 2, max = 255, message = "Введён не корректный размер адреса Банка.")
    @Column(name = "address_bank")
    private String addressBank;

    // расчётный счёт в банке
//    @Size(min = 20, max = 20, message = "Введён не корректный размер расчётного счёта Банка.")
    @Column(name = "checking_account_bank")
    private String checkingAccountBank;

    // корреспонденский счёт в банке
//    @Size(min = 20, max = 20, message = "Введён не корректный размер корреспондентского счёта Банка.")
    @Column(name = "correspondent_account_bank")
    private String correspondentAccountBank;

    // ОКПО
    @NotEmpty(message = "Не указано ОКПО организации (ИП).")
    @Size(min = 8, max = 10, message = "Введён не корректный размер ОКПО организации (ИП).")
    @Column(name = "okpo_com")
    private String okpoCompany;

    // ОКАТО
    @NotEmpty(message = "Не указано ОКАТО организации (ИП).")
    @Size(min = 2, max = 11, message = "Введён не корректный размер ОКАТО организации (ИП).")
    @Column(name = "okato_com")
    private String okatoCompany;

    // ОКВЭД (основной)
    @NotEmpty(message = "Не указано основной ОКВЭД организации (ИП).")
    @Size(min = 2, max = 5, message = "Введён не корректный размер основного ОКВЭД организации (ИП).")
    @Column(name = "okved_com")
    private String okvedCompany;

    // электронная почта
    @Email
    @Size(min = 5, max = 255, message = "Введён не корректный размер электронной почты.")
    @Column(name = "email_com")
    private String emailCompany;

    // телефон
//    @Size(min = 12, max = 12, message = "Введён не корректный размер телефона организации.")
    @Column(name = "telephone_com")
    private String telephoneCompany;

    // сайт
//    @Size (min = 3, max = 255, message = "Введён не корректный размер названия сайта оргинизации.")
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
    @Column(name = "user_id")
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
    private List<Image_jpg> signatureList;

    // список печатей
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_stamp",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "docs_id"))
    private List<Image_jpg> stampList;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "tender",
    joinColumns = @JoinColumn(name = "company_id"),
    inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Tender> tenderList;

//    @ManyToOne
//    @JoinColumn(name = "supervisor_id")
    private int supervisor_id;

//    @ManyToOne
//    @JoinColumn(name = "chief_accountant_id")
    private int chief_accountant_id;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "company_owners",
    joinColumns = @JoinColumn(name = "company_id"),
    inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private List<Owner> owners = new ArrayList<>();

    public int getSupervisor() {
        return supervisor_id;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor_id = supervisor;
    }

    public int getChiefAccountant() {
        return chief_accountant_id;
    }

    public void setChiefAccountant(int chiefAccountant) {
        this.chief_accountant_id = chiefAccountant;
    }

    public Company() {
    }

    public String giveTopRequisites(){
        StringBuilder resultRequisites = new StringBuilder();
        resultRequisites.append(fullNameCompany);
        resultRequisites.append("\n");
        resultRequisites.append("Юридический адрес: ");
        resultRequisites.append(addressCompany);
        resultRequisites.append(";\n");
        resultRequisites.append("Почтовый адрес: ");
        resultRequisites.append(mailAddressCompany);
        resultRequisites.append(";\n");
        resultRequisites.append("ИНН/КПП: ");
        resultRequisites.append(innCompany);
        resultRequisites.append("/");
        resultRequisites.append(kppCompany);
        resultRequisites.append("; ");
        resultRequisites.append("ОГРН: ");
        resultRequisites.append(registrationNumberCompany);
        resultRequisites.append(";\n");
        resultRequisites.append("Банковские реквизиты: ");
        resultRequisites.append(nameFormBank);
        resultRequisites.append(" ");
        resultRequisites.append(nameBank);
        resultRequisites.append(";\n");
        resultRequisites.append("Бик: ");
        resultRequisites.append(bankNumber);
        resultRequisites.append("; р/с: ");
        resultRequisites.append(checkingAccountBank);
        resultRequisites.append("; к/с: ");
        resultRequisites.append(correspondentAccountBank);
        resultRequisites.append(";\nE-mail: ");
        resultRequisites.append(emailCompany);
        resultRequisites.append("; Телефон: ");
        resultRequisites.append(telephoneCompany);
        resultRequisites.append("\n __________________________________________________________________________________");
        return resultRequisites.toString();
    }

    public int getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(int supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public int getChief_accountant_id() {
        return chief_accountant_id;
    }

    public void setChief_accountant_id(int chief_accountant_id) {
        this.chief_accountant_id = chief_accountant_id;
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

    public List<Image_jpg> getSignatureList() {
        return signatureList;
    }

    public void setSignatureList(List<Image_jpg> signatureList) {
        this.signatureList = signatureList;
    }

    public List<Image_jpg> getStampList() {
        return stampList;
    }

    public void setStampList(List<Image_jpg> stampList) {
        this.stampList = stampList;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<Tender> getTenderList() {
        return tenderList;
    }

    public void setTenderList(List<Tender> tenderList) {
        this.tenderList = tenderList;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", fullNameFormCompany='" + fullNameFormCompany + '\'' +
                ", fullNameCompany='" + fullNameCompany + '\'' +
                ", smallNameCompany='" + smallNameCompany + '\'' +
                ", addressCompany='" + addressCompany + '\'' +
                ", mailAddressCompany='" + mailAddressCompany + '\'' +
                ", innCompany='" + innCompany + '\'' +
                ", kppCompany='" + kppCompany + '\'' +
                ", registrationNumberCompany='" + registrationNumberCompany + '\'' +
                ", registrationNumberGovCompany='" + registrationNumberGovCompany + '\'' +
                ", dateRegistrationNumberGovDoc='" + dateRegistrationNumberGovDoc + '\'' +
                ", dateRegistrationCompany='" + dateRegistrationCompany + '\'' +
                ", bankNumber='" + bankNumber + '\'' +
                ", nameFormBank='" + nameFormBank + '\'' +
                ", nameBank='" + nameBank + '\'' +
                ", addressBank='" + addressBank + '\'' +
                ", checkingAccountBank='" + checkingAccountBank + '\'' +
                ", correspondentAccountBank='" + correspondentAccountBank + '\'' +
                ", okpoCompany='" + okpoCompany + '\'' +
                ", okatoCompany='" + okatoCompany + '\'' +
                ", okvedCompany='" + okvedCompany + '\'' +
                ", emailCompany='" + emailCompany + '\'' +
                ", telephoneCompany='" + telephoneCompany + '\'' +
                ", webSiteCompany='" + webSiteCompany + '\'' +
                ", summ=" + summ +
                ", aktivSumm=" + aktivSumm +
                ", smpstatus=" + smpstatus +
                ", user_id=" + user_id +
                ", employeeList=" + employeeList +
                ", buhdocumentList=" + buhdocumentList +
                ", oborudovanieList=" + oborudovanieList +
                ", prodactList=" + prodactList +
                ", contractList=" + contractList +
                ", licenseList=" + licenseList +
                ", akkreditList=" + akkreditList +
                ", documentPdfList=" + documentPdfList +
                ", signatureList=" + signatureList +
                ", stampList=" + stampList +
                ", tenderList=" + tenderList +
                '}';
    }
}
