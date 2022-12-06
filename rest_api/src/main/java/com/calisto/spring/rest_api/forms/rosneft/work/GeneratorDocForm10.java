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

// создаём коммерческое предложение по форме № 10
public class GeneratorDocForm10 implements GeneratorDoc{
    String fileName = "Коммерческое предложение форма 10";
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
            String nameDocCompany = "КОММЕРЧЕСКОЕ ПРЕДЛОЖЕНИЕ\n";

            // добавляем название компании
            String littleNameCom =
                    fullSizeNameCompany;
            Table table = new Table(8);
    try {
        // таблица с лотами и стоимостью

        createTable(table, "№ п/п", 8);
        createTable(table, "Наименование и содержание этапа работ", 8);
        createTable(table, "Ед. измерения объема работ", 8);
        createTable(table, "Объем работ", 8);
        createTable(table, "Единичная расценка, руб. без НДС", 8);
        createTable(table, "Сумма НДС, руб. ", 8);
        createTable(table, "Общая стоимость работ, руб. без НДС", 8);
        createTable(table, "Общая стоимость работ, руб. с НДС", 8);

        // в цыкле необходимо реализовать получение информации по лотам на которые мы заявляемся
        // цену за лот вписать в таблицу

//            for (int i = 0; i<8; i++){
//                createTable(table,"\n",8);
//            }

        // порядковый номер наименование и содержание этапа работ
        createTable(table, "1.", 8);

        // наименование и содержание этапа работ
        createTable(table, tender.getName(), 8);

        // Ед. измерения объёма работ
        createTable(table, "шт", 8);

        // Объем работ
        createTable(table, "1", 8);

        // Единичная расценка, руб. без НДС
        createTable(table, summ + "", 8);

        // Сумма НДС, руб.
        createTable(table, ((summ * 1.2) - summ) + "", 8);

        // Общая стоимость работ, руб. без НДС
        createTable(table, summ + "", 8);

        // Общая стоимость работ руб. с НДС
        createTable(table, (summ * 1.2) + "", 8);

        // далее хранятся итоговые значения по столбцам
        createTable(table, " ", 8);
        createTable(table, "ИТОГО без НДС, руб.", 8);
        createTable(table, "х", 8);
        createTable(table, "х", 8);
        // тут надо получать данные откудато!
        createTable(table, summ + "", 8);
        createTable(table, "х", 8);
        createTable(table, summ + "", 8);
        createTable(table, "х", 8);

        createTable(table, " ", 8);
        createTable(table, "НДС, руб.", 8);
        createTable(table, "х", 8);
        createTable(table, "х", 8);
        createTable(table, "х", 8);
        // сюда вставляем Сумму НДС
        createTable(table, ((summ * 1.2) - summ) + "", 8);
        createTable(table, "х", 8);
        createTable(table, "х", 8);

        createTable(table, " ", 8);
        createTable(table, "ИТОГО (цена заявки на участие в закупке) с НДС, руб.", 8);
        createTable(table, "х", 8);
        createTable(table, "х", 8);
        createTable(table, "х", 8);
        createTable(table, "х", 8);
        createTable(table, "х", 8);
        // сюда данные вставляем откуда то
        createTable(table, (summ * 1.2) + "", 8);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

        // тут добавляем единственный текст в документе, после таблицы
            String bodyTextDoc =
                    "Настоящее предложение является " +
                            // тут надо выбрать предложение делимое или нет
                            // по умолчанию неделимы
                            "неделимым " +
                            "и может быть принято только в части " +
                            // тут надо выбрать в части скольки позиций может быть выбрано
                            // по умолчанию всех позиций
                            "всех позиций.";

            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table4 = tableStampEndSignature.createTableStampEndSignature(company,font);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            String inter = "\n";
            Paragraph inP = new Paragraph(inter);

            Paragraph paragraphTopNameDocCompany = new Paragraph(topFullNameFileDocCompany)
                    .setFont(font)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold();
            document.add(paragraphTopNameDocCompany);

            Paragraph paragraphReqCom = new Paragraph(requisitesCompany)
                    .setFont(font)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphReqCom);

            Paragraph paragraphLine = new Paragraph(line)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphLine);

            Paragraph paragraphTopInfoCom = new Paragraph(topInfoCompanyEndTender)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(10);
            document.add(paragraphTopInfoCom);
            document.add(inP);

            Paragraph paragraphNameDocCompany = new Paragraph(nameDocCompany)
                    .setFont(font)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold();
            document.add(paragraphNameDocCompany);
            document.add(inP);

            Paragraph paragraphLittleNameCom = new Paragraph(littleNameCom)
                    .setFont(font)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.RIGHT);
            document.add(paragraphLittleNameCom);
            document.add(inP);

            document.add(table);
            document.add(inP);

            Paragraph paragraphBodyTextDoc = new Paragraph(bodyTextDoc)
                    .setFont(font)
                    .setFontSize(10);
            document.add(paragraphBodyTextDoc);
            document.add(inP);

            document.add(table4);

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

    private void createTable(Table table, String text, int size) throws IOException {
        PdfFont font = PdfFontFactory
                .createFont(
                        "c:/Windows/Fonts/arial.ttf",
                        "CP1251",
                        true);

                Cell cell = new Cell()
                .add(text)
                .setFontSize(size)
                .setFont(font);
        table.addCell(cell);

    }
}