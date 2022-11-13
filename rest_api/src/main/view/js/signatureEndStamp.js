
let list = document.getElementById("all_doc_list")
let documentPdf;


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
let company = JSON.parse(res);
let signatures = company.signatureList;
let stamps = company.stampList;

if(signatures === null){
    list.innerText = 'Список пуст';
}
else {
    for (let a = 0; a<signatures.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = "№"+ (a+1) + ": " + signatures[a].name + " <button class=\"button button_delete\" name='"+ a +"'> Удалить</button><br><br>";
        document.querySelector('.list_component_signature').appendChild(elem);
    }
}

if(stamps === null){
    list.innerText = 'Список пуст';
}
else {
    for (let a = 0; a<stamps.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = "№"+ (a+1) + ": " + stamps[a].name + " <button class=\"button button_delete\" name='"+ a +"'> Удалить</button><br><br>";
        document.querySelector('.list_component_stamp').appendChild(elem);
    }
}


document.querySelector('button').addEventListener('click', uploadFile);

async function uploadFile(event){
event.preventDefault();

let radioInputPath = document.getElementsByTagName('element').value;

let el = document.getElementById('file_name');

let file = document.getElementById('file').files[0];
let reader = new FileReader();
reader.readAsBinaryString(file)
reader.onload = async function(){
    documentPdf = {
        name : el.value,
        body : reader.result,
        address : company.id + "/signatureStamp"
    }
    console.log(documentPdf);

    await fetch('http://localhost:8080/api/calisto/documentpdf/add',{
        method: 'POST',
        body: JSON.stringify(documentPdf),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
        }
            );
        window.location = "http://127.0.0.1:5500/signatureEndStamp.html"
}
reader.onerror = function(){
    console.log(reader.error);
}
}