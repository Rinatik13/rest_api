let res = localStorage.getItem("company");
let companyId = JSON.parse(res);
let documentPdf;
let bodyPdf;
// let button_add_doc = document.getElementById("#add_doc");
// button_add_doc.querySelector.addEventListener('click', uploadFile)
document.querySelector('button').addEventListener('click', uploadFile);

async function uploadFile(event){
// event.preventDefault();

let file = document.getElementById('file').files[0];
let reader = new FileReader();
reader.readAsBinaryString(file)
reader.onload = function(){
    bodyPdf = reader.result;
}
reader.onerror = function(){
    console.log(reader.error);
}

// отладочные данные
// данные были приняты
// файл сохранился, но боди не загрузилось!!!!!!!!!!!!!!!!!!!!!!!
documentPdf = {
        id : "" ,
        name : "Устав" ,
        body : bodyPdf,
        address : 19
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