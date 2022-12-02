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

public class rosneftAccreditationSoglasieFL implements GeneratorDoc {

    private Company company;
    private Tender tender;
    private ByteArrayOutputStream byteArrayOutputStream;
    private PdfWriter pdfWriter;
    private PdfDocument pdfDocument;
    private Document document;
    private BaseFont baseFont = new BaseFont();
    private PdfFont font = baseFont.getFont();
    private int fontSize = 12;

    private String nameFile = "Подтверждение согласия физического лица";
    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {
        this.company = company;
        this.tender = tender;
        // создаём пдф файл
        byteArrayOutputStream = new ByteArrayOutputStream();
        pdfWriter = new PdfWriter(byteArrayOutputStream);
        pdfDocument = new PdfDocument(pdfWriter);
        document = new Document(pdfDocument);
        textBlock("ПОДТВЕРЖДЕНИЕ СОГЛАСИЯ ФИЗИЧЕСКОГО ЛИЦА НА ОБРАБОТКУ ПЕРСОНАЛЬНЫХ ДАННЫХ",TextAlignment.CENTER);
        textBlock("\nНастоящим " + company.getEmployeeList().get(0).giveFullName(),TextAlignment.LEFT);
        textBlock("\nОсновной документ, удостоверяющий личность " + company.getEmployeeList().get(0).getPassportSerial() +
                " " + company.getEmployeeList().get(0).getPassportNumber() + " " +
                company.getEmployeeList().get(0).getPassportGovName() + " дата выдачи " +
                company.getEmployeeList().get(0).getPassportGovDate(),TextAlignment.LEFT);
        textBlock("\nАдрес регистрации: " + company.getEmployeeList().get(0).getHeppyDate(),TextAlignment.LEFT);
        textBlock("\nИНН " + company.getEmployeeList().get(0).getInn(),TextAlignment.LEFT);
        textBlock("в соответствии с Федеральным законом от 27.07.2006 г. №152-ФЗ «О персональных данных» (далее" +
                " – Закон 152-ФЗ), подтверждает свое согласие на передачу и обработку персональных данных в целях " +
                "прохождения процедур, необходимых для проведения проверки Поставщиков/участия в процедурах закупок, " +
                "включения в отчет о проведении процедур закупок в соответствии с Положением Компании «О закупке " +
                "товаров, работ, услуг».\n" +
                "Оператор, получающий настоящее согласие: " +
                tender.getName_company() +
                ", зарегистрирован по адресу: " +
                // добавить адрес заказчика
                "[указать юридический адрес Общества группы \n" +
                "ПАО «НК «РОСНЕФТЬ», в которое подается согласие на обработку персональных данных ]" +
                ".\n" +
                "Настоящее согласие дано в отношении всех сведений, указанных в передаваемых мною в адрес " +
                "[указать наименование Общества группы ПАО «НК «РОСНЕФТЬ» в которое подается согласие на обработку персональных данных] " +
                "документах, в том числе (если применимо): фамилия, имя, отчество, дата и место рождения; " +
                "паспортные данные; сведения об образовании (с указанием учебных заведений); сведения о трудовой " +
                "деятельности с указанием наименования организации и занимаемой должности (в том числе по " +
                "совместительству); сведения об участии (членстве) в органах управления иных юридических лиц; " +
                "биографические данные, фотография, контактная информация, собственноручная подпись, иные " +
                "персональные данные, упомянутые в любом заполняемом в вышеуказанных целях документе.\n" +
                "Перечень действий с персональными данными, в отношении которых дано согласие, включает: обработку " +
                "(включая сбор, систематизацию, накопление, хранение, уточнение (обновление, изменение), использование, " +
                "обезличивание, блокирование, уничтожение персональных данных), при этом общее описание вышеуказанных " +
                "способов обработки данных приведено в Законе 152-ФЗ, а также на передачу такой информации третьим " +
                "лицам, в случаях, установленных действующим законодательством, и в случаях, когда " +
                tender.getName_company() +
                " выступает для третьих лиц, которым передаются персональные данные, Организатором закупки.\n" +
                "Условием прекращения обработки персональных данных является получение " +
                tender.getName_company() +
                " письменного уведомления об отзыве согласия на обработку персональных данных.\n" +
                "Настоящее согласие действует в течение 10 лет со дня его подписания. \n" +
                "Подтверждаю, что ознакомлен (а) с положениями Федерального закона от 27.07.2006 " +
                "№152-ФЗ «О персональных данных», права и обязанности в области защиты персональных данных мне " +
                "понятны.\n",TextAlignment.LEFT);

        // добавить подпись подписанта

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
