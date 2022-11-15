let res = localStorage.getItem('oborudovanie');
let oborudovanie = JSON.parse(res);

document.addEventListener("DOMContentLoaded", loadList);
async function loadList(){
    await fetch('http://localhost:8080/api/calisto/oborudovanie/get/'+ oborudovanie.id,{
                        method: 'GET',
                        headers:  {
                            'Content-Type': 'application/json',
                        },
                        }
                        )
                        .then(response => response.json())
        
                        .then(json => {
                            console.log(json);
                                localStorage.setItem('oborudovanie',JSON.stringify(json)); 
                        }
                            );
    }

res = localStorage.getItem('oborudovanie');
oborudovanie = JSON.parse(res);

document.getElementById('name').innerHTML = oborudovanie.name;
document.getElementById('model').innerHTML = oborudovanie.model;
document.getElementById('date').innerHTML = oborudovanie.date;
document.getElementById('status').innerHTML = oborudovanie.status;
document.getElementById('ps').innerHTML = oborudovanie.ps;


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
        block : "oborudovanies",
        block_id : oborudovanie.id
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
        window.location = "http://127.0.0.1:5500/oborudovanieinfo.html"
}
reader.onerror = function(){
    console.log(reader.error);
}
}