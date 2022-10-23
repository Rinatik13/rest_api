let result = localStorage.getItem('company');
let my_company = JSON.parse(result);

document.addEventListener('DOMContentLoaded', loadList)

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

let docs_list = company.documentPdfList;

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

let company_info = document.getElementById("company_info");
document.getElementById('full_name').innerHTML = company.fullNameCompany;
document.getElementById("smail_name").innerHTML = company.smallNameCompany;
document.getElementById("full_form_name").innerHTML = company.fullNameFormCompany;
document.getElementById("address_company").innerHTML = company.addressCompany;
document.getElementById("post_address").innerHTML = company.mailAddressCompany;
document.getElementById("inn").innerHTML = company.innCompany;
document.getElementById("date_reg_company").innerHTML = company.dateRegistrationNumberGovDoc;
document.getElementById("number_gov_nalog").innerHTML = company.registrationNumberGovCompany;
document.getElementById("ogrn").innerHTML = company.registrationNumberCompany;
document.getElementById("okpo").innerHTML = company.okpoCompany;
document.getElementById("okato").innerHTML = company.okatoCompany;
document.getElementById("osnovnoi_okved").innerHTML = company.okvedCompany;
document.getElementById("email").innerHTML = company.emailCompany;
document.getElementById("phone").innerHTML = company.telephoneCompany;
document.getElementById("webSite").innerHTML = company.webSiteCompany;
document.getElementById("bik").innerHTML = company.bankNumber;
document.getElementById("bank_name").innerHTML = company.nameBank;
document.getElementById("rSchet").innerHTML = company.checkingAccountBank;
document.getElementById("kSchet").innerHTML = company.correspondentAccountBank
document.getElementById("bank_address").innerHTML = company.addressBank;

// ёбаная проблема с добавлением нового файла. не обрабатывается файл что ли
// запрос не отправляется на сервер

let button_add_doc = document.getElementById('#add_doc');
document.querySelector('button').addEventListener("click", uploadFile);
// button_add_doc.querySelector.addEventListener('click', uploadFile);

    let documentPdf = {
    id : "" ,
    name : "" ,
    body : "" 
    }

async function uploadFile(event){

event.preventDefault();
let file = document.getElementById("file").files[0];
let reader = new FileReader();
reader.readAsBinaryString(file)
reader.onload = function(){
    document.address = company.id;
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
