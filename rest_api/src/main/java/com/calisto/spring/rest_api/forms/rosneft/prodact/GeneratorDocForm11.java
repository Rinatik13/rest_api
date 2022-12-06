package com.calisto.spring.rest_api.forms.rosneft.prodact;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.forms.rosneft.work.GeneratorDoc;
import com.calisto.spring.rest_api.logic.TableStampEndSignature;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;

// создаём документ план распределения объёмов выполнения работ коллективного
// участника закупки
public class GeneratorDocForm11 implements GeneratorDoc {
    String fileName = "План распределения объёмов";
    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {

            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            String fullSizeNameCompany =company.getSmallNameCompany();

            // добавляем информацию об участнике, инн и номер торгов
            String topInfoCompanyEndTender =
                    "Наименование Участника закупки: " + fullSizeNameCompany + "\n" +
                            "ИНН (или иной индификационный номер) Участника закупки: " +
                            company.getInnCompany() + "\n" +
                            "Наименование закупки: №" +
                            tender.getNumber() + " " +
                            tender.getName() + "\n";

            // создаём таблицу с расписанием плана выполнения работ коллективного Участника закупки
            Table table = new Table(7);
            createNewCellTable(table,"№ п/п");
            createNewCellTable(table,"Предмет Договора, заключаемого с членом коллективного " +
                    "Участника закупки (с указанием количества поставляемого им товара, объема " +
                    "выполняемых им работ, оказываемых им услуг)");
            createNewCellTable(table,"Объем Договора с членом коллективного " +
                    "Участника закупки от цены предложения, в процентах");
            createNewCellTable(table,"Цена Договора с членом коллективного Участника закупки, в руб.");
            createNewCellTable(table,"Наименование, фирменное наименование (при наличии), место нахождения" +
                    " (для юридического лица)/ фамилия, имя, отчество (при наличии), паспортные данные, место " +
                    "жительства (для индивидуального предпринимателя), почтовый адрес, номер контактного телефона, " +
                    "адрес электронной почты коллективного Участника закупки, принадлежность к субъектам малого и " +
                    "предпринимательства (да/нет)");
            createNewCellTable(table,"Место, условия и сроки (периоды) поставки товара " +
                    "(выполнения работы, оказания услуги) членом коллективного Участника закупки ");
            createNewCellTable(table,"Является ли член коллективного участника субъектом МСП (да/нет)");

            // тут доавбляем в таблицу если есть с кем коллективный договор и прочая лабуда.

            for (int i = 1; i<2; i++){
                createNewCellTable(table,i + ".");
                for (int a = 0; a<6; a++){

                    // тут надо сделать механизм вывода информации по сговору
                    createNewCellTable(table,"\n");

                }
            }

            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table4 = tableStampEndSignature.createTableStampEndSignature(company,font);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            String inter = "\n";
            Paragraph inP = new Paragraph(inter);

            // добавляем информацию о тендере и исполнителе
            Paragraph paragraphTopInfo = new Paragraph(topInfoCompanyEndTender)
                    .setFontSize(10)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.LEFT);
            document.add(paragraphTopInfo);
            document.add(inP);

            // добавляем главную таблицу
            document.add(table);
            document.add(inP);

            // добавляем подписантов
            document.add(table4);

            // закрываем документ
            document.close();
return byteArrayOutputStream;
    }

    @Override
    public String getNameFile() {
        return fileName;
    }

    @Override
    public String getPath() {
        return "Коммерческая часть";
    }

    private void createNewCellTable(Table table, String text) {
        try {
            PdfFont font = PdfFontFactory
                    .createFont(
                            "c:/Windows/Fonts/arial.ttf",
                            "CP1251",
                            true);

            Cell cell = new Cell()
                    .add(text)
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}