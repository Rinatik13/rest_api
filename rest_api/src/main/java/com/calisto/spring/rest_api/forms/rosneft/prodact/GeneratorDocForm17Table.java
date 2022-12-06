package com.calisto.spring.rest_api.forms.rosneft.prodact;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.forms.rosneft.work.GeneratorDoc;
import com.calisto.spring.rest_api.logic.TableStampEndSignature;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.color.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.GrooveBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;

public class GeneratorDocForm17Table implements GeneratorDoc {
    String fileName = "Таблица подтверждения выполнения работ Российскими лицами";
    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {

            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            Border border = new GrooveBorder(new DeviceGray(10), 0);

            // добавляем блок 2 й страницы
            String bodyTextDoc2 =
                    "Критерии подтверждения выполнения работ российскими лицами";

            String nameFullCom =
                    company.getFullNameFormCompany() + " " + "\"" +
                            company.getFullNameCompany() + "\"";

            // добавляем название таблицы
            String nameDocTable =
                    "Перечень работ, выполняемых российскими и иностранными лицами, \n" +
                            "к Форме подтверждения выполнения работ российскими лицами\n";

            Table table = new Table(7);
            createTableCell(table,"Наименование лота");
            createTableCell(table,"Наименование позиции");
            createTableCell(table,"Общая стоимость позиции, " +
                    "руб. с НДС  ");
            createTableCell(table,"Объем работ, выполняемый " +
                    "российскими лицами");

            Table littleTable = new Table(3);
            Cell cellLittleT = new Cell(1,3)
                    .add("Объем работ, выполняемый иностранными лицами")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBorder(border)
                    .setFontSize(8);
            littleTable.addCell(cellLittleT);
            createTableCell(littleTable,"Страна регистрации");
            createTableCell(littleTable, "Удельный вес, %");
            createTableCell(littleTable,"Стоимость, руб с НДС");

            Cell cell = new Cell(1,3)
                    .add(littleTable);
            table.addCell(cell);

            cell = new Cell(1,7)
                    .add(" ")
                    .setBorder(border);
            table.addCell(cell);

            cell = new Cell(1,7)
                    .add("Выполнение работ")
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(8);
            table.addCell(cell);

//            for (int i = 1; i<2; i++){
//                createTableCell(table,i + ".");
//                for (int a = 0; a<6; a++){
//                    // пока тестово реализуем так, но надо добавить % в серидину таблицы
//                    createTableCell(table,"\n");
//                }
//            }
            // добавляем порядковый номер
            createTableCell(table,"1.");

            // добавляем наименование позиции
            createTableCell(table, tender.getName());

            // добавляем стоимость позиции с НДС
            createTableCell(table,(summ * 1.2) + "");

            // добавляем объём работ выполняемый российскими лицами
            createTableCell(table,"100%");

            // добавляем страну регистрации для иностранцев
            createTableCell(table,"\n");

            // добавляем удельный вес, %
            createTableCell(table,"\n");

            // стоимость руб. с НДС
            createTableCell(table,"\n");

            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table4 = tableStampEndSignature.createTableStampEndSignature(company,font);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            String inter = "\n";
            Paragraph inP = new Paragraph(inter);

            // добавляем шапку бланка
            Paragraph paragraphBodyTextDoc2 = new Paragraph(bodyTextDoc2)
                    .setFontSize(10)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphBodyTextDoc2);


            // добавляем полное название организации
            Paragraph paragraphNameFullCom = new Paragraph(nameFullCom)
                    .setFont(font)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphNameFullCom);
            document.add(inP);

            // добавляем название таблицы
            Paragraph paragraphNameDocTable = new Paragraph(nameDocTable)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(10)
                    .setBold();
            document.add(paragraphNameDocTable);
            document.add(inP);

            // добавляем таблицу
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

    private void createTableCell(Table table, String text) {

        PdfFont font = null;
        try {
            font = PdfFontFactory
                    .createFont(
                            "c:/Windows/Fonts/arial.ttf",
                            "CP1251",
                            true);

            Cell cell = new Cell()
                    .add(text)
                    .setFontSize(8)
                    .setFont(font);
            table.addCell(cell);

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}