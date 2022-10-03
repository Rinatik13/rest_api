document.getElementById("add_tender").addEventListener('submit', addTender);

let tender;

async function addTender (event){
    event.preventDefault();
    
    let el = document.getElementById('add_tender');
    let res = localStorage.getItem('company');
    let company = JSON.parse(res);
    let com_id = company.id;

    tender = {
        name : el.name,
        web_address : el.tender_url,
        number : el.number,
        innZakaz : el.inn_company,
        company_id : com_id,
        countEmployee : el.count_empl,
        name_company : el.name_company
    }

    console.log(tender);

    await fetch('http://localhost:8080/api/calisto/tender/add',{
        method: 'POST',
        body: JSON.stringify(tender),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
         window.location ='http://127.0.0.1:5500/tenderList.html';   
        }
            );

}