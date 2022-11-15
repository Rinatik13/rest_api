document.getElementById('add_contract').addEventListener('submit', addoborudovanie);

let contract;

async function addoborudovanie (event){
    event.preventDefault();

    let el = document.getElementById('add_contract');
    let res = localStorage.getItem('company');
    let company = JSON.parse(res);

    contract = {
        name : el.name.value,
        date : el.date.value,
        endDate : el.endDate.value,
        innZakaz : el.innZakaz.value,
        smileNameZakaz : el.smileNameZakaz.value,
        summ : el.summ.value,
        company_id : company.id
    }

    console.log(contract);

    await fetch('http://localhost:8080/api/calisto/contract/add',{
        method: 'POST',
        body: JSON.stringify(contract),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
         window.location ='http://127.0.0.1:5500/contractList.html';   
        }
            );
        
}