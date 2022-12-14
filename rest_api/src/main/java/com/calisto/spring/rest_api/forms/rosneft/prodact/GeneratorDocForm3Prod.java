package com.calisto.spring.rest_api.forms.rosneft.prodact;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Contract;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.forms.rosneft.work.GeneratorDoc;
import com.calisto.spring.rest_api.logic.TableStampEndSignature;
import com.calisto.spring.rest_api.style.BaseFont;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.geom.PageSize;
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

// форма № 3 список договоров с информацией по ним
public class GeneratorDocForm3Prod implements GeneratorDoc {
    String fileName = "Список договоров";
    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {

            BaseFont baseFont = new BaseFont();
            PdfFont font = baseFont.getFont();

            String fullSizeNameCompany = company.getSmallNameCompany();

            // добавляем информацию о участнике, инн и номер торгов
            String topInfoCompanyEndTender =
                    "Наименование Участника закупки: " + fullSizeNameCompany + "\n" +
                            "ИНН (или иной индификационный номер) Участника закупки: " +
                            company.getInnCompany() + "\n" +
                            "Наименование закупки: №" +
                            tender.getNumber() + " " +
                            tender.getName() + "\n";

            // название документа
            String docName =
                    "СВЕДЕНИЯ ОБ ОПЫТЕ ВЫПОЛНЕНИЯ АНАЛОГИЧНЫХ ДОГОВОРОВ";

            // текст тела документа до таблицы с договорами
            String bodyTextDoc1 =
                    "При этом под анологичными договорами понимаются договоры на " +
                            "поставку  " +
                            tender.getName() + ".\n";

            // таблица со списком договором, по сути дела огромный документ.
            // самый большой
            Table bigTable = new Table(8);
            addCell("№", bigTable);
            addCell("Предмет Договора", bigTable);
            addCell("Наименование Заказчика,\n" +
                    "адрес и контактный телефон/факс Заказчика,\n" +
                    "контактное лицо\n",bigTable);
            addCell("Полная сумма\n" +
                    "Договора, руб.",bigTable);
            addCell("Дата заключения/\n" +
                    "завершения (месяц, год,\n" +
                    "процент выполнения)", bigTable);
            addCell("Роль\n" +
                    "(поставщик, субподрядчик\n" +
                    "(соисполнитель), партнер)\n" +
                    "и объем поставки товара по Договору, %",bigTable);
            addCell("Сведения о\n" +
                    "претензиях\n" +
                    "Заказчика к\n" +
                    "выполнению\n" +
                    "обязательств",bigTable);
            addCell("Наличие\n" +
                    "прилагаемых\n" +
                    "отзывов от\n" +
                    "Заказчиков\n" +
                    "(есть/нет)",bigTable);


            // реализуем алгоритм вывода информации по договорам
            int countContact = company.getContractList().size();
            int i = 1;
            // создаём лист контрактов компании
            List<Contract> listContactCom = company.getContractList();
            // создаём пустой контракт с которым будем работать
            Contract pdfContract = null;

            for (int a = 0; a< listContactCom.size(); a++){
                // задаём формат даты
                SimpleDateFormat sf = new SimpleDateFormat("dd MMMM yyyy");

                // добавляем данные в таблицу по контракту

                pdfContract = listContactCom.get(a);
                addCell(i + "\n",bigTable);

                // предмет договора
                addCell(pdfContract.getName(),bigTable);
                // наименование заказчика
                addCell(pdfContract.getSmileNameZakaz()+ ", инн: " + pdfContract.getInnZakaz() + ", " + pdfContract.getAddressZakaz(),bigTable);

                // Полная сумма договора
                addCell(pdfContract.getSumm()+" руб.",bigTable);

                // Дата заключения/завершения договора
                addCell(
                        (pdfContract.getDate()) + " / " +
                                (pdfContract.getEndDate()) + ", 100%",bigTable);

                // Роль участника
                addCell("Субподрядчик, 100%",bigTable);

                // Сведения о претензиях
                // по умолчанию нету
                addCell("\n",bigTable);

                // Наличие прилагаемых отзывов
                // по умолчанию нету
                addCell("\n",bigTable);
            i++;
            }
            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table2 = tableStampEndSignature.createTableStampEndSignature(company,font);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument, PageSize.A4.rotate());
            String inter = "\n";
            Paragraph inP = new Paragraph(inter);

            // добавляем информацию по закупке
            Paragraph paragraphInfoCom = new Paragraph(topInfoCompanyEndTender)
                    .setFont(font)
                    .setFontSize(10)
                    .setTextAlignment(TextAlignment.LEFT);
            document.add(paragraphInfoCom);
            document.add(inP);

            // добавляем название документа
            Paragraph paragraphDocName = new Paragraph(docName)
                    .setFont(font)
                    .setFontSize(12)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold();
            document.add(paragraphDocName);
            document.add(inP);

            // добавляем текст тела документа до таблицы
            Paragraph paragraphBodyText1 = new Paragraph(bodyTextDoc1)
                    .setFont(font)
                    .setFontSize(10);
            document.add(paragraphBodyText1);
            document.add(inP);

            // добавляем таблицу со списком договоров
            document.add(bigTable);
            document.add(inP);

            // добавляем подписантов
            document.add(table2);

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

    private void addCell(String text, Table table) {
        BaseFont baseFont = new BaseFont();
        PdfFont font = baseFont.getFont();
        Cell cell = new Cell();
        cell.add(text)
                .setFont(font)
                .setFontSize(8)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE);
        table.addCell(cell);
    }
}
