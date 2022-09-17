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
        tender.setNumber("РН202123");

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
        contract.setName("Чистка оборудования");
        contract.setDate("10.01.2021");
        contract.setAddressZakaz("РФ, РБ, г.Уфа");
        contract.setEndDate("10.08.2022");
        contract.setSmileNameZakaz("ООО \" Башнефть\"");
        contract.setInnZakaz("02020222213");
        contract.setSumm("500 000");
        contract.setDocumentPdfList(documentPdfList);
        List<Contract> contractList = new ArrayList<>();
        contractList.add(contract);
        company.setContractList(contractList);
        Oborudovanie oborudovanie = new Oborudovanie();
        Oborudovanie oborudovanie2 = new Oborudovanie();
        oborudovanie.setName("Оборудование");
        oborudovanie.setDocumentPdfList(documentPdfList);
        oborudovanie.setDate("01.01.2022");
        oborudovanie.setModel("Кактус");
        oborudovanie.setStatus("арендованный");
        oborudovanie.setPs("Огнезащитное");

        List<DocumentPdf> comDocs = new ArrayList<>();
        DocumentPdf doc = new DocumentPdf();
        DocumentPdf doc2 = new DocumentPdf();
        doc.setName("Устав");
        doc.setAddress("C:\\java\\blank\\DocCompany\\Устав.pdf");
        doc.setId(1);

        doc2.setName("Выписка ЕГРЮЛ");
        doc2.setAddress("C:\\java\\blank\\DocCompany\\Выписка ЕГРЮЛ.pdf");
        doc2.setId(2);

        comDocs.add(doc);
        comDocs.add(doc2);

        company.setDocumentPdfList(comDocs);

        oborudovanie2.setName("Трактор");
        oborudovanie2.setDocumentPdfList(documentPdfList);
        oborudovanie2.setDate("01.01.2022");
        oborudovanie2.setModel("JСB");
        oborudovanie2.setStatus("арендованный");
        oborudovanie2.setPs("Огнезащитное");

        List<Oborudovanie> oborudovanieList = new ArrayList<>();
        oborudovanieList.add(oborudovanie);
        oborudovanieList.add(oborudovanie2);
        company.setOborudovanieList(oborudovanieList);
        company.setAddressCompany("Мухосранск");
        company.setSmallNameCompany("ООО \"ФОРД\"");
        BuildingDoc docB = new BuildingDoc();
        docB.build(company,tender,"C:\\java\\blank\\forms3","12.09.2022",100000);
    }
}
