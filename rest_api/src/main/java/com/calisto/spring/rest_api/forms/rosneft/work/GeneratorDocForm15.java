package com.calisto.spring.rest_api.forms.rosneft.work;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
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

// создаём опись документов
public class GeneratorDocForm15 implements GeneratorDoc{
    String fileName = "Опись документов";
    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {

            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            String fullSizeNameCompany = company.getSmallNameCompany();

            // добавляем полное название компании в шапку файла
            String topFullNameFileDocCompany = company.getFullNameFormCompany() + "\n" + "\"" +
                    company.getFullNameCompany() + "\"";

            // добавляем реквизиты компании в шапку файла
            String requisitesCompany = "Юридический адрес: " + company.getAddressCompany() + ";\n" +
                    "Почтовый адрес: " + company.getMailAddressCompany() + ";\n" +
                    "ИНН/КПП: " + company.getInnCompany() + "/" +
                    company.getKppCompany() + "; " +
                    "ОГРН: " + company.getRegistrationNumberCompany() + ";\n" +
                    "Банковские реквизиты: " + company.getNameFormBank() + " " +
                    company.getNameBank() + ";\n" +
                    "Бик: " + company.getBankNumber() + ";" + " " +
                    "р/с: " + company.getCheckingAccountBank() + ";" + " " +
                    "к/с: " + company.getCorrespondentAccountBank() + ";\n" +
                    "E-mail: " + company.getEmailCompany() + ";" + " " +
                    "Телефон: " + company.getTelephoneCompany() + ".";

            // добавляем разделительную линию
            String line = "________________________________________________________________________" +
                    "\n";

            // добавляем информацию об участнике, инн и номер торгов
            String topInfoCompanyEndTender =
                    "Наименование Участника закупки: " + fullSizeNameCompany + "\n" +
                            "ИНН (или иной индификационный номер) Участника закупки: " +
                            company.getInnCompany() + "\n" +
                            "Наименование закупки: №" +
                            tender.getNumber() + " " +
                            tender.getName() + "\n";

            // добавляем название документа
            String nameDocCompany = "ОПИСЬ ДОКУМЕНТОВ, СОСТАВЛЯЮЩИХ ЗАЯВКУ УЧАСТНИКА\n";

            // добавляем таблицу с описанием всех документов и кол-во страниц.
            Table table = new Table(4);
            createTableCell(table,"№ п/п");
            createTableCell(table,"Наименование документа");
            createTableCell(table,"Кол-во листов");
            createTableCell(table,"Примечания Организатора");

            Cell cell = new Cell(1,4)
                    .add("Обазятельные документы")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font)
                    .setFontSize(8);
            table.addCell(cell);

            // далее идёт по сути дела очень огромный цыкл
            // вместо i<2 надо выдавать цыфру вместо 2 с значением количества документов которые подаются в
            // заявке
            for (int i = 1; i <2; i++) {
                createTableCell(table,i + ".");
                // тут надо реализовать магическое заполнение таблицы
                for (int a = 0; a < 1; a++){

                    // добавляем название документа
                    createTableCell(table,"\n");

                    // добавляем кол-во листов
                    createTableCell(table,"\n");

                    // добавляем примечание организатора (но это не наша задача как я понял, а организатора)
                    // всегда будет пустой
                    createTableCell(table,"\n");
                }
            }

            // далее добавляем заголовок для простых документов
            cell = new Cell(1,4)
                    .add("Документы, предоставляемые по желанию участника закупки")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font)
                    .setFontSize(8);
            table.addCell(cell);

            // добавляем тоже огромный цикл, составляем список всех документов
            for (int i = 1; i <2; i++) {
                createTableCell(table,i + ".");
                // тут надо реализовать магическое заполнение таблицы
                for (int a = 0; a < 1; a++){

                    // добавляем название документа
                    createTableCell(table,"\n");

                    // добавляем кол-во листов
                    createTableCell(table,"\n");

                    // добавляем примечание организатора (но это не наша задача как я понял а организатора)
                    // всегда будет пустой
                    createTableCell(table,"\n");
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

            // добавляем шапку документа
            Paragraph paragraphFullName = new Paragraph(topFullNameFileDocCompany)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font)
                    .setFontSize(12)
                    .setBold();
            document.add(paragraphFullName);

            // добавляем реквизиты компании в шапку
            Paragraph paragraphReqCom = new Paragraph(requisitesCompany)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font)
                    .setFontSize(10);
            document.add(paragraphReqCom);

            // добавляем разделительную линию
            Paragraph paragraphLine = new Paragraph(line)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphLine);

            // добавляем информацию о тендере и исполнителе
            Paragraph paragraphTopInfoCom = new Paragraph(topInfoCompanyEndTender)
                    .setFont(font)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.LEFT);
            document.add(paragraphTopInfoCom);
            document.add(inP);

            // добавляем название документа
            Paragraph paragraphNameDoc = new Paragraph(nameDocCompany)
                    .setFont(font)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold();
            document.add(paragraphNameDoc);
            document.add(inP);

            // добавляем таблицу с основным данными
            document.add(table);
            document.add(inP);

            // добавляем подписанта
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
        return "Квалификационная часть";
    }

    private void createTableCell(Table table, String text) {
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