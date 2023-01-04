package com.calisto.spring.rest_api.forms.rosneft.work;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.logic.TableStampEndSignature;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.io.source.ByteArrayOutputStream;
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

import java.text.SimpleDateFormat;

// формируем письмо о подаче заявки
public class GeneratorDocForm9 implements GeneratorDoc{
        String fileName = "Письмо о подаче заявки";
    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {

            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            // добавляем прозрачный бордюр
            Border border = new GrooveBorder(new DeviceGray(10), 0);

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

            // добавляем информацию об участнике, инн и номер торгов
            String topInfoCompanyEndTender =
                    "Наименование Участника закупки: " + fullSizeNameCompany + "\n" +
                            "ИНН (или иной индификационный номер) Участника закупки: " +
                            company.getInnCompany() + "\n" +
                            "Наименование закупки: №" +
                            tender.getNumber() + " " +
                            tender.getName() + "\n";

            // добавляем название документа
            String nameDocCompany = "ПИСЬМО О ПОДАЧЕ ЗАЯВКИ\n";

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

            String bodyTextDoc1 =
                    "Изучив Извещение и Документацию о закупке, размещенные на сайте ПАО" +
                            " \"НК\"Роснефть\" (при проведения закупки в интересах только" +
                            " Заказчиков, не подпадающих под действие Закона 233-ФЗ), №" +
                            tender.getNumber() + " " +
                            tender.getName() +
                            ", и принимая установленные в них требования и условия закупки," +
                            " настоящим подаем заявку на участие в указанной процедуре " +
                            "закупки и сообщаем о себе следующие сведения: \n" +
                            company.getFullNameFormCompany() + " " +
                            company.getFullNameCompany() + "\n" +
                            "расположенное по адресу " +
                            company.getAddressCompany() + "\n" +
                            "предлагает заключить Договор на " +
                            tender.getName() + "\n" +
                            "на условиях и в соответствии с Техническим и Коммерческим " +
                            "предложениями, являющимися неотъемлемыми приложениями к " +
                            "настоящему письму и составляющими вместе с настоящим " +
                            "письмом заявку со следующими основными условиями:\n";

            // основная таблица
            Table table1 = new Table(2);
            cell = new Cell()
                    .add("цена Договора российские рубли, с НДС" +
                            "кроме того, в цену Договора входят расходы на " +
                            // добавить какие расходы включены в цену договора
                            "налоги, пошлины и сборы")
                    .setFontSize(8)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.LEFT);
            table1.addCell(cell);

            // добавляем стоимость договора с НДС!
            cell = new Cell()
                    .add((summ*1.2) + "")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFont(font)
                    .setFontSize(8);
            table1.addCell(cell);

            cell = new Cell()
                    .add("цена договора российские рубли без НДС")
                    .setFontSize(8)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.LEFT);
            table1.addCell(cell);

            // добавляем стоимость договора без НДС!
            cell = new Cell()
                    .add(summ + "")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell);

            cell = new Cell()
                    .add("срок выполнения Договора")
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFont(font)
                    .setFontSize(8);
            table1.addCell(cell);

            // добавляем срок договора
            // по умолчанию "согласно договора"
            cell = new Cell()
                    .add("Согласно договора")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell);

            cell = new Cell()
                    .add("форма оплаты")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.LEFT);
            table1.addCell(cell);

            // добавляем форму оплаты
            // по умолчанию безналичная
            cell = new Cell()
                    .add("Безналичная")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell);

            cell = new Cell()
                    .add("сроки оплаты")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.LEFT);
            table1.addCell(cell);

            // добавляем необходимый срок оплаты
            // по умолчанию 45-60 дней
            cell = new Cell()
                    .add("45-60 дней")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell);

            cell = new Cell()
                    .add("порядок оплаты")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.LEFT);
            table1.addCell(cell);

            cell = new Cell()
                    .add("Согласно договору")
                    .setFont(font)
                    .setFontSize(8)
                    .setTextAlignment(TextAlignment.CENTER);
            table1.addCell(cell);

            SimpleDateFormat sf = new SimpleDateFormat("dd MMMM yyyy");

            // достаём данные по акктедитации
            String numberAkkr = null;
            String dateAkr = null;
            String numeCompanyAkkr = "Название компании кто аккредитовал";
//                    tender.getCompany().get(0).getSmallNameFormCompany() + " \"" +
//                    tender.getCompany().get(0).getSmallNameCompany() +"\"";
            // далее идёт проверка есть ли аккредитация на данную компанию. и добавляются все необходимые для этого тендера данные
