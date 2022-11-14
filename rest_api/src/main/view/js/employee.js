let resCompany = localStorage.getItem('company');
let company = JSON.parse(resCompany);
let res = localStorage.getItem('employee');
let employee = JSON.parse(res);
let empl_doc_list = employee.documentPdfList;
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

let list = document.getElementById('doc_list');

// тут реализуем добавление списка документов
if(empl_doc_list === null){
    list.innerText = 'Список пуст.';
}
else {
    for (let a = 0; a<empl_doc_list.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = "№ " + (a+1) + empl_doc_list[a].name + " <button class=\"button\" name='" + a + "'>Информация</button> <button class=\"button\" name='"+ a +"'> Удалить</button>";
        document.querySelector('.doc_list').appendChild(elem);
    }
}


document.querySelector('button').addEventListener('click', uploadFile);

async function uploadFile(event){
event.preventDefault();

let el = document.getElementById('file_name');

let file = document.getElementById('file').files[0];
let reader = new FileReader();
reader.readAsBinaryString(file)
reader.onload = async function(){
    documentPdf = {
        name : el.value,
        body : reader.result,
        company_id : company.id,
        block : "employees",
        block_id : employee.id
    }
    console.log(documentPdf);

    await fetch('http://localhost:8080/api/calisto/documentpdf/add',{
        method: 'POST',
        body: JSON.stringify(documentPdf),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
        }
            );
        window.location = "http://127.0.0.1:5500/employeeinfo.html"
}
reader.onerror = function(){
    console.log(reader.error);
}
}