package com.calisto.spring.rest_api.logic;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.forms.rosneft.*;

public class BuildingDoc {
    public void build(Company company, Tender tender, String addressPack, String date, double summ){

        GeneratorDocForm1a doc = new GeneratorDocForm1a();
        doc.launch(company,addressPack + "\\Сведения о компании.pdf", tender);
        GeneratorDocForm2 doc2 = new GeneratorDocForm2();
        doc2.launch(company,addressPack + "\\Информация о собственниках.pdf",tender,date);
        GeneratorDocForm3 doc3 = new GeneratorDocForm3();
        doc3.launch(company,addressPack+"\\Список договоров.pdf",tender);
        GeneratorDocForm4 doc4 = new GeneratorDocForm4();
        doc4.launch(company,addressPack+"\\Справка о мтр.pdf",tender);
        GeneratorDocForm5 doc5 = new GeneratorDocForm5();
        doc5.launch(company,addressPack+"\\Сведения о кадровых ресурсах.pdf",tender);
        GeneratorDocForm6 doc6 = new GeneratorDocForm6();
        doc6.launch(company,addressPack+"\\Согласие физ лица.pdf",tender,date);
        GeneratorDocForm7 doc7 = new GeneratorDocForm7();
        doc7.launch(company,addressPack+"\\Согласие юр лица.pdf",tender);
        GeneratorDocForm8 doc8 = new GeneratorDocForm8();
        doc8.launch(company,addressPack+"\\Техническое предложение.pdf",tender,date);
        GeneratorDocForm9 doc9 = new GeneratorDocForm9();
        doc9.launch(company,addressPack+"\\Письмо о подаче заявки.pdf",tender,date,summ);
        GeneratorDocForm10 doc10 = new GeneratorDocForm10();
        doc10.launch(company,addressPack+"\\Коммерческое предложение.pdf",tender,summ);
        GeneratorDocForm17 doc17 = new GeneratorDocForm17();
        doc17.launch(company,addressPack+"\\Подтверждение работы граждан РФ.pdf",tender);

    }
}
