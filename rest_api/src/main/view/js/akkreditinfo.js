let res = localStorage.getItem('akkredit');
let akkredit = JSON.parse(res);

document.addEventListener("DOMContentLoaded", loadList);
async function loadList(){
    await fetch('http://localhost:8080/api/calisto/akkredit/get/'+ akkredit.id,{
                        method: 'GET',
                        headers:  {
                            'Content-Type': 'application/json',
                        },
                        }
                        )
                        .then(response => response.json())
        
                        .then(json => {
                            console.log(json);
                                localStorage.setItem('akkredit',JSON.stringify(json)); 
                        }
                            );
    }

res = localStorage.getItem('akkredit');
akkredit = JSON.parse(res);

document.getElementById('number').innerHTML = akkredit.number;
document.getElementById('date').innerHTML = akkredit.date;
document.getElementById('endDate').innerHTML = akkredit.endDate;
document.getElementById('name').innerHTML = akkredit.name;

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
        company_id : akkredit.company_id,
        block : "akkredit",
        block_id : akkredit.id
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
        window.location = "http://127.0.0.1:5500/akkreditinfo.html"
}
reader.onerror = function(){
    console.log(reader.error);
}
}