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
    
let akkredits = company.akkreditList;
if(akkredits==null){
    document.getElementById('component_list').innerHTML = 'Список пуст.';
}
else {
    for (let a = 0; a<akkredits.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = "№ " + (a+1) + " Номер: " + akkredits[a].number + ", кем выдан :" + akkredits[a].name + ", до какого действителен: " + akkredits[a].endDate + " <button class=\"button, button_info\" name='" + a + "'>Информация</button>";
        document.querySelector('.list_component').appendChild(elem);
    }
}

const button_info = document.querySelectorAll(".button_info");

const openHtml = (event) =>{
    let akkredit_num = parseInt(event.target.name);
    let akkredit_info = akkredits[akkredit_num];
    localStorage.setItem('akkredit',JSON.stringify(akkredit_info));
    window.location = "http://127.0.0.1:5500/akkreditinfo.html";
}

button_info.forEach(button_info =>{
    button_info.addEventListener('click', openHtml);    
    }) 