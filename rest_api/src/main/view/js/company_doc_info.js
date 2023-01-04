let res = localStorage.getItem("company");
let company = JSON.parse(res);

let info = document.getElementById("my_document_info")
let company_doc = company.documentPdfList;
for(let a = 0; a < company_doc.length; a++)
{
    let elem = document.createElement('div');
    elem.innerHTML = "-";
    document.querySelector(".doc_list").appendChild(elem);  
}
