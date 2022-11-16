let res = localStorage.getItem('license');
let license = JSON.parse(res);

document.addEventListener("DOMContentLoaded", loadList);
async function loadList(){
    await fetch('http://localhost:8080/api/calisto/license/get/'+ license.id,{
                        method: 'GET',
                        headers:  {
                            'Content-Type': 'application/json',
                        },
                        }
                        )
                        .then(response => response.json())
        
                        .then(json => {
                            console.log(json);
                                localStorage.setItem('license',JSON.stringify(json)); 
                        }
                            );
    }

res = localStorage.getItem('license');
license = JSON.parse(res);

document.getElementById('name').innerHTML = license.name;
document.getElementById('number').innerHTML = license.number;
document.getElementById('date').innerHTML = license.date;
document.getElementById('endDate').innerHTML = license.endDate;
document.getElementById('nameGovCom').innerHTML = license.nameGovCom;


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
        company_id : license.company_id,
        block : "licenses",
        block_id : license.id
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
        window.location = "http://127.0.0.1:5500/licenseinfo.html"
}
reader.onerror = function(){
    console.log(reader.error);
}
}