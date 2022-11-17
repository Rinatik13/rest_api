document.getElementById('add_akkredit').addEventListener('submit', addakkredit);

let akkredit;

async function addakkredit (event){
    event.preventDefault();

    let el = document.getElementById('add_akkredit');
    let res = localStorage.getItem('company');
    let company = JSON.parse(res);

    akkredit = {
        name : el.name.value,
        model : el.model.value,
        date : el.date.value,
        status : el.status.value,
        ps : el.ps.value,
        company_id : company.id
    }

    console.log(akkredit);

    await fetch('http://localhost:8080/api/calisto/akkredit/add',{
        method: 'POST',
        body: JSON.stringify(akkredit),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
         window.location ='http://127.0.0.1:5500/akkreditList.html';   
        }
            );
}