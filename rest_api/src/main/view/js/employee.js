let res = localStorage.getItem('employee');
let employee = JSON.parse(res);
let empl_inf = document.getElementById('employee');


addressReg.innerHTML = employee.addressReg;
dateTrud.innerHTML = employee.dateTrud;
govermentStatus.innerHTML = employee.govermentStatus;
heppyDate.innerHTML = employee.heppyDate;
inn.innerHTML = employee.inn;
empl_name.innerHTML = employee.name;
passportGovDate.innerHTML = employee.passportGovDate;
passportGovName.innerHTML = employee.passportGovName;
passportNumber.innerHTML = employee.passportNumber;
passportSerial.innerHTML = employee.passportSerial;
patronymic.innerHTML = employee.patronymic;
positionCom.innerHTML = employee.positionCom;
snils.innerHTML = employee.snils;
surname.innerHTML = employee.surname;
telephoneNumber.innerHTML = employee.telephoneNumber;

// тут реализуем добавление списка документов
// if(companyList === null){
//     list.innerText = 'Сотрудники отсутствуют.';
// }
// else {
//     for (let a = 0; a<companyList.length; a++){
//         let elem = document.createElement('div');
//         elem.innerHTML = companyList[a].smallNameCompany + " <button class=\"button\" name='" + a + "'>Информация</button> <button class=\"button\" name='"+ a +"'> Удалить</button>";
//         document.querySelector('.list_company').appendChild(elem);
//     }
// }

