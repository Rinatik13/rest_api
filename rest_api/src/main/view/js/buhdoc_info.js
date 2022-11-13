
async function loadList(){
await fetch('http://localhost:8080/api/calisto/buhdocument/get/' + buhdoc.id,{
                    method: 'GET',
                    headers:  {
                        'Content-Type': 'application/json',
                    },
                    }
                    )
                    .then(response => response.json())
    
                    .then(json => {
                        console.log(json);
                            localStorage.setItem('buhdocument',JSON.stringify(json));
                            let result = localStorage.getItem('buhdocument');
                            buhdoc = JSON.parse(result); 
                    }
                        );
}
let result = localStorage.getItem('buhdocument');
let buhdoc = JSON.parse(result);
let documentPdf;
let res = localStorage.getItem('company');
let company = JSON.parse(res);
let docs_list = buhdoc.documentPdfList;

document.addEventListener("DOMContentLoaded", loadList)

// let el = document.getElementById('buhdoc_info');

document.getElementById("buh_data").innerHTML = buhdoc.dateName;
document.getElementById("oboroti_data").innerHTML = buhdoc.oborotiDate;
document.getElementById("buh_data_count_empl").innerHTML = buhdoc.countEmployeeDate;

    if(docs_list === ""){
        document.getElementById("list_docs").innerHTML = "Документы отсутствуют";
    } 
    else
    {
        for(let a = 0; a<docs_list.length; a++){
        let block_list = document.createElement('div');
        block_list.innerHTML = "№" + (a+1) + ": " + docs_list[a].name + " <button class=\"button, button_delete\" name='"+ a +"'>Удалить</button>";
        document.querySelector('.docs_list').appendChild(block_list);
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
        block : "buhdocuments",
        block_id : buhdoc.id
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
        window.location = "http://127.0.0.1:5500/buhdocinfo.html"
}
reader.onerror = function(){
    console.log(reader.error);
}
}