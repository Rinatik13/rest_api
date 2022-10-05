let result = localStorage.getItem('buhdocument');
let buhdoc = JSON.parse(result);

document.addEventListener("DOMContentLoaded", loadList)

async function loadList(){
await fetch('http://localhost:8080/api/calisto/buhdoc/get/' + buhdoc.id,{
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


let docs_list = buhdoc.documentPdfList;

    if(docs_list == ""){
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
}

let res = localStorage.getItem('company');
let company = JSON.parse(res);

let documentPdf = {
    id : "" ,
    name : "" ,
    body : "" ,
    address : company.id + "/buhdocuments" 
}

let button_add_doc = document.getElementById("add_doc");
button_add_doc.addEventListener('click', uploadFile)

async function uploadFile(event){
    event.preventDefault();
let file = document.getElementById("file").files[0];
let reader = new FileReader();
reader.readAsBinaryString(file)
reader.onload = function(){
    documentPdf.body = reader.result;
}
reader.onerror = function(){
    console.log(reader.error);
}

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
}
