let result = localStorage.getItem('owner');
let owner = JSON.parse(result);

document.addEventListener("DOMContentLoaded", loadList)

async function loadList(){
await fetch('http://localhost:8080/api/calisto/owner/get/' + owner.id,{
                    method: 'GET',
                    headers:  {
                        'Content-Type': 'application/json',
                    },
                    }
                    )
                    .then(response => response.json())
                    .then(json => {
                        console.log(json);
                        localStorage.setItem('owner',JSON.stringify(json)); 
                    }
                        );
}

result = localStorage.getItem('owner');
owner = JSON.parse(result);
let owners = owner.owners;
let list = document.getElementById('owner_list');
if(owners == 0){
    document.getElementById('owner_list').innerText = 'Учредители отсутствуют.';
}
else {
    for (let a = 0; a<owners.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = owners[a].name + " <button class=\"button, button_info\" name='" + a + "'>Информация</button> <button class=\"button, button_delete\" name='"+ a +"'> Удалить</button>";
        document.querySelector('.list_owner').appendChild(elem);
    }
}
const button_info = document.querySelectorAll(".button_info");


const openHtml = (event) =>{
    let com_num = parseInt(event.target.name);
    let owner_info = owners[com_num];
    localStorage.setItem('owner',JSON.stringify(owner_info));
    window.location = "http://127.0.0.1:5500/ownerInfo.html";
}

button_info.forEach(button_info =>{
button_info.addEventListener('click', openHtml);    
}) 

const button_delete = document.querySelectorAll(".button_delete");

async function deleteCompany (event){
    let com_num = parseInt(event.target.name);
    let owner_id = owners[com_num].id;
    // создаём рест запрос на удаление учредителя по id
    await fetch('http://localhost:8080/api/calisto/owner/delete/' + owner_id)
        .then(response => response.json())
        .then(json => {
            console.log(json);
        }
        );
}

button_delete.forEach(button_delete =>{
    button_delete.addEventListener('click', deleteCompany);    
}) 

