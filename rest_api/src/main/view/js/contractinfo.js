let res = localStorage.getItem('contract');
let contract = JSON.parse(res);

document.addEventListener("DOMContentLoaded", loadList);
async function loadList(){
    await fetch('http://localhost:8080/api/calisto/contract/get/'+ contract.id,{
                        method: 'GET',
                        headers:  {
                            'Content-Type': 'application/json',
                        },
                        }
                        )
                        .then(response => response.json())
        
                        .then(json => {
                            console.log(json);
                                localStorage.setItem('contract',JSON.stringify(json)); 
                        }
                            );
    }

res = localStorage.getItem('contract');
contract = JSON.parse(res);

document.getElementById('name').innerHTML = contract.name;
document.getElementById('date').innerHTML = contract.date;
document.getElementById('endDate').innerHTML = contract.endDate;
document.getElementById('innZakaz').innerHTML = contract.innZakaz;
document.getElementById('smileNameZakaz').innerHTML = contract.smileNameZakaz;
document.getElementById('addressZakaz').innerHTML = contract.addressZakaz;
document.getElementById('summ').innerHTML = contract.summ;



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
        company_id : contract.company_id,
        block : "contracts",
        block_id : contract.id
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
        window.location = "http://127.0.0.1:5500/contractinfo.html"
}
reader.onerror = function(){
    console.log(reader.error);
}
}