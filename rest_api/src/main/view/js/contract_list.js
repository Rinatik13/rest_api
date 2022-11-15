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
    
let contracts = company.contractList;
if(contracts==null){
    document.getElementById('component_list').innerHTML = 'Список пуст.';
}
else {
    for (let a = 0; a<contracts.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = "№ " + (a+1) + " Название: " + contracts[a].name + " <button class=\"button, button_info\" name='" + a + "'>Информация</button>";
        document.querySelector('.list_component').appendChild(elem);
    }
}

const button_info = document.querySelectorAll(".button_info");

const openHtml = (event) =>{
    let oborud_num = parseInt(event.target.name);
    let contract_info = contracts[oborud_num];
    localStorage.setItem('contract',JSON.stringify(contract_info));
    window.location = "http://127.0.0.1:5500/contractinfo.html";
}

button_info.forEach(button_info =>{
    button_info.addEventListener('click', openHtml);    
    }) 