//            for (int i = 0; i < company.getAkkredDocsCompany().get(0).getDocumentPdfDateInfoList().size(); i++){
//                DocumentPdfDateInfo doc = company.getAkkredDocsCompany().get(0).getDocumentPdfDateInfoList().get(i);
//                if (doc.getNameInfoCom().equals(numeCompanyAkkr)){
//                    numberAkkr = doc.getNumberDoc();
//                    dateAkr = sf.format(doc.getEndDate());
//                }
//            }

            // добавляем основной текст тела документа часть 2
            String bodyTextDoc2 =
                    "Настоящая заявка на участие в закупке имеет правовой статус оферты и действует " +
                            // здесь надо указать до какого срока действет
                            // по умолчанию указываю 180 дней
                            // но правильней указывать именно до какого числа, месяца и года
                            "до " +
                            "180 дней" +
                            ".\n" +
                            "В состав заявки включен подписанный со стороны " +
                            fullSizeNameCompany + " " +
                            "Договор и приложения к нему.\n" +
                            "Подавая заявку, подтверждаем:\n" +
                            "− готовность соблюдать стандарты ПАО «НК «Роснефть», размещенные на сайте \n" +
                            "ПАО «НК «Роснефть» по адресу: www.rosneft.ru и/или приложенные к проекту договора.\n" +
                            "− что подаваемая заявка является настоящей, что она не была согласована с " +
                            "иными участниками закупки и, что она подана с намерением принять предложение " +
                            "о заключении договора по результатам закупки и заключить договор;\n" +
                            "− соответствие требованиям в рамках должной осмотрительности №" +
                            // нужно реализовать что бы доставал информацию по аккредитации (должной осмотрительности)
                            numberAkkr + " от " +
                            dateAkr + " года.\n" +
                            "− соответствие всем требованиям, предъявляемым к Участникам закупки, которые " +
                            "указаны в Разделе 1.1 Блока 9 документации о закупке/извещения.\n" +
                            "\n" +
                            "Дополнительно сообщаем, что " +
                            fullSizeNameCompany +
                            " при составлении " +
                            // далее идёт информация не обменивались ли мы информацией с потенциальными участниками
                            // по умолчанию нет. но если хочется можно указать с кем и когда
                            // данную вешь необходимо реализовать
                            "данной заявки не осуществлялся информационный обмен с потенциальными участниками " +
                            "закупки в части участия в данной закупочной процедуре.\n";

            // добавляем последний текст тела документа
            // список прилогаемых документов
            String bodyTextDoc3 =
                    "Настоящая заявка на участие в закупке дополняется следующими документами:\n" +
                            "1. Коммерческое предложение " +
                            // нужно указать количество листов коммерческого предложения
                            // по умолчанию 1
                            "1 лист.\n" +
                    // по остальным пунктам временно не подаём информацию
//                            "2. План распределения объемов выполнения работ коллективного Участника " +
//                            "закупки (указать при необходимости с указанием количества листов приложения).\n" +
//                            "3. План распределения объемов выполнения работ между Участником закупки " +
//                            "и субподрядчиками (соисполнителями) (указать при необходимости с указанием " +
//                            "количества листов приложения).\n" +
                            // по умолчанию добавил 2 листа прочих документов
                            "2. Прочие документы 2 листа \n";
//                            "приложения).\n"

            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table4 = tableStampEndSignature.createTableStampEndSignature(company,font);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            Paragraph paragraphTopFullNameCom = new Paragraph(topFullNameFileDocCompany)
                    .setFont(font)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold();
            document.add(paragraphTopFullNameCom);

            Paragraph paragraphReqCom = new Paragraph(requisitesCompany)
                    .setFont(font)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphReqCom);

            Paragraph paragraphLine = new Paragraph(line)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphLine);

            Paragraph paragraphTopInfoCompany = new Paragraph(topInfoCompanyEndTender)
                    .setFont(font)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.LEFT);
            document.add(paragraphTopInfoCompany);

            Paragraph paragraphNameDoc = new Paragraph(nameDocCompany)
                    .setFont(font)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold();
            document.add(paragraphNameDoc);

            Paragraph paragraphBodyTextNameCom = new Paragraph(bodyTextNameCom)
                    .setTextAlignment(TextAlignment.RIGHT)
                    .setFont(font)
                    .setFontSize(10);
            document.add(paragraphBodyTextNameCom);

            document.add(table);

            Paragraph paragraphBodyTextDoc1 = new Paragraph(bodyTextDoc1)
                    .setFontSize(10)
                    .setFont(font);
            document.add(paragraphBodyTextDoc1);

            document.add(table1);

            Paragraph paragraphBodyTextDoc2 = new Paragraph(bodyTextDoc2)
                    .setFont(font)
                    .setFontSize(10);
            document.add(paragraphBodyTextDoc2);

            Paragraph paragraphBodyTextDoc3 = new Paragraph(bodyTextDoc3)
                    .setFont(font)
                    .setFontSize(10);
            document.add(paragraphBodyTextDoc3);

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
}
