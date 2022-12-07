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

// создаём форму подтверждения отсутствия принадлежности к СМП и МСП
public class GeneratorDocForm16Prod implements GeneratorDoc {
        String fileName = "Подтверждение отсутствия принадлежности к СМП и МСП";
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
            String nameDocCompany = "ФОРМА ПОДТВЕРЖДЕНИЯ ОТСУТСТВИЯ ПРИНАДЛЕЖНОСТИ ОРГАНИЗАЦИИ" +
                    " К СУБЪЕКТАМ МАЛОГО И СРЕДНЕГО ПРЕДПРИНИМАТЕЛЬСТВА (МСП)\n";

            String infoReqDocCompany =
                    "Настоящим " +
                            fullSizeNameCompany + ",\n" +
                            "адрес места нахождения (юридический адрес): " +
                            company.getAddressCompany() + ",\n" +
                            "Фактический адрес: " +
                            company.getAddressCompany() + ",\n" +
                            "Свидетельство о регистрации/ИНН (для индивидуального" +
                            " предпринимателя): выдан" +
                            company.getRegistrationNumberGovCompany() + ", " +
                            company.getRegistrationNumberCompany() + ", дата выдачи " +
                            company.getDateRegistrationNumberGovDoc();

            String bodyTextDocCom =
                    "подтверждает отсутствие принадлежности» к субъектам малого и среднего предпринимательства (МСП).\n" +
                            "\n" +
                            "Подтверждаю, что ознакомлен(а) с положениями Федерального закона от 24.07.2007 \n" +
                            "№209-ФЗ «О развитии малого и среднего предпринимательства в Российской Федерации».\n";

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
                return "Квалификационная часть";
        }
}