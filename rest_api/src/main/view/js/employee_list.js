let res = localStorage.getItem('company');
let company = JSON.parse(res);
let employees = company.employeeList;
let list = document.getElementById("employee_list")

document.getElementById("list_count").innerHTML = employees.length;

if(employees === null){
    list.innerText = 'Сотрудники отсутствуют';
}
else {
    for (let a = 0; a<employees.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = "№"+ (a+1) + " " + employees[a].surname + " " + employees[a].name + " " + employees[a].patronymic + " " + employees[a].positionCom +" <button class=\"button button_info\" name='" + a + "'>Информация</button> <button class=\"button button_delete\" name='"+ a +"'> Удалить</button><br><br>";
        document.querySelector('.list_component').appendChild(elem);
    }
}
const button_info = document.querySelectorAll(".button_info");

const openHtml = (event) =>{
    let empl_num = parseInt(event.target.name);
    let empl = employees[empl_num];
    localStorage.setItem("employee",JSON.stringify(empl));
    window.location = "http://127.0.0.1:5500/employeeinfo.html";
    console.log(empl)
}

button_info.forEach(button_info =>{
    button_info.addEventListener('click', openHtml);    
    }) 

const clearEmployee = (event) => {
    localStorage.removeItem('employee');
}

const button_add = document.querySelector("#addEmployee");

button_add.addEventListener('click', clearEmployee);


const button_delete = document.querySelectorAll(".button_delete");

async function deleteElement (event){
    let element_num = parseInt(event.target.name);
    let element_id = employees[element_num].id;
    // создаём рест запрос на удаление объекта по id
    await fetch('http://localhost:8080/api/calisto/employee/delete/' + element_id)
        .then(response => response.json())
        .then(json => {
            console.log(json);
            window.location = "http://127.0.0.1:5500/employeeList.html"
        }
        );
}

button_delete.forEach(button_delete =>{
    button_delete.addEventListener('click', deleteElement);    
}) 
