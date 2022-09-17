document.getElementById("add_employee").addEventListener("submit", addEmployee)

let user = localStorage.getItem('user');
let company_res = localStorage.getItem('company');
let company = JSON.parse(company_res)

// добавляем механизм сохранения нового сотрудника
    let el = document.getElementById("add_employee");
    let res = localStorage.getItem("employee");
    let employee = JSON.parse(res);
if(employee !== null){
   el.empl_name.value = employee.name;
    el.empl_surname.value = employee.surname;
    el.empl_patronymic.value = employee.patronymic;
    el.empl_positionCom.value = employee.positionCom;
    el.empl_heppyDate.value = employee.heppyDate;
    el.empl_dateTrud.value =employee.dateTrud;
    el.empl_telephoneNumber.value = employee.telephoneNumber;
    el.empl_addressReg.value = employee.addressReg;
    el.empl_inn.value = employee.inn;
    el.empl_passportSerial.value = employee.passportSerial;
    el.empl_passportNumber.value = employee.passportNumber;
    el.empl_passportGovDate.value = employee.passportGovDate;
    el.empl_passportGovName.value = employee.passportGovName;
    el.empl_snils.value = employee.snils;
    el.empl_govermentStatus.value =employee.govermentStatus; 
    el.empl_id.value = employee.id;
}
async function addEmployee(event){
    event.preventDefault();
    console.log(company);
    employee = {
    name : el.empl_name.value,
    surname : el.empl_surname.value,
    patronymic : el.empl_patronymic.value,
    positionCom : el.empl_positionCom.value,
    heppyDate : el.empl_heppyDate.value,
    dateTrud : el.empl_dateTrud.value,
    telephoneNumber :el.empl_telephoneNumber.value,
    addressReg : el.empl_addressReg.value,
    inn : el.empl_inn.value,
    passportSerial : el.empl_passportSerial.value,
    passportNumber : el.empl_passportNumber.value,
    passportGovDate : el.empl_passportGovDate.value,
    passportGovName : el.empl_passportGovName.value,
    snils : el.empl_snils.value,
    govermentStatus : el.empl_govermentStatus.value,
    company_id : company.id,
    id :el.empl_id.value
    }
console.log(employee);
    await fetch('http://localhost:8080/api/calisto/employee/add',{
        method: 'POST',
        body: JSON.stringify(employee),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
            // let res = JSON.parse(json)
            // новое надо добавить
            // а старое значение если оно было то убрать! реализовать функционал
            let empl_list = company.employeeList;
            let res_list = [];
            for (let a = 0; a < empl_list.length; a++){
                let empl = empl_list[a];
                if (empl.id !=json.id){
                    res_list.push(empl);
                }
            }
            company.employeeList = res_list;
            company.employeeList.push(json);
            localStorage.setItem('company', JSON.stringify(company));
        }
            );
        window.location ='http://127.0.0.1:5500/employeeList.html';

}