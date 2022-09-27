package com.calisto.spring.rest_api.forms.rosneft;

import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Tender;
import com.calisto.spring.rest_api.logic.SpisokSpravok;

import java.util.Iterator;
import java.util.Map;
// в этом классе реализуем тело документа для дальнейшей сборки для itext
public class DocGeneratorsPDF {
    public void generatorLaunch(Company company,
                                Tender tender,
                                SpisokSpravok documentMapList,
                                String dateDoc){
        Map<String, Boolean> map = documentMapList.generatorMapList();
        Iterator < Map.Entry<String,Boolean>> iterator = map.entrySet().iterator();
        int numberDoc = 1;
        while (iterator.hasNext()){
            ConvPdf convPdf = new ConvPdf();
            Map.Entry<String, Boolean> myMapList = iterator.next();
            String key = myMapList.getKey();
            Boolean value = myMapList.getValue();
            if (value){
                switch (key){
                    case "Наличие людских ресурсов":
                        convPdf.launch(company,
                                "Гарантийное письмо.",
                                dateDoc,
                                 company.getSmallNameCompany() + " " +
                                        "гарантирует наличие свободных людских ресурсов не менее " +
                                        tender.getCountEmployee() + " " +
                                        "человек готовых выполнить работы по закупке: №" +
                                        tender.getNumber() + " " +
                                        tender.getName() + ".",
                                numberDoc);
                    numberDoc++;
                        break;

                    case "Не эксплуатируем объекты 1 и 2 кл опасности":
                        convPdf.launch(company,
                                "Информационное письмо.",
                                dateDoc,
                                "По запросу на предмет закупки: №"+ tender.getNumber() + " " +
                                tender.getName() +
                                "." +
                                " Сообщаем что, " +
                                company.getSmallNameCompany() +
                                " " +
                                "не относится к предприятию, эксплуатирующему опасные " +
                                        "производственные отбъекты 1 и 2 класса " +
                                        "опастности.",numberDoc);
                        numberDoc++;
                        break;

                    case "Отсутствие судебных разбирательств":
                        convPdf.launch(company,
                        "Отсутствие судебных разбирательств.",
                        dateDoc,
                                company.getSmallNameCompany() + " " +
                                "сообщает об отсутствии в течении 24 месяца до момента окончания срока" +
                                " подачи заявок на участие в закупке и в течение срока проведения" +
                                " процедуры закупки до подведения её итогов случаев судебных разбирательств" +
                                " в качестве ответчика с ПАО \"НК \"Роснефть\" или Обществом Группы в с вязи с" +
                                " нарушениеми договора, исковые требования по которым были удовлетворены, а также" +
                                " случаев расторжения с ПАО \"НК \"Роснефть\" или Обществом Группы в одностороннем" +
                                "порядке договора в связи с нарушениями его условий",
                        numberDoc);
                        numberDoc++;
                        break;

                    case "Согласие с договором":
                        convPdf.launch(company,
                                "Согласие с договором.",
                                dateDoc,
                                company.getSmallNameCompany() + " " +
                                "согласны со всеми условиями договора, без возможности внесения каких-либо" +
                                        " изменений или дополнений в приложенный к документации проект" +
                                        " договора по закупке №" +
                                        tender.getNumber() + " " +
                                        tender.getName() + ".",
                                numberDoc
                                );
                        numberDoc++;
                        break;

                    case "Согласие с выполнением работ":
                        convPdf.launch(company,
                        "Согласие с выполнением работ.",
                        dateDoc,
                                        company.getSmallNameCompany() + " " +
                                        "согласны выполнить работы собственными силами в 100% объёме" +
                                        " по закупке №" +
                                        tender.getNumber() + " " +
                                        tender.getName() + ".",
                        numberDoc);
                        numberDoc++;
                        break;

                    case "Согласие со сроком оплаты":
                        convPdf.launch(company,
                                "Согласие со сроком оплаты.",
                        dateDoc,
                                        company.getSmallNameCompany() + " " +
                                        "согласны с установленными в закупочной документации" +
                                        " условиями оплаты работы по закупки №" +
                                        tender.getNumber() + " " +
                                        tender.getName() + ".",
                        numberDoc);
                        numberDoc++;
                        break;

                    case "Привлекаем собственный транспорт":
                        convPdf.launch(company,
                                "Информационное письмо о привлечение собственного транспорта.",
                                dateDoc,
                        "Настоящим участник закупки " +
                                company.getSmallNameCompany() + " " +
                                "находящийся (зарегистрированный) по адресу: " +
                                company.getAddressCompany() +
                                ", сообщает, что планирует привлекать собственный транспорт для выполнения" +
                                " работ по закупке №" +
                                tender.getNumber() + " " +
                                tender.getName() + ".",
                        numberDoc);
                        numberDoc++;
                        break;

                    case "Гарантийное письмо о наличии СИЗ и прочего":
                        convPdf.launch(company,
                                "Гарантийное письмо о наличии средств защиты изолирующего типа.",
                                dateDoc,
                        "Настоящим участник закупки " +
                                company.getSmallNameCompany() + " " +
                                "находящийся (зарегистрированный) по адресу: " +
                                company.getAddressCompany() +
                                ", сообщает, о наличии средств защиты изолирующего типа обеспечивающие" +
                                " возможность перемещения по всему объекту, 1 комплект для исполнения работ," +
                                " 1 комплект для наблюдающего и 1 комплект для дублёра. Наличие достаточного" +
                                " количества для выполнения работ 4-х канальных портативных газоанализаторов.",
                        numberDoc);
                        numberDoc++;
                        break;

                    case "Согласие идти в субподряд":
                        convPdf.launch(company,
                                "Согласие идти в субподряд.",
                                dateDoc,
                        "Настоящим сообщаем, что компания " +
                                company.getSmallNameCompany() + " " +
                                "осведомлена о своём привлечении в качестве субподрядной организации " +
                                "НАЗВАНИЕ ОРГАНИЗАЦИИ ГЕНЧИК" +
                                " по закупочной процедуре №" +
                                tender.getNumber() +
                                tender.getName() + " " +
                                "и согласна принять обязательства в соответствии с техническим заданием" +
                                " по выделяемому объёму, сроку его выполнения, по видам работ: " +
                                "ОСНОВНЫЕ ВИДЫ РАБОТ.",numberDoc);
                        numberDoc++;
                        break;

                    case "Согласие на проведение добровольного технического аудита":
                        convPdf.launch(company,
                                "Согласие на проведение добровольного технического аудита.",
                                dateDoc,
                                        company.getSmallNameCompany() + " " +
                                        "даёт согласие на проведение добровольного технического аудита " +
                                        "производственных мощностей и документации, " +
                                        "подтверждающей соответствие технического задания, согласно " +
                                        "прилагаемой программы по закупке: №" +
                                        tender.getNumber() + " " +
                                        tender.getName() +
                                        " после признания победителем.",numberDoc);
                        numberDoc++;
                        break;

                    case "Согласие на выполнение работ в соответствии с техническим заданием":
                        convPdf.launch(company,
                                "Согласие на выполнение работ в соответствии с техническим заданием.",
                                dateDoc,
                        "Настоящим сообщаем, что компания " +
                                company.getSmallNameCompany() + " " +
                                "даёт согласие на выполнение работ в соответствии с техническим заданием " +
                                ", локальными сметным ресурсным расчётом и разделительным протоколом на поставку" +
                                " материалов, без возможности внесения каких-либо изменений или дополнений в " +
                                "приложенных к документации проект договора по закупочной процедуре №" +
                                tender.getNumber() + " " +
                                tender.getName() + ".", numberDoc);
                        numberDoc++;
                        break;

                    case "Согласие на изменение объёма":
                        convPdf.launch(company,
                                "Согласие на изменение объёма.",
                                dateDoc,
                        "Настоящим сообщаем, что компания " +
                                company.getSmallNameCompany() + " " +
                                "даёт согласие на включение в договор условия о праве Генерального подрядчика" +
                                " изменить объём опциона, без изменения остальных согласованных условий " +
                                "по закупочной процедуре: №" +
                                tender.getNumber() + " " +
                                tender.getName() + ".", numberDoc);
                        numberDoc++;
                        break;
                }
            }
        }
    }

}
