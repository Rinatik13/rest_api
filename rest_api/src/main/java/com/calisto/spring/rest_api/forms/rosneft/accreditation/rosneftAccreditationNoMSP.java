package com.calisto.spring.rest_api.forms.rosneft.accreditation;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.forms.rosneft.GeneratorDoc;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

public class rosneftAccreditationNoMSP implements GeneratorDoc {
    private Company company;
    private Tender tender;
    private ByteArrayOutputStream byteArrayOutputStream;
    private PdfWriter pdfWriter;
    private PdfDocument pdfDocument;
    private Document document;
    private BaseFont baseFont = new BaseFont();
    private PdfFont font = baseFont.getFont();
    private int fontSize = 12;
    private String nameFile = "Информация о собственниках организации";
    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {
        this.company = company;
        this.tender = tender;
        // создаём пдф файл
        byteArrayOutputStream = new ByteArrayOutputStream();
        pdfWriter = new PdfWriter(byteArrayOutputStream);
        pdfDocument = new PdfDocument(pdfWriter);
        document = new Document(pdfDocument);

        textBlock(company.giveTopRequisites(),TextAlignment.CENTER);
        textBlock("\n Настоящим, " +company.getSmallNameCompany() + "/" + company.getFullNameCompany(),
                TextAlignment.LEFT);
        textBlock("\n Адрес местонахождения (юридический адрес): " + company.getAddressCompany(),TextAlignment.LEFT);
        textBlock("\n ИНН/КПП: " + company.getInnCompany() + "/" + company.getKppCompany(),TextAlignment.LEFT);
        textBlock("ОГРН: " + company.getRegistrationNumberCompany(),TextAlignment.LEFT);

        textBlock("\n подтверждает отсутствие принадлежности к субъектам малого и среднего предпинимательства (МСП).\n" +
                "Подтверждаю, что ознакомлен(а) с положениями Федерального закона от 24.07.2007 №209-ФЗ \"О развитии " +
                "малого и среднего предпринимательства в Российской Федерации\".",TextAlignment.LEFT);



        return byteArrayOutputStream;
    }

    private void textBlock(String text, TextAlignment position) {
        Paragraph paragraph = new Paragraph(text);
        paragraph.setTextAlignment(position);
        paragraph.setFont(font);
        paragraph.setFontSize(fontSize);
        document.add(paragraph);
    }

    @Override
    public String getNameFile() {
        return nameFile;
    }

    @Override
    public String getPath() {
        return "Документы для прохождения ДО";
    }
}
