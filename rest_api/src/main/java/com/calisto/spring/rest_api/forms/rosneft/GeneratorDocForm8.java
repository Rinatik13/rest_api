package com.calisto.spring.rest_api.forms.rosneft;

import com.calisto.spring.rest_api.entity.company.Company;
import com.calisto.spring.rest_api.entity.company.Tender;
import com.calisto.spring.rest_api.logic.TableStampEndSignature;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.kernel.color.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
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

// техническое предложение
public class GeneratorDocForm8 {
    public void launch(Company company, String address, Tender tender, String date){
        try {
            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            // добавляем прозрачный бордюр
            Border border = new GrooveBorder(new DeviceGray(10), 0);

            // краткое название компании с ковычками
            String fullSizeNameCompany = company.getSmallNameFormCompany() + " " +
                    "\"" + company.getSmallNameCompany() + "\"";

            // добавляем информацию о участнике, инн и номер торгов
            String topInfoCompanyEndTender =
                    "Наименование Участника закупки: " + fullSizeNameCompany + "\n" +
                            "ИНН (или иной индификационный номер) Участника закупки: " +
                            company.getInnCompany() + "\n" +
                            "Наименование закупки: №" +
                            tender.getNumberTender() + " " +
                            tender.getNameTender() + "\n";

            // добавляем название документа
            String nameDocCompany = "ТЕХНИЧЕСКОЕ ПРЕДЛОЖЕНИЕ\n";

            // добавляем маленький заголовок с названием компании, датой и номером
            String bodyTextNameCom =
                    fullSizeNameCompany;

            Table table = new Table(2);
            Cell cell = new Cell()
                    // тут добавляем ДАТУ! обязательно надо автоматизировать
                    .add(date)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(font)
                    .setBorder(border)
                    .setFontSize(10);
            table.addCell(cell);

            cell = new Cell()
                    // необходимо добавлять номер! узнать от чего зависит и автоматизировать
                    .add("№" + "1")
                    .setFont(font)
                    .setBorder(border)
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFontSize(10);
            table.addCell(cell);


            // добавляем основной блока текста тех предложения
            String bodyTextDoc =
                    "Изучив Извещение и Документацию о закупке, " +
                            "размещенное на сайте ПАО «НК «Роснефть» " +
                            "(при проведении закупки в интересах Заказчиков, не подпадающих под действие " +
                            "Закона 223-ФЗ), №" +
                            // добавляем номер и название закупки
                            tender.getNumberTender() + " " +
                            tender.getNameTender() +
                            ", " +
                            "и принимая установленные в них требования и условия закупки,\n" +
                            company.getFullNameFormCompany() + " " +
                            "\"" +
                            company.getFullNameCompany() + "\"" +
                            ", \n" +
                            "расположенное по адресу " +
                            // добавляем юр адрес компании
                            company.getAddressCompany() +
                            ",\n" +
                            "согласно выполнить работы в соответствии с предлагаемыми проектом Договора " +
                            "(Блок 6 «Проект Договора»), Техническим заданием (Блок 7 «Техническое задание») " +
                            ".\n" +
                            "Настоящее Техническое предложение имеет правовой статус оферты и действует " +
                            "в течение срока действия заявки, который составляет: " +
                            // по умолчанию 180 дней
                            // но надо посмотреть как реализовать срок действия нашего предложения(заявки)
                            "180 дней.\n";


            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table2 = tableStampEndSignature.createTableStampEndSignature(company,font);


            PdfWriter pdfWriter = new PdfWriter(address);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            String inter = "\n";
            Paragraph inP = new Paragraph(inter);


            // добавляем информацию о закупке и компании
            Paragraph paragraphTopInfoCom = new Paragraph(topInfoCompanyEndTender)
                    .setFont(font)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.LEFT);
            document.add(paragraphTopInfoCom);
            document.add(inP);

            // добавляем название документа
            Paragraph paragraphNameDoc = new Paragraph(nameDocCompany)
                    .setBold()
                    .setFontSize(12)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphNameDoc);
            document.add(inP);

            // добавляем название компании
            Paragraph paragraphBodyNameCom = new Paragraph(bodyTextNameCom)
                    .setFont(font)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.RIGHT);
            document.add(paragraphBodyNameCom);

            // добавляем дату и номер
            document.add(table);
            document.add(inP);

            // добавляем основной текст
            Paragraph paragraphBodyTextDoc = new Paragraph(bodyTextDoc)
                    .setFontSize(10)
                    .setFont(font);
            document.add(paragraphBodyTextDoc);
            document.add(inP);

            // добавляем подписантов
            document.add(table2);
            // закрываем документ
            document.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
