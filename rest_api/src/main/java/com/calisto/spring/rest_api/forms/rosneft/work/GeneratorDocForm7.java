package com.calisto.spring.rest_api.forms.rosneft.work;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
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

// создаём документ подтверждения участника закупки наличия согласия на
// обработку персональных данных
public class GeneratorDocForm7 implements GeneratorDoc{
        String fileName = "Согласие юр лица на обработку персональных данных";
    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {

            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            String fullSizeNameCompany = company.getSmallNameCompany();

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
                    "Бик: " + company.getBankNumber() + ";" + " " +
                    "р/с: " + company.getCheckingAccountBank() + ";" + " " +
                    "к/с: " + company.getCorrespondentAccountBank() + ";\n" +
                    "E-mail: " + company.getEmailCompany() + ";" + " " +
                    "Телефон: " + company.getTelephoneCompany() + ".";

            // добавляем разделительную линию
            String line = "________________________________________________________________________" +
                    "\n";

            // добавляем название документа
            String nameDocCompany = "ПОДТВЕРЖДЕНИЕ УЧАСТНИКА ЗАКУПКИ НАЛИЧИЯ" +
                    " СОГЛАСИЯ НА ОБРАБОТКУ ПЕРСОНАЛЬНЫХ ДАННЫХ И НАПРАВЛЕНИЯ" +
                    " УВЕДОМЛЕНИЙ ОБ ОСУЩЕСТВЛЕНИИ ОБРАБОТКИ ПЕРСОНАЛЬНЫХ" +
                    " ДАННЫХ\n";

            String infoReqDocCompany =
                    "Настоящим " +
                            fullSizeNameCompany + ",\n" +
                            "адрес места нахождения (юридический адрес): " +
                            company.getAddressCompany() + ",\n" +
                            "Фактический адрес: " +
                            company.getAddressCompany() + ",\n" +
                            "Свидетельство о регистрации/ИНН (для индивидуального" +
                            " предпринимателя): " +
                            // надо сделать более подробнее (не просто оргн и инн
                            // а конкретно кто где и когда выдал
                            company.getRegistrationNumberCompany() + "/" +
                            company.getInnCompany();

            String bodyTextDoc1 =
                    "в соответствии с Федеральным законом от 27.07.2006 №152-ФЗ «О персональных данных» " +
                            "(далее – Закон 152-ФЗ), подтверждает получение им в целях участия в квалификации " +
                            "/закупочных процедурах/включения в отчет о проведении процедур закупок в соответствии " +
                            "с Положением Компании «О закупке товаров, работ, услуг» всех требуемых в соответствии " +
                            "с действующим законодательством Российской Федерации (в том числе о персональных данных) " +
                            "согласий на передачу и обработку персональных данных субъектов персональных данных, " +
                            "упомянутых в любой из частей заявки на участие в " +
                            tender.getNumber() + " на " +
                            tender.getName() +
                            ", а также направление в адрес таких субъектов " +
                            "персональных данных уведомлений об осуществлении обработки их персональных " +
                            "данных в " +
                            tender.getName_company() +
                            ", зарегистрированному по адресу: " +
                            tender.getAddressCompany() +
                            ", т.е. на совершение " +
                            "действий, предусмотренных п.3. ст.3 Закона 152-ФЗ.\n" +
                            "Перечень действий с персональными данными, в отношении которых получено согласие " +
                            "субъекта персональных данных и направлено уведомление об осуществлении " +
                            tender.getName_company() +
                            " обработки их персональных " +
                            "данных, включает: фамилия, имя, отчество, дата и место рождения; паспортные данные; " +
                            "сведения об образовании (с указанием учебных заведений); сведения о трудовой " +
                            "деятельности с указанием наименования организации и занимаемой должности " +
                            "(в том числе по совместительству); сведения об участии (членстве) в органах " +
                            "управления иных юридических лиц; биографические данные, фотография, " +
                            "контактная информация, собственноручная подпись, иные персональные данные, " +
                            "упомянутые в любой из частей заявки на участие в " + tender.getMethodTender() +
                            "на " + tender.getName() + ".\n" +
                            "Перечень действий с персональными данными, в отношении которых получены " +
                            "согласия субъектов персональных данных, упомянутых в любой из частей " +
                            "заявки на участие в " + tender.getMethodTender() + " на " + tender.getName() +
                            ", включает: обработку (включая сбор, систематизацию, накопление, хранение," +
                            " уточнение (обновление, изменение), использование, обезличивание, блокирование" +
                            ", уничтожение персональных данных), при этом общее описание вышеуказанных способов " +
                            "обработки данных приведено в Законе \n" +
                            "152-ФЗ, а также на передачу такой информации третьим лицам, в случаях, установленных " +
                            "действующим законодательством, и в случаях, когда " + tender.getName_company() +
                            " выступает для третьих лиц, которым " +
                            "передаются персональные данные, Организатором закупки.\n" +
                            "Условием прекращения обработки персональных данных является получение " +
                            tender.getMethodTender() + " письменного уведомления " +
                            "об отзыве согласия на обработку персональных данных.\n" +
                            "Настоящее подтверждение действует со дня его подписания в течение 10 лет (либо " +
                            "до дня его отзыва субъектом персональных данных способом, указанным выше).\n";

            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table4 = tableStampEndSignature.createTableStampEndSignature(company,font);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            // добавляем шапку документа
            Paragraph paragraphTopNameCom = new Paragraph(topFullNameFileDocCompany)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setBold();
            document.add(paragraphTopNameCom);

            // добавляем реквизиты компании в шапку
            Paragraph paragraphReqTopDoc = new Paragraph(requisitesCompany)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(10);
            document.add(paragraphReqTopDoc);

            // добавляем линию
            Paragraph paragraphLine = new Paragraph(line)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphLine);

            // добавляем название документа
            Paragraph paragraphNameDocCom = new Paragraph(nameDocCompany)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(14)
                    .setBold();
            document.add(paragraphNameDocCom);

            // Добавляем реквизиты компании слева
            Paragraph paragraphInfoReqCom = new Paragraph(infoReqDocCompany)
                    .setFont(font)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.LEFT);
            document.add(paragraphInfoReqCom);

            // добавляем текст тела документа
            Paragraph paragraphBodyTextDoc = new Paragraph(bodyTextDoc1)
                    .setFont(font)
                    .setFontSize(12);
            document.add(paragraphBodyTextDoc);

            // добавляем подписанта
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
                return "Квалификационная часть";
        }
}
