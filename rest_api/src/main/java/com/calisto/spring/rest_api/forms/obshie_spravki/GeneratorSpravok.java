package com.calisto.spring.rest_api.forms.obshie_spravki;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.forms.rosneft.GeneratorDoc;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
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
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.IOException;

public class GeneratorSpravok implements SpravkaDoc {
    String nameDoc = "";
    int documentNumber = 0;
    String bodyDocCompany = "";

    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {

        // добавляем полное название компании в шапку файла
        String topFullNameFileDocCompany = company.getFullNameCompany();

        // добавляем реквизиты компании в шапку файла
        String requisitesCompany = "Юридический адрес: " + company.getAddressCompany() + ";\n" +
                "Почтовый адрес: " + company.getMailAddressCompany() + ";\n" +
                "ИНН/КПП: " + company.getInnCompany() + "/" +
                company.getKppCompany() + "; " +
                "ОГРН: " + company.getRegistrationNumberCompany() + ";\n" +
                "Банковские реквизиты: " + company.getNameFormBank() + " " +
                company.getNameBank() + ";\n" +
                "Бик: "+ company.getBankNumber() + ";" + " " +
                "р/с: " + company.getCheckingAccountBank() + ";" + " " +
                "к/с: " + company.getCorrespondentAccountBank() + ";\n" +
                "E-mail: " + company.getEmailCompany() + ";" + " " +
                "Телефон: " + company.getTelephoneCompany() + ".";

        // добавляем разделительную линию
        String line ="________________________________________________________________________"+
                "\n";

        // добавляем название документа
        String nameDocCompany = nameDoc +"\n";

        // надпись в закупочную комиссию
        String toCompany = "В закупочную комиссию.";

        // добавляем дату документа
        String dateDocCompany = date + " № " + nameDoc + "\n";

        // добавляем тело документа
        String textBodyDocCompany = "   " + bodyDocCompany + "\n\n\n";

        // добавляем подписанта
        String visaDocCompany =
                company.getEmployeeList().get(0).getPositionCom() +
                        " \n" +
                        company.
                                getSmallNameCompany() +" " +
                        "\""+
                        company.getSmallNameCompany() + "\"" + "         ";

        String nameVisaDocCompany =
                "                                  " +
                        company.getEmployeeList().get(0).giveFullName() + ".";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {

            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            // добавление изображения

            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            PdfFont font = PdfFontFactory
                    .createFont(
                            "c:/Windows/Fonts/arial.ttf",
                            "CP1251",
                            true);

            // создаём параграфф и добавялем туда начало шапки документа
            // название формы организации + название самой организации
            // центруем текст
            Paragraph paragraphTop = new Paragraph(topFullNameFileDocCompany);
            paragraphTop.setTextAlignment(TextAlignment.CENTER);
            paragraphTop.setFont(font)
                    .setBold()
                    .setFontSize(12)
                    .setVerticalAlignment(VerticalAlignment.TOP);

            // добавляем в шапку основыне реквизиты компании
            // центруем текст
            Paragraph paragraphTopRek = new Paragraph(requisitesCompany);
            paragraphTopRek.setTextAlignment(TextAlignment.CENTER);
            paragraphTopRek.setFont(font)
                    .setFontSize(10);

            // добавляем разграничивающую линию для отделения шапки от основной части документа
            Paragraph paragraphLine = new Paragraph(line);
            paragraphLine.setTextAlignment(TextAlignment.CENTER);

            // добавляем название комисси
            Paragraph paragraph = new Paragraph(toCompany);
            paragraph.setTextAlignment(TextAlignment.RIGHT);
            paragraph.setFont(font);

            // добавляем название документа
            // центруем текст
            Paragraph paragraphNameDoc = new Paragraph(nameDocCompany);
            paragraphNameDoc.setTextAlignment(TextAlignment.CENTER);
            paragraphNameDoc.setFont(font).setBold();

            // добавляем дату документа слева
            Paragraph paragraphDateDoc = new Paragraph(dateDocCompany);
            paragraphDateDoc.setTextAlignment(TextAlignment.LEFT);
            paragraphDateDoc.setFont(font);

            // добавляем основной текст документа
            Paragraph paragraphBodyText = new Paragraph(textBodyDocCompany);
            paragraphBodyText.setFont(font);

            // необходимо реализовать вызов случайной подписи и печати
            // ************************************************
            // печать
            company.getStampList().get(0).getAddress();
            ImageData imageData = ImageDataFactory
                    .create(company.getStampList().get(0).getAddress());
            Image image = new Image(imageData);
            image.scaleAbsolute(100,100);

            // подпись
            ImageData imageData1 = ImageDataFactory
                    .create(company.getSignatureList().get(0).getAddress());
            Image image1 = new Image(imageData1);
            image1.scaleAbsolute(50,45);

            // добавляем подписанта документа
            Border border = new GrooveBorder(new DeviceGray(10),0);

            Table table = new Table(4);
            Cell cell = new Cell()
                    .setBorder(border)
                    .add(visaDocCompany)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);

            table.addCell(cell);
            cell = new Cell()
                    .setBorder(border)
                    .add(image);
            table.addCell(cell);

            cell = new Cell()
                    .setBorder(border)
                    .add(image1)
                    .setRelativePosition(110,0,0,0);
            table.addCell(cell);

            cell = new Cell()
                    .setBorder(border)
                    .add(nameVisaDocCompany)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setVerticalAlignment(VerticalAlignment.TOP);
            table.addCell(cell);

            document.add(paragraphTop);
            document.add(paragraphTopRek);
            document.add(paragraphLine);
            document.add(paragraphDateDoc);
            document.add(paragraph);
            document.add(paragraphNameDoc);
            document.add(paragraphBodyText);
            document.add(table);
            document.close();
            return byteArrayOutputStream;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getNameFile() {
        return nameDoc;
    }

    @Override
    public String getPath() {
        return "Квалификационная часть";
    }

    public String getNameDoc() {
        return nameDoc;
    }

    @Override
    public void setNumDoc(int id) {
        this.documentNumber = id;
    }

    @Override
    public void setNameDoc(String nameDoc) {
        this.nameDoc = nameDoc;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public String getBodyDocCompany() {
        return bodyDocCompany;
    }

    @Override
    public void setBodyDocCompany(String bodyDocCompany) {
        this.bodyDocCompany = bodyDocCompany;
    }

}
