package com.calisto.spring.rest_api.forms.rosneft.work;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.owners.Owner;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// информация о собственниках (акционерах компании)
public class GeneratorDocForm2 implements GeneratorDoc{
    String nameFile = "Информация о собственниках";
    @Override
    public ByteArrayOutputStream launch(Company company, Tender tender, String date, double summ) {

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

            // добавляем информацию об участнике, инн и номер торгов
            String topInfoCompanyEndTender =
                    "Наименование Участника закупки: " + fullSizeNameCompany + "\n" +
                            "ИНН (или иной индификационный номер) Участника закупки: " +
                            company.getInnCompany() + "\n" +
                            "Наименование закупки: №" +
                            tender.getNumber() + " " +
                            tender.getName() + "\n";

            // добавляем название документа
            String nameDocCompany = "ИНФОРМАЦИЯ О СОБСТВЕННИКАХ (АКЦИОНЕРАХ) " +
                    fullSizeNameCompany +
                    " УЧАСТНИКА ЗАКУПКИ НА ВЫПОЛНЕНИЕ РАБОТ ДЛЯ ПАО \"НК \" РОСНЕФТЬ\" И " +
                    "ОБЩЕСТВ ГРУППЫ С УКАЗАНИЕМ ВСЕЙ ЦЕПОЧКИ СОБСТВЕННИКОВ, ВКЛЮЧАЯ " +
                    "БЕНЕФЕЦИАРОВ (В ТОМ ЧИСЛЕ КОНЕЧНЫХ)).\n";

            // добавляем текст после названия текста до таблицы (с указанием даты)
            String bodyDocText1 =
                    "по состоянию на " +
                            // тут надо добавить актуальную дату
                            // пока поставим по умолчанию
                            date +
                            ".\n";

            // далее идёт название следующей таблицы

            String nameDocTextTable2 =
                    "СВЕДЕНИЯ ОБ АФФИЛИРОВАННЫХ/ВХОДЯЩИХ В " +
                            "ГРУППУ ЛИЦАХ";

            // далее идёт таблица с информацией
            // по умолчанию заполняем Аффилированные и/или входящие
            // в группу лица отсутствуют

            Table table1 = new Table(7);
            addCell("№\n п/п",table1);
            addCell("Полное фирменное\n" +
                    "наименование\n" +
                    "(наименование для\n" +
                    "некоммерческой\n" +
                    "организации) или\n" +
                    "фамилия, имя,\n" +
                    "отчество\n" +
                    "аффилированного\n" +
                    "/входящего в группу\n" +
                    "лица", table1);
            addCell("Место нахождения\n" +
                    "юридического\n" +
                    "лица или место\n" +
                    "жительства\n" +
                    "физического лица\n" +
                    "(указывается только\n" +
                    "с согласия\n" +
                    "физического лица)", table1);
            addCell("Основание\n" +
                    " (основания), в\n" +
                    "силу которого\n" +
                    "лицо признается\n" +
                    "аффилированным\n" +
                    "/входящим в \n" +
                    "группу", table1);
            addCell("Дата\n" +
                    "наступления\n" +
                    "основания\n" +
                    "(оснований)", table1);
            addCell("Способ и\n" +
                    "доля участия\n" +
                    "аффилированного\n" +
                    "/входящего\n" +
                    "в группу\n" +
                    "лица", table1);


            // если есть аффилированность то заполняем эту часть таблицы
            // по умолчанию "Аффилированные и/или входящие в группу лица отсутствуют"
        Cell cell;
            for (int i = 0; i < 8; i++) {
                cell = new Cell()
                        .add("Аффилированные и/или входящие в группу лица отсутствуют")
                        .setFont(font)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setFontSize(8);
                table1.addCell(cell);
            }

            // добавляем печать и подпись
            TableStampEndSignature tableStampEndSignature = new TableStampEndSignature();
            Table table2 = tableStampEndSignature.createTableStampEndSignature(company, font);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            String inter = "\n";
            Paragraph inP = new Paragraph(inter);

            // добавляем название компании в шапке
            Paragraph paragraphTopNameCompany = new Paragraph(topFullNameFileDocCompany);
            paragraphTopNameCompany.setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(12);
            document.add(paragraphTopNameCompany);

            // добавляем реквизиты компании в шапке
            Paragraph paragraphReqCom = new Paragraph(requisitesCompany);
            paragraphReqCom.setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(10);
            document.add(paragraphReqCom);

            // добавляем разделительную линию
            Paragraph paragraphLine = new Paragraph(line)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(paragraphLine);

            // добавляем инфу об участнике и название закупки
            Paragraph paragraphtopInfoCompany = new Paragraph(topInfoCompanyEndTender);
            paragraphtopInfoCompany.setFont(font)
                    .setTextAlignment(TextAlignment.LEFT)
                    .setFontSize(10);
            document.add(paragraphtopInfoCompany);
            document.add(inP);

            // добавляем название документа
            Paragraph paragraphNameDoc = new Paragraph(nameDocCompany);
            paragraphNameDoc.setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setBold();
            document.add(paragraphNameDoc);
            document.add(inP);

            // добавляем текстовое тело документа до таблицы
            Paragraph paragraphBodyDocText1 = new Paragraph(bodyDocText1);
            paragraphBodyDocText1.setFont(font)
                    .setFontSize(10);

            // добавляем таблицу с информацией о собственниках
            createOwners(document,company);

            document.add(inP);

            // добавляем текстовое тело документа после таблицы 1 до таблицы 2
            // простой заголовок
            Paragraph paragraphNameDocText2 = new Paragraph(nameDocTextTable2);
            paragraphNameDocText2.setFont(font)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12)
                    .setBold();
            document.add(paragraphNameDocText2);
            document.add(inP);

