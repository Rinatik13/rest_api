let res = localStorage.getItem('user');
let user_info = JSON.parse(res);
let employeeList = user_info.employeeList;
let list = document.getElementById('employee_list');
if(companyList === null){
    list.innerText = 'Сотрудники отсутствуют.';
}
else {
    for (let a = 0; a<companyList.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = companyList[a].smallNameCompany + " <button class=\"button\" name='" + a + "'>Информация</button> <button class=\"button\" name='"+ a +"'> Удалить</button>";
        document.querySelector('.list_company').appendChild(elem);
    }
}

