let res = localStorage.getItem('user');
let user_info = JSON.parse(res);
let companyList = user_info.companyList;
let list = document.getElementById('company_list');
if(companyList === null){
    document.getElementById('company_list').innerText = 'Компании отсутствуют.';
}
else {
    for (let a = 0; a<companyList.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = companyList[a].smallNameCompany + " <button class=\"button\" name='" + a + "'>Информация</button> <button class=\"button\" name='"+ a +"'> Удалить</button>";
        document.querySelector('.list_company').appendChild(elem);
    }
}