            // добавляем таблицу с аффилированностью
            document.add(table1);
            document.add(inP);

            // добавляем подписантов
            document.add(table2);

            // закрываем документ
            document.close();
            return byteArrayOutputStream;
        }

    private void createOwners(Document document,Company company) {
        List<Owner> owners = company.getOwners();
        //создаём таблицу
        Table table = new Table(3);

        // добавляем шапки
        addCell("Наименование организации\n" +
                "(наименование, место\n" +
                "нахождения, ИНН",table);

        addCell("Собственники (акционеры)\n" +
                "организации, с указанием доли в %\n" +
                "(наименование, место нахождения\n" +
                "(страна), ИНН", table);

        addCell("Подтверждающие\n" +
                "документы, наименование,\n" +
                "реквизиты, паспортные данные\n" +
                "(в т.ч. гражданство)", table);

        //добавляем главную шапку для первого раздела

        addTableHideText("I. Организация-Участник закупки", table);

        List<Owner> ownerList2 = new ArrayList<>();
        List<Owner> ownerList3 = new ArrayList<>();
        Map<Integer,List<Owner>> mapOwner = new HashMap<>();

        addMainOwnersToList(owners, ownerList2, table, company);

        addTableHideText("II. Юридические лица, являющиеся собственниками организации" +
                " - Участника закупки.",table);
        // необходимо сделать заполнение таблицы не основными учредителями
        for (int i = 0; i<ownerList2.size(); i++){
            System.out.println("запускаем цыкл добавления учредителя");
            Owner owner = ownerList2.get(i);
            System.out.println("добавляем не основного учредителя: " + owner);
            addOwnersToList(owner,ownerList3,table);
        }

        addTableHideText("III. Юридические лица, являющиеся собственниками собственников" +
                " организации - Участника закупки.",table);

        ownerList2 = new ArrayList<>();
        for (int i = 0; i<ownerList3.size(); i++){
            Owner owner = ownerList2.get(i);
            addOwnersToList(owner,ownerList2,table);
        }
        addTableHideText("IV. Юридические лица, являющиеся собственниками " +
                "следующих уровней (до конечных) ...", table);

        for (int i = 0; i<ownerList3.size(); i++){
            Owner owner = ownerList2.get(i);
            addOwnersToList(owner,ownerList2,table);
        }

        document.add(table);
    }

    private void addTableHideText(String text, Table table) {

        BaseFont baseFont = new BaseFont();
        PdfFont font = baseFont.getFont();

        Cell cell;
        cell = new Cell(1, 3)
                .add(text)
                .setFont(font)
                .setTextAlignment(TextAlignment.LEFT)
                .setFontSize(8)
                .setBold();
        table.addCell(cell);

    }

    private void addMainOwnersToList(List<Owner> owners,
                                 List<Owner> ownerList,
                                 Table table,
                                 Company company) {
        for (int i = 0; i<owners.size();i++) {
            Owner owner = owners.get(i);
            System.out.println(owner);
            addCell(company.getSmallNameCompany() + ", " +
                    company.getAddressCompany() + ", " +
                    company.getInnCompany(), table);

            addCell(owner.getShare() + "%, " +
                    owner.getName() + ", " +
                    owner.getCountry() + ", " +
                    owner.getIdentifier(), table);

            addCell(owner.getRecvisites(), table);

            System.out.println("Готовимся добавлять список учредителей");
            if (owner.getOwners().size() > 0) {
                ownerList.addAll(owner.getOwners());
                System.out.println("Новый список учредителей" + ownerList);
            }
        }
    }

//    private void addOwnersToList(List<Owner> owners,
//                                     List<Owner> ownerList,
//                                     Table table) {
//        for (int i = 0; i<owners.size();i++) {
//            Owner owner = owners.get(i);
//            System.out.println(owner);
//            addCell(owner.getName() + ", " +
//                    owner.getCountry() + ", " +
//                    owner.getIdentifier(), table);
//
//            addCell(owner.getShare() + "%, " +
//                    owner.getName() + ", " +
//                    owner.getCountry() + ", " +
//                    owner.getIdentifier(), table);
//
//            addCell(owner.getRecvisites(), table);
//
//            System.out.println("Готовимся добавлять список учредителей");
//            if (owner.getOwners().size() > 0) {
//                ownerList.addAll(owner.getOwners());
//                System.out.println("Новый список учредителей" + ownerList);
//            }
//        }
//    }

    private void addOwnersToList(Owner mainOwner,
                                     List<Owner> ownerList,
                                     Table table) {
        List<Owner> owners = mainOwner.getOwners();
        for (int i = 0; i < owners.size();i++) {
            Owner owner = owners.get(i);
            System.out.println(owner);
            if (owner.getOwners().size() < 1) {
               owner = mainOwner;
            }
            else {
                ownerList.addAll(owner.getOwners());
            }
            addCell(mainOwner.getName() + ", " +
                    mainOwner.getCountry() + ", " +
                    mainOwner.getIdentifier(), table);
            addCell(owner.getShare() + "%, " +
                    owner.getName() + ", " +
                    owner.getCountry() + ", " +
                    owner.getIdentifier(), table);
            addCell(owner.getRecvisites(), table);
        }
    }

    @Override
    public String getNameFile() {
        return nameFile;
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
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(8);
        table.addCell(cell);
    }
}
