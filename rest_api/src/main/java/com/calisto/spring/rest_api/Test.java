package com.calisto.spring.rest_api;

import com.calisto.spring.rest_api.entity.*;
import com.calisto.spring.rest_api.logic.BuildingDoc;

import java.util.ArrayList;
import java.util.List;
// для отладки.
// проверяю правльное оформление форм.
public class Test {
    public static void main(String[] args) {
        Tender tender = new Tender();
        tender.setName("Чистка приблуды!");

        Company company = new Company();
        List<Buhdocument>buhdocumentList = new ArrayList<>();
        Buhdocument buhdocument1 = new Buhdocument();
        buhdocument1.setOborotiDate(1);
        buhdocumentList.add(buhdocument1);
        buhdocumentList.add(buhdocument1);
        buhdocumentList.add(buhdocument1);
        DocumentPdf documentPdf = new DocumentPdf();
        documentPdf.setName("Document");
        documentPdf.setAddress("C:\\java\\blank\\StampEndSignature\\MS.jpg");
        List<DocumentPdf> documentPdfList = new ArrayList<>();
        documentPdfList.add(documentPdf);
        company.setStampList(documentPdfList);
        company.setSignatureList(documentPdfList);
        List<Employee> employeeList = new ArrayList<>();
        Employee empl = new Employee();
        empl.setName("Micha");
        empl.setPositionCom("Directro");
        empl.setPassportGovDate("19 марта 2020 года");
        employeeList.add(empl);
        company.setEmployeeList(employeeList);
        company.setBuhdocumentList(buhdocumentList);
        Contract contract = new Contract();
        contract.setName("123");
        contract.setDocumentPdfList(documentPdfList);
        List<Contract> contractList = new ArrayList<>();
        contractList.add(contract);
        company.setContractList(contractList);
        Oborudovanie oborudovanie = new Oborudovanie();
        oborudovanie.setName("Оборудование");
        oborudovanie.setDocumentPdfList(documentPdfList);
        oborudovanie.setDate("01.01.2022");
        oborudovanie.setModel("Кактус");
        oborudovanie.setStatus("арендованный");
        oborudovanie.setPs("Огнезащитное");
        List<Oborudovanie> oborudovanieList = new ArrayList<>();
        oborudovanieList.add(oborudovanie);
        company.setOborudovanieList(oborudovanieList);
        company.setAddressCompany("Мухосранск");
        company.setSmallNameCompany("ООО \"ФОРД\"");
        BuildingDoc doc = new BuildingDoc();
        doc.build(company,tender,"C:\\java\\blank\\forms2\\test","12.09.2022",100000);
    }
}
