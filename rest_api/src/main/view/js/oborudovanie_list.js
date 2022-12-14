let res = localStorage.getItem('company');
let company = JSON.parse(res);

document.addEventListener("DOMContentLoaded", loadList);
async function loadList(){
    await fetch('http://localhost:8080/api/calisto/company/get/'+company.id,{
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

res = localStorage.getItem('company');
company = JSON.parse(res);
    
let oborudovanies = company.oborudovanieList;
if(oborudovanies==null){
    document.getElementById('component_list').innerHTML = 'Список пуст.';
}
else {
    for (let a = 0; a<oborudovanies.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = "№ " + (a+1) + " Название: " + oborudovanies[a].name + ", модель :" + oborudovanies[a].model + " <button class=\"button, button_info\" name='" + a + "'>Информация</button><button class=\"button, button_delete\" name='"+ a +"'> Удалить</button>";
        document.querySelector('.list_component').appendChild(elem);
    }
}

const button_info = document.querySelectorAll(".button_info");

const openHtml = (event) =>{
    let oborud_num = parseInt(event.target.name);
    let oborudovanie_info = oborudovanies[oborud_num];
    localStorage.setItem('oborudovanie',JSON.stringify(oborudovanie_info));
    window.location = "http://127.0.0.1:5500/oborudovanieinfo.html";
}

button_info.forEach(button_info =>{
    button_info.addEventListener('click', openHtml);    
    }) 

    
    const button_delete = document.querySelectorAll(".button_delete");

    async function deleteElement (event){
        let element_num = parseInt(event.target.name);
        let element_id = oborudovanies[element_num].id;
        // создаём рест запрос на удаление объекта по id
        await fetch('http://localhost:8080/api/calisto/oborudovanie/delete/' + element_id)
            .then(response => response.json())
            .then(json => {
                console.log(json);
                window.location = "http://127.0.0.1:5500/oborudovanieList.html"
            }
            );
    }
    
    button_delete.forEach(button_delete =>{
        button_delete.addEventListener('click', deleteElement);    
    }) 
    