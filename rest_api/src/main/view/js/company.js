let result = localStorage.getItem('user');
let user = JSON.parse(result);

document.addEventListener("DOMContentLoaded", loadList)

async function loadList(){
await fetch('http://localhost:8080/api/calisto/user/get',{
                    method: 'POST',
                    body: JSON.stringify(user),
                    headers:  {
                        'Content-Type': 'application/json',
                    },
                    }
                    )
                    .then(response => response.json())
                    .then(json => {
                        console.log(json);
                            if(json.login === null || json.password === null){
                                document.getElementById('error_login').innerText = 'Логин или пароль не верные.'
                            }
                            else{
                            localStorage.setItem('user',JSON.stringify(json)); 
                            }
                    }
                        );
}

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
        elem.innerHTML = companyList[a].smallNameCompany + " <button class=\"button, button_info\" name='" + a + "'>Информация</button> <button class=\"button, button_delete\" name='"+ a +"'> Удалить</button>";
        document.querySelector('.list_company').appendChild(elem);
    }
}


const button_info = document.querySelectorAll(".button_info");


const openHtml = (event) =>{
    let com_num = parseInt(event.target.name);
    let company_info = companyList[com_num];
    localStorage.setItem('company',JSON.stringify(company_info));
    window.location = "http://127.0.0.1:5500/companyInfo.html";
}

button_info.forEach(button_info =>{
button_info.addEventListener('click', openHtml);    
}) 

const button_delete = document.querySelectorAll(".button_delete");

async function deleteCompany (event){
    let com_num = parseInt(event.target.name);
    let company_id = companyList[com_num].id;
    // создаём рест запрос на удаление компании по id
    await fetch('http://localhost:8080/api/calisto/company/delete/' + company_id)
        .then(response => response.json())
        .then(json => {
            console.log(json);
        }
        );
}

button_delete.forEach(button_delete =>{
    button_delete.addEventListener('click', deleteCompany);    
}) 

