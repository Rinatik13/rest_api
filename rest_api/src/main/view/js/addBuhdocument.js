document.getElementById("add_buh_doc").addEventListener("submit", addBuhDoc);

let user = localStorage.getItem('user');
let company_res = localStorage.getItem('company');
let company = JSON.parse(company_res)

// добавляем механизим сохранения нового бухгалтерского периода(документа)

let el = document.getElementById("add_buh_doc");
let res = localStorage.getItem("buh_doc");
let buh_doc = JSON.parse(res);

async function addBuhDoc(event){
    event.preventDefault();
    console.log(company);
    buh_doc = {
        dateName : el.buhdoc_date.value,
        oborotiDate : el.buhdoc_oboroti.value,
        countEmployeeDate : el.buhdoc_countEmpl.value,
        company_id : company.id
    }
    console.log(buh_doc);

    await fetch('http://localhost:8080/api/calisto/buhdocument/add',{
        method: 'POST',
        body: JSON.stringify(buh_doc),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
            // let empl_list = company.employeeList;
            // let res_list = [];
            // for (let a = 0; a < empl_list.length; a++){
            //     let empl = empl_list[a];
            //     if (empl.id !=json.id){
            //         res_list.push(empl);
            //     }
            // }
            // company.employeeList = res_list;
            // company.employeeList.push(json);
            // localStorage.setItem('company', JSON.stringify(company));
        }
            );
        window.location ='http://127.0.0.1:5500/buhDocList.html';
}