package com.calisto.spring.rest_api.forms.rosneft.prodact;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.forms.rosneft.work.GeneratorDoc;
import com.calisto.spring.rest_api.logic.TableStampEndSignature;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

// создаём документ где подтверждаем выполнения работ Российскими лицами
public class GeneratorDocForm17 implements GeneratorDoc {
    String fileName = "Подтверждение выполнение работ Российскими лицами";
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

            // добавляем название документа
            String nameDocCompany = "ФОРМА ПОДТВЕРЖДЕНИЯ ВЫПОЛНЕНИЯ РАБОТ РОССИЙСКИМИ ЛИЦАМИ\n";

            String infoReqDocCompany =
                    "Настоящим " +
                            fullSizeNameCompany + ",\n" +
                            "адрес места нахождения (юридический адрес): " +
                            company.getAddressCompany() + ",\n" +
                            "Фактический адрес: " +
                            company.getAddressCompany() + ",\n" +
                            "Свидетельство о регистрации/ИНН (для индивидуального" +
                            " предпринимателя): " +
                            company.getRegistrationNumberGovCompany() + ", " +
                            company.getRegistrationNumberCompany() + ", дата выдачи " +
                            company.getDateRegistrationNumberGovDoc();

            String bodyTextDocCom =
                    "подтверждает, что выполнение работ производится российскими лицами, предоставляя документы, " +
                            "содержащие информацию о месте регистрации (для юридических лиц и индивидуальных " +
                            "предпринимателей) либо документы, удостоверяющие личность (для физических лиц).\n" +
                            "Подтверждаю, что ознакомлен(а) с положениями Постановления Правительства РФ от " +
                            "16.09.2016 №925 «О приоритете товаров российского происхождения, работ, услуг, " +
                            "выполняемых, оказываемых российскими лицами, по отношению к товарам, происходящим " +
                            "из иностранного государства, работам, услугам, выполняемым, оказываемым " +
                            "иностранными лицами».\n" +
                            "Приоритет устанавливается с учетом положений Генерального соглашения по " +
                            "тарифам и торговле 1994 года и Договора о Евразийском экономическом " +
                            "союзе от 29 мая 2014 г.\n" +
                            "Подтверждаю, что ознакомлен(а) с ответственностью, которая следует " +
                            "в отношении предоставления недостоверных сведений о лицах, " +
                            "выполняющих работы. \n";


            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table4 = tableStampEndSignature.createTableStampEndSignature(company,font);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            String inter = "\n";
            Paragraph inP = new Paragraph(inter);

            // добавляем шапку с названием компании
            Paragraph paragraphTopFullNameCom = new Paragraph(topFullNameFileDocCompany)
                    .setFontSize(12)
                    .setBold()
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font);
            document.add(paragraphTopFullNameCom);

            // добавляем в шапку реквизиты компании
            Paragraph paragraphReqCom = new Paragraph(requisitesCompany)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font);
            document.add(paragraphReqCom);

            // добавляем линию
            Paragraph paragraphLine = new Paragraph(line)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphLine);
            document.add(inP);

            // добавляем название документа
            Paragraph paragraphNameDoc = new Paragraph(nameDocCompany)
                    .setBold()
                    .setFontSize(12)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphNameDoc);
            document.add(inP);

            // добавляем основные реквизиты в тело документа
            Paragraph paragraphInfoReqDoc = new Paragraph(infoReqDocCompany)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(10);
            document.add(paragraphInfoReqDoc);

            // добавляем основной текст тела документа
            Paragraph paragraphBodyTextDoc = new Paragraph(bodyTextDocCom)
                    .setFont(font)
                    .setFontSize(10);
            document.add(paragraphBodyTextDoc);
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
}

