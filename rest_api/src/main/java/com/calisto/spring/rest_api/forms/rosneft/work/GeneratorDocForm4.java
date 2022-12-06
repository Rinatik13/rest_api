package com.calisto.spring.rest_api.forms.rosneft.work;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Oborudovanie;
import com.calisto.spring.rest_api.entity.Tender;
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

import java.text.SimpleDateFormat;
import java.util.List;

// создаём сведения о материально-технических ресурсах
public class GeneratorDocForm4 implements GeneratorDoc{
    String fileName = "Сведения о материально-технических ресурсах";
    @Override
    public ByteArrayOutputStream launch (Company company, Tender tender, String date, double summ) {
            // добавляем шрифт для отображения Русского языка в пдф
            // стандартный шрифт для всего документа
            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            // краткое название компании с ковычками
            String fullSizeNameCompany = company.getSmallNameCompany();

            // добавляем информацию о участнике, инн и номер торгов
            String topInfoCompanyEndTender =
                    "Наименование Участника закупки: " + fullSizeNameCompany + "\n" +
                            "ИНН (или иной индификационный номер) Участника закупки: " +
                            company.getInnCompany() + "\n" +
                            "Наименование закупки: №" +
                            tender.getNumber() + " " +
                            tender.getName() + "\n";

            // добавляем название документа
            String nameDocCompany = "СВЕДЕНИЯ О МАТЕРИАЛЬНО-ТЕХНИЧЕСКИХ РЕСУРСАХ\n";

            // добавляем таблицу с мтр
            // надо потом реализовать цыкл с выдачей всех ресурсов компании(оборудования
            // и прочего)
            SimpleDateFormat sf = new SimpleDateFormat("yyyy");

            Table table = new Table(8);
            addCell("№\n" +
                    "п/п", table);
            addCell("Наименование",table);
            addCell("Производитель, страна\n" +
                    "производства, марка,\n" +
                    "модель, основные\n" +
                    "технические\n" +
                    "характеристики",table);
            addCell("Год\n" +
                    "выпуска",table);
            addCell("%\n" +
                    "аморт\n" +
                    "изаци\n" +
                    "и",table);
            addCell("Принадлежность\n" +
                    "(собственность,\n" +
                    "арендованный)",table);
            addCell("Кол-во\n" +
                    "единиц",table);
            addCell("Примеча\n" +
                    "ния",table);

            for (int b = 1; b < 9; b++){
                addCell(b + "\n",table);
            }


            // реализуем механизм добавления техники в таблицу

            List<Oborudovanie> arrayListTransport = company.getOborudovanieList();
//            List<OborudovanieDoc> arrayListOborudovanie = company.getOborudovanieInfoDoc().get(0).getArrayListOborudovatieDoc();

            int i = 1;
            for (int a = 0; a < arrayListTransport.size(); a++) {
                Oborudovanie transportDoc = arrayListTransport.get(a);

                // порядковый номер
                addCell("" + i + "\n",table);

                // Наименование
                addCell(transportDoc.getName(),table);

                // Производитель, страна производства, марка, модель, основные тех
                // характеристики
                addCell(transportDoc.getModel(),table);

                // Год выпуска
                addCell(
//                        sf.format
                        (transportDoc.getDate()),table);

                // % амортизации
                // нужна ли амортизация неизвестно
                addCell(" ", table);

                // Принадлежность (собственность, арендованный)
                String statusArend = "собственность";
                if (transportDoc.getStatus().equals("арендованный")){
                    statusArend = "арендованный";
                }

                addCell(statusArend,table);


                // Кол-во единиц
                addCell("1",table);

                // Примечание
                // обычно взрывозащищённое или нет
                addCell(transportDoc.getPs(),table);
                i++;
            }

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
