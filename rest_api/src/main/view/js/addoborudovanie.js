document.getElementById('add_oborudovanie').addEventListener('submit', addoborudovanie);

let oborudovanie;

async function addoborudovanie (event){
    event.preventDefault();

    let el = document.getElementById('add_oborudovanie');
    let res = localStorage.getItem('company');
    let company = JSON.parse(res);

    oborudovanie = {
        name : el.name.value,
        model : el.model.value,
        date : el.date.value,
        status : el.status.value,
        ps : el.ps.value,
        company_id : company.id
    }

    console.log(oborudovanie);

    await fetch('http://localhost:8080/api/calisto/oborudovanie/add',{
        method: 'POST',
        body: JSON.stringify(oborudovanie),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
         window.location ='http://127.0.0.1:5500/oborudovanieList.html';   
        }
            );
        
}