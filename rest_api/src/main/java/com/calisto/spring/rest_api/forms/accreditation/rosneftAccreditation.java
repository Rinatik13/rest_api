package com.calisto.spring.rest_api.forms.accreditation;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.forms.rosneft.GeneratorDoc;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class rosneftAccreditation implements GeneratorDoc {

    private Company company;
    private Tender tender;
    private ByteArrayOutputStream byteArrayOutputStream;
    private PdfWriter pdfWriter;
    private PdfDocument pdfDocument;
    private Document document;
    private BaseFont baseFont = new BaseFont();
    private PdfFont font = baseFont.getFont();
    private int fontSize = 12;

    private String nameFile = "Анкета-заявка на проверку соответствия требованиям в рамках ДО";

    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {
        this.company = company;
        this.tender = tender;
        // создаём пдф файл
        byteArrayOutputStream = new ByteArrayOutputStream();
        pdfWriter = new PdfWriter(byteArrayOutputStream);
        pdfDocument = new PdfDocument(pdfWriter);
        document = new Document(pdfDocument);

        // добавляем шапку
        textBlock(company.giveTopRequisites(), TextAlignment.CENTER);
        textBlock("АНКЕТА-ЗАЯВКА на проверку соответствия требованиям в рамках должной осмотрительности " +
                "Поставщика/Участника закупки для нужд \n" + tender.getName_company(),TextAlignment.CENTER);
        textBlock("1. Наименование Поставщика/Участника закупки.\n" + company.getFullNameCompany() + " "
                + company.getSmallNameCompany(),TextAlignment.LEFT);
        textBlock("\n 2. Прежнее название Поставщика/Участника закупки, если менялось перечислить название и даты " +
                "регистрации (включая изменения организационно-правовой формы): Не изменялось. \n",TextAlignment.LEFT);

        addTableBlock(4,"№ П/П","ДАТА РЕГИСТРАЦИИ","НАИМЕНОВАНИЕ", "ПРИМЕЧАНИЕ","","","","");

        addTableBlock(6,"УКАЗАТЬ ВИД ЗАВИСИМОГО ОБЩЕСТВА", "ПОЛНОЕ НАИМЕНОВАНИЕ","ИНН / КПП\n REG №/TIN", "ЮРИДИЧЕСКИЙ АДРЕС",
                "ДОЛЯ ВЛАДЕНИЯ ПОСТАВЩИКА/УЧАСТНИКА ЗАКУПКИ В УСТАВНОМ КАПИТАЛЕ, %","ОБЛАСТЬ СПЕЦИАЛИЗАЦИИ","","","","","","");
        textBlock("\n3. ИНН: " + company.getInnCompany(),TextAlignment.LEFT);
        textBlock("\n КПП: " + company.getKppCompany(),TextAlignment.LEFT);
        textBlock("\n ОГРН: " + company.getRegistrationNumberCompany(),TextAlignment.LEFT);
        textBlock("\n ОКПО: " + company.getOkpoCompany(),TextAlignment.LEFT);
        textBlock("\n Расчётный счёт и реквизиты банка: " + company.getCheckingAccountBank(),TextAlignment.LEFT);
        textBlock("\n" + company.getNameFormBank() + " " + company.getNameBank() + ", бик: " +
                company.getBankNumber(),TextAlignment.LEFT);
        textBlock("\n 4. Основной ОКВЭД2: " + company.getOkvedCompany(),TextAlignment.LEFT);
        textBlock("\n 5. Руководитель Поставщика/Участника закупки :" + company.getEmployeeList().get(0).getPositionCom() +
                " " + company.getEmployeeList().get(0).giveFullName(),TextAlignment.LEFT);
        textBlock("\n 6. Главный бухгалтер: " + company.getEmployeeList().get(0).giveFullName(),TextAlignment.LEFT);
        textBlock(("\n 7. Дата, место и орган регистрации, № свидетельства: "+
                company.getDateRegistrationCompany() + ", " +
                company.getRegistrationNumberGovCompany()+ ", " +
                company.getRegistrationNumberCompany()),TextAlignment.LEFT);
        textBlock("\n 8. Адрес (местонахождение): \n Юридический: " +
                company.getAddressCompany(),TextAlignment.LEFT);
        textBlock("\n Фактический: " + company.getAddressCompany(),TextAlignment.LEFT);
        textBlock("\n Страна регистрации: Российская Федерация", TextAlignment.LEFT);
        textBlock("\n Телефон (с кодом города): " + company.getTelephoneCompany(),TextAlignment.LEFT);
        textBlock("\n Электронная почта: " + company.getEmailCompany(),TextAlignment.LEFT);
        textBlock("\n Официальный веб-сайт Поставщика/Участника закупки: " + company.getWebSiteCompany(),TextAlignment.LEFT);
        textBlock("\n Адрес филиала/представительства на территории РФ: ", TextAlignment.LEFT);
        textBlock("\n 9. Информация о дочерних обществах, филиалах и представительствах Поставщика/участника закупки. \n",TextAlignment.LEFT);
        addTableBlock(6,"УКАЗАТЬ ВИД ЗАВИСИМОГО ОБЩЕСТВА", "ПОЛНОЕ НАИМЕНОВАНИЕ","ИНН / КПП\n REG №/TIN", "ЮРИДИЧЕСКИЙ АДРЕС",
                "ДОЛЯ ВЛАДЕНИЯ ПОСТАВЩИКА/УЧАСТНИКА ЗАКУПКИ В УСТАВНОМ КАПИТАЛЕ, %","ОБЛАСТЬ СПЕЦИАЛИЗАЦИИ","","","","","","");

        textBlock("\n 10. Информация о собственниках компании: ", TextAlignment.LEFT);
        // реализовать механизм сборки таблицы
        String[] text = null;
        int countLine =1;
        for (int i = 0; i<countLine; i++){
            text = new String[i];
        }
        addTableBlock(4,"№ П/П", "СОБСТВЕННИКИ ПОСТАВЩИКА/УЧАСТНИКА ЗАКУПКИ (АКЦИОНЕРЫ)","СТРАНА РЕГИСТРАЦИИ", "% ДОЛИ ВЛАДЕНИЯ", text.toString());

        textBlock("\n 11. Конечный бенефициар (ы) (с указанием страны регистрации): \n",TextAlignment.LEFT);

        // добавляем табилцу

        addTableBlock(1,"1");

        textBlock("\n 12. Информация о руководителях / собственниках / членах коллегиального исполнительного органа" +
                " или главного бухгалтера поставщика, которые являются работниками либо являлись бывшими работниками ПАО \"НК \"Роснефть\" и (или)" +
                " Обществ Группы:\n",TextAlignment.LEFT);

        // добавляем таблицу
        addTableBlock(1,"1");

        textBlock("\n 13. Наименование видов товаров, работ и услуг, на поставку (выполнение, оказание) которых претендует" +
                " Поставщик/Участник закупки:\n",TextAlignment.LEFT);
        // добавляем таблицу
        addTableBlock(1,"1");

        // добавить блок специализация компании
        textBlock("\n 14. Область специализации Поставщика/Участника закупки (кратко): ",TextAlignment.LEFT);

        // обавить блок если есть вхождение
        textBlock("\n 15. Информация о вхождении Поставщика/Участника в структуры естественных монополий и государственные корпорации: ",TextAlignment.LEFT);

        textBlock("\n 16. Среднесписочная численность персонала Поставщика/Участника закупки за последние 2 года: \n" +
                company.getBuhdocumentList().get(1).getDateName() + " года - " + company.getBuhdocumentList().get(1).getCountEmployeeDate() + " человек \n" +
                company.getBuhdocumentList().get(2).getDateName() + " года - " + company.getBuhdocumentList().get(2).getCountEmployeeDate() + " человек \n",TextAlignment.LEFT);

        // реализовать вызов МСП
        textBlock("\n 17. Указать принадлежность Поставщика/Участника закупки к субъектам малого и среднего предпринимательства (субъект МСП)" +
                "\n - организация - субьект МСП да" ,TextAlignment.LEFT);
        textBlock("\n 18. Наличие претензионно-исковой работы с " + tender.getName_company() + " и/или аффилированными обществами.\n",TextAlignment.LEFT);

        // добавить таблицу
        addTableBlock(1,"1");

        textBlock("\n 19. Упомлномоченным лицом (-ами) со стороны Поставщика / Участника закупки для оперативного уведомления " +
                "по вопросам организационного характера и взаимодействия с " + tender.getName_company() + " является: \n",TextAlignment.LEFT);

        addTableBlock(1,"1");

        textBlock("\n 20. Настоящим подтверждаем, что:\n" +
                "1) деятельность " + company.getSmallNameCompany() + " не преостановленна в порядке, установленном Кодексом" +
                " РФ об административных правонарушениях;\n" +
                "2) в отношении " + company.getSmallNameCompany() + " не проводится ликвидация, отсутствует " +
                "решение арбитражного суда о признании " + company.getSmallNameCompany() + " " +
                "несостоятельным (банкротом) и об открытии конкурсного производства;",TextAlignment.LEFT);
        return byteArrayOutputStream;
    }

    private void addTableBlock(int countTable,String... texts) {
        Table table = new Table(countTable);
        Cell cell = null;
        for (String text : texts) {
            cell = new Cell()
                    .add(text)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            table.addCell(cell);
        }
        document.add(table);
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
