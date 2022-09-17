package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Contract;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.forms.rosneft.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class BuildingDoc {
    @Autowired
    CopyDocument copyDoc;

    public void build(Company company, Tender tender, String addressFolder, String date, double summ){

        File address = new File(addressFolder);
        address.mkdir();
        File generalFolder = new File(addressFolder + "\\" + tender.getName() + " " + tender.getNumber());
        File komFolder = new File(generalFolder + "\\Коммерческая часть");
        File tehFolder = new File(generalFolder + "\\Техническая часть");
        File kvalifFolder = new File(generalFolder + "\\Квалификационная часть");
        generalFolder.mkdir();
        komFolder.mkdir();
        tehFolder.mkdir();
        kvalifFolder.mkdir();

        GeneratorDocForm1a doc = new GeneratorDocForm1a();
        doc.launch(company,kvalifFolder + "\\Сведения о компании.pdf", tender);
        GeneratorDocForm2 doc2 = new GeneratorDocForm2();
        doc2.launch(company,kvalifFolder + "\\Информация о собственниках.pdf",tender,date);
        GeneratorDocForm3 doc3 = new GeneratorDocForm3();
        doc3.launch(company,kvalifFolder+"\\Список договоров.pdf",tender);
        GeneratorDocForm4 doc4 = new GeneratorDocForm4();
        doc4.launch(company,kvalifFolder+"\\Справка о мтр.pdf",tender);
        GeneratorDocForm5 doc5 = new GeneratorDocForm5();
        doc5.launch(company,kvalifFolder+"\\Сведения о кадровых ресурсах.pdf",tender);
        GeneratorDocForm6 doc6 = new GeneratorDocForm6();
        doc6.launch(company,kvalifFolder+"\\Согласие физ лица.pdf",tender,date);
        GeneratorDocForm7 doc7 = new GeneratorDocForm7();
        doc7.launch(company,kvalifFolder+"\\Согласие юр лица.pdf",tender);
        GeneratorDocForm8 doc8 = new GeneratorDocForm8();
        doc8.launch(company,tehFolder+"\\Техническое предложение.pdf",tender,date);
        GeneratorDocForm9 doc9 = new GeneratorDocForm9();
        doc9.launch(company,komFolder+"\\Письмо о подаче заявки.pdf",tender,date,summ);
        GeneratorDocForm10 doc10 = new GeneratorDocForm10();
        doc10.launch(company,komFolder+"\\Коммерческое предложение.pdf",tender,summ);
        GeneratorDocForm17 doc17 = new GeneratorDocForm17();
        doc17.launch(company,komFolder+"\\Подтверждение работы граждан РФ.pdf",tender);
        copyDoc = new CopyDocument();
        // добавляем документы компании в папку квалификационной части
        for (int i = 0; i<company.getDocumentPdfList().size(); i++){

            copyDoc.copyDoc(company.getDocumentPdfList().get(i),kvalifFolder.getAbsolutePath());
        }
        // добавляем все договора в папку квалификационная часть
        for (int i = 0; i<company.getContractList().size();i++){
            Contract contract = company.getContractList().get(i);
            for (int a = 0; a<contract.getDocumentPdfList().size();a++){
                copyDoc.copyDoc(contract.getDocumentPdfList().get(i), kvalifFolder.getAbsolutePath());
            }

        }


    }
}
