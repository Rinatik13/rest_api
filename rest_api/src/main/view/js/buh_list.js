let res = localStorage.getItem('company');
let company = JSON.parse(res);
let buh_list = company.buhdocumentList;
let list = document.getElementById("component_list");

if(buh_list === ""){
    document.getElementById("component_list").innerText = 'Бухгалтерские документы отсутствуют';
}
else {
    for (let a = 0; a<buh_list.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = "№"+ (a+1) + " " + buh_list[a].dateName + " " + buh_list[a].oborotiDate +" <button class=\"button button_info\" name='" + a + "'>Информация</button> <button class=\"button button_delete\" name='"+ a +"'> Удалить</button><br><br>";
        document.querySelector('.list_component').appendChild(elem);
    }
}
const button_info = document.querySelectorAll(".button_info");

const openHtml = (event) =>{
    let buh_num = parseInt(event.target.name);
    let buhdoc = employees[buh_num];
    localStorage.setItem("buhdocument",JSON.stringify(buhdoc));
    window.location = "http://127.0.0.1:5500/buhdocinfo.html";
    console.log(buhdoc)
}

button_info.forEach(button_info =>{
    button_info.addEventListener('click', openHtml);    
    }) 