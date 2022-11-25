let result = localStorage.getItem('company');
let company = JSON.parse(result);

document.addEventListener("DOMContentLoaded", loadList)

async function loadList(){
await fetch('http://localhost:8080/api/calisto/company/get/' + company.id,{
                    method: 'GET',
                    headers:  {
                        'Content-Type': 'application/json',
                    },
                    }
                    )
                    .then(response => response.json())
                    .then(json => {
                        console.log(json);
                            localStorage.setItem('company',JSON.stringify(json)); 
                    }
                        );
                }

let res = localStorage.getItem('company');
let company_info = JSON.parse(res);
let tenderList = company_info.tenderList;

if(tenderList==""){
    document.getElementById("tender_list").innerHTML = "Документы отсутствуют";
}
else {
    for(let a = 0; a < tenderList.length;a++){
        let block_list = document.createElement('div');
        block_list.innerHTML = "№ " + (a+1) + ": " + tenderList[a].name + " №" + tenderList[a].number + " <button class=\"button, button_addDoc\" name='"+ a +"'>Подготовить документы</button> <button class=\"button, button_delete\" name='"+ a +"'> Удалить</button>";
        document.querySelector('.list_tender').appendChild(block_list);
    }
}

const openBuild = async (event) => {
    let tender_num = parseInt(event.target.name);
    let tender = tenderList[tender_num];
    document.querySelector('.list_tender').innerHTML = '<div class="loader"></div>'
    await fetch('http://localhost:8080/api/calisto/tender/build/' + tender.id,{
                    method: 'GET',
                    headers:  {
                        'Content-Type': 'application/json',
                    },
                    }
                    )
                    .then(response => response.json())
                    .then(json => {
                        console.log(json);
                            localStorage.setItem('link',JSON.stringify(json));
                            window.location = "http://127.0.0.1:5500/linkZip.html";
                    }
                        );
                
}

const button_build = document.querySelectorAll('.button_addDoc');

button_build.forEach(button_build =>{
    button_build.addEventListener('click', openBuild);    
    }) 


    const button_delete = document.querySelectorAll(".button_delete");

    async function deleteElement (event){
        let element_num = parseInt(event.target.name);
        let element_id = tenderList[element_num].id;
        // создаём рест запрос на удаление объекта по id
        await fetch('http://localhost:8080/api/calisto/tender/delete/' + element_id)
            .then(response => response.json())
            .then(json => {
                console.log(json);
                window.location = "http://127.0.0.1:5500/tenderList.html"
            }
            );
    }
    
    button_delete.forEach(button_delete =>{
        button_delete.addEventListener('click', deleteElement);    
    }) 
    