let res = localStorage.getItem("company");
let companyId = JSON.parse(res);

let documentPdf = {
    id : "" ,
    name : "" ,
    body : "" ,
    address : ""
}

document.querySelector("button").addEventListener("click", uploadFile);

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