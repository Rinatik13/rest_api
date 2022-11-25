let res = localStorage.getItem('company');
let company = JSON.parse(res);
let documentPdflist = company.documentPdfList;
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

if(documentPdflist === null){
    list.innerText = 'Список пуст';
}
else {
    for (let a = 0; a<documentPdflist.length; a++){
        let elem = document.createElement('div');
        elem.innerHTML = "№"+ (a+1) + " " + documentPdflist[a].name + " <button class=\"button button_delete\" name='"+ a +"'> Удалить</button><br><br>";
        document.querySelector('.list_component').appendChild(elem);
    }
}


document.querySelector('button').addEventListener('click', uploadFile);

async function uploadFile(event){
event.preventDefault();

let el = document.getElementById('file_name');

let file = document.getElementById('file').files[0];
let reader = new FileReader();
reader.readAsBinaryString(file)
reader.onload = async function(){
    documentPdf = {
        name : el.value,
        body : reader.result,
        company_id : company.id,
        block : "all_docs",
        block_id : "0"
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
        window.location = "http://127.0.0.1:5500/all_docList.html"
}
reader.onerror = function(){
    console.log(reader.error);
}
}

const button_delete = document.querySelectorAll(".button_delete");

async function deleteElement (event){
    let element_num = parseInt(event.target.name);
    let element_id = documentPdflist[element_num].id;
    // создаём рест запрос на удаление объекта по id
    await fetch('http://localhost:8080/api/calisto/documentpdf/delete/' + element_id)
        .then(response => response.json())
        .then(json => {
            console.log(json);
            window.location = "http://127.0.0.1:5500/all_docList.html"
        }
        );
}

button_delete.forEach(button_delete =>{
    button_delete.addEventListener('click', deleteElement);    
}) 