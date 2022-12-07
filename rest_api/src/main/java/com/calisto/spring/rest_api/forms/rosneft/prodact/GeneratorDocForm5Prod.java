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
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

// формируем сведения по кадровым ресурсам
public class GeneratorDocForm5Prod implements GeneratorDoc {
    String fileName = "Сведения о кадровых ресурсах";
    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {

            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            // краткое название компании с ковычками
            String fullSizeNameCompany =  company.getSmallNameCompany();

            // добавляем информацию об участнике, инн и номер торгов
            String topInfoCompanyEndTender =
                    "Наименование Участника закупки: " + fullSizeNameCompany + "\n" +
                            "ИНН (или иной индификационный номер) Участника закупки: " +
                            company.getInnCompany() + "\n" +
                            "Наименование закупки: №" +
                            tender.getNumber() + " " +
                            tender.getName() + "\n";

            // добавляем название документа
            String nameDocCompany = "СВЕДЕНИЯ О КАДРОВЫХ РЕСУРСАХ\n";

            // добавляем таблицу со списком сотрудников, общее количество
            // надо потом реализовать цыкл с выдачей всех работников компании

            // итоговое количество сотрудников
            int countSummEmpl = 0;

            // итоговое количество сотрудников для привлечения к работе
            int countSummEmplWork = 0;

            Table table = new Table(5);
            addCell("№\n" +
                    "п/п",table);
            addCell("Наименование показателей",table);
            addCell("Кол-во человек, подразделения",table);
            addCell("Место нахождения",table);
            addCell("Количество человек, " +
                    "которые Участник закупки собирается " +
                    "использовать при выполнении Договора",table);


            for (int i = 1; i < 6; i++) {
                addCell(i + "\n",table);
            }

            // **********************************************************************
            // Необходимо реализовать цыкл и сборку данных по должностям. конкретно. можно попробывать всех работников
            // здесь надо реализовать выдачу всех данных по кадрам
            // ********************************************
            // количество людей должно быть не меньше минимального количества в закупочной документации
            // !!! желательно, указывать строго необходимое количество сотрудников.!!!
            // добавляем кол-во людей
                int countEmpl = company.getEmployeeList().size();
//

                countSummEmpl = countSummEmpl+countEmpl;
                addCell(countEmpl + "",table);
                addCell(" ", table);
                addCell(" ", table);
                // добавляем место нахождение отдела
                addCell(company.getAddressCompany(),table);

                // добавляем количество человек которое участник собирается использовать
                countSummEmplWork = countSummEmplWork + countEmpl;
                addCell(countEmpl + "",table);

                addCell("X", table);
                addCell("ВСЕГО", table);
                addCell(countSummEmpl + "",table);
                addCell("\n",table);
                addCell(countSummEmplWork + "",table);
//*******************************************************************************************

            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table2 = tableStampEndSignature.createTableStampEndSignature(company,font);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            String inter = "\n";
            Paragraph inP = new Paragraph(inter);

            // добавляем информацию о закупки
            Paragraph paragraphTopInfo = new Paragraph(topInfoCompanyEndTender)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(10);
            document.add(paragraphTopInfo);
            document.add(inP);

            // добавляем информацию о названии документа
            Paragraph paragraphNameDoc = new Paragraph(nameDocCompany)
                    .setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setBold();
            document.add(paragraphNameDoc);
            document.add(inP);

            // добавляем таблицу по МТР
            document.add(table);
            document.add(inP);

            // добавляем подписанта
            document.add(table2);


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

    private void addCell(String text, Table table) {
        BaseFont baseFont = new BaseFont();
        PdfFont font = baseFont.getFont();
        Cell cell = new Cell()
                .add(text)
                .setFont(font)
                .setFontSize(8)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE);
        table.addCell(cell);
    }
}
