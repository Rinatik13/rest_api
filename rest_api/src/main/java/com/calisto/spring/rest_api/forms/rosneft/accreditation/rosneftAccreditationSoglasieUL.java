package com.calisto.spring.rest_api.forms.rosneft.accreditation;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.forms.rosneft.work.GeneratorDoc;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

public class rosneftAccreditationSoglasieUL implements GeneratorDoc {


    private Company company;
    private Tender tender;
    private ByteArrayOutputStream byteArrayOutputStream;
    private PdfWriter pdfWriter;
    private PdfDocument pdfDocument;
    private Document document;
    private BaseFont baseFont = new BaseFont();
    private PdfFont font = baseFont.getFont();
    private int fontSize = 12;

    private String nameFile = "Подтверждение согласия на обработку персональных данных";
    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {
        this.company = company;
        this.tender = tender;
        // создаём пдф файл
        byteArrayOutputStream = new ByteArrayOutputStream();
        pdfWriter = new PdfWriter(byteArrayOutputStream);
        pdfDocument = new PdfDocument(pdfWriter);
        document = new Document(pdfDocument);
        textBlock("ПОДТВЕРЖДЕНИЕ УЧАСТНИКА ЗАКУПКИ / ПОСТАВЩИКА НАЛИЧИЯ СОГЛАСИЯ НА ОБРАБОТКУ ПЕРСОНАЛЬНЫХ ДАННЫХ " +
                "И НАПРАВЛЕНИЯ УВЕДОМЛЕНИЯ ОБ ОСУЩЕСТВЛЕНИИ ОБРАБОТКИ ПЕРСОНАЛЬНЫХ ДАННЫХ\n",TextAlignment.CENTER);
        textBlock("\n Настоящим " + company.getSmallNameCompany(),TextAlignment.LEFT);
        textBlock("\n Адрес места нахождения (юридический адрес): " + company.getAddressCompany(),TextAlignment.LEFT);
        textBlock("\n Фактический адрес: " + company.getAddressCompany(),TextAlignment.LEFT);
        textBlock("\n Свидетельство о государственной регистрации: " + company.getRegistrationNumberCompany(),TextAlignment.LEFT);
        textBlock("\n в соответствии с Федеральным законом от 27.07.2006 №152-ФЗ «О персональных данных» (далее – " +
                "Закон 152-ФЗ), подтверждает получение им в целях участия в проверке при мелкой закупке/квалификации/" +
                "процедурах закупок, включения в отчет о проведении процедур закупок в соответствии с Положением " +
                "Компании «О закупке товаров, работ, услуг» всех требуемых в соответствии с действующим " +
                "законодательством Российской Федерации (в том числе о персональных данных) согласий на передачу и " +
                "обработку персональных данных субъектов персональных данных, упомянутых в предоставленных материалах " +
                "(в том числе материалах для участия в проверке при мелкой закупке/квалификации/в любой из частей " +
                "заявки при участии в процедурах закупок), а также направление в адрес таких субъектов персональных " +
                "данных уведомлений об осуществлении обработки их персональных данных в " +
                tender.getName_company() +
                "зарегистрированному по адресу: " +
                // добавить адрес заказчика
                "[указать юридический адрес Общества группы ПАО «НК «РОСНЕФТЬ», " +
                "в которое подается согласие на обработку персональных]" +
                ", т.е. на совершение действий, предусмотренных " +
                "п.3. ст.3 Закона 152-ФЗ.\n" +
                "\tПеречень действий с персональными данными, в отношении которых получено согласие субъекта персональных" +
                " данных и направлено уведомление об осуществлении " +
                tender.getName_company() +
                " обработки их персональных " +
                "данных, включает: фамилия, имя, отчество, дата и место рождения; паспортные данные; сведения об " +
                "образовании (с указанием учебных заведений); сведения о трудовой деятельности с указанием наименования " +
                "организации и занимаемой должности (в том числе по совместительству); сведения об участии (членстве) в " +
                "органах управления иных юридических лиц; биографические данные, фотография, контактная информация, " +
                "собственноручная подпись, иные упомянутые персональные данные.\n" +
                "\tПеречень действий с персональными данными, в отношении которых получены согласия субъектов персональных " +
                "данных, включает: обработку (включая сбор, систематизацию, накопление, хранение, уточнение " +
                "(обновление, изменение), использование, обезличивание, блокирование, уничтожение персональных данных), " +
                "при этом общее описание вышеуказанных способов обработки данных приведено в Законе 152-ФЗ, " +
                "а также на передачу такой информации третьим лицам в случаях, установленных действующим " +
                "законодательством, и в случаях, когда " +
                tender.getName_company() +
                " выступает для третьих лиц, которым " +
                "передаются персональные данные, Организатором закупки.\n" +
                "\tУсловием прекращения обработки персональных данных является получение " +
                tender.getName_company() +
                " письменного " +
                "уведомления об отзыве согласия на обработку персональных данных.\n" +
                "\tНастоящее подтверждение действует со дня его подписания в течение 10 лет (либо до дня его отзыва " +
                "субъектом персональных данных способом, указанным выше).\n",TextAlignment.LEFT);

        // добавляем подписанта юр лицо


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
