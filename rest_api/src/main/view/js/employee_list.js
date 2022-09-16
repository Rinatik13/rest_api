let res = localStorage.getItem('company');
let company = JSON.parse(res);
let employees = company.employeeList;
let list = document.getElementById("employee_list")

document.getElementById("list_count").innerHTML = employees.length;

if(employees === null){
    list.innerText = 'Компании отсутствуют.';
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