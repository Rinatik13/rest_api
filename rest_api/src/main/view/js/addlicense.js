document.getElementById('add_license').addEventListener('submit', addlicense);

let license;

async function addlicense (event){
    event.preventDefault();

    let el = document.getElementById('add_license');
    let res = localStorage.getItem('company');
    let company = JSON.parse(res);

    license = {
        name : el.name.value,
        date : el.date.value,
        endDate : el.endDate.value,
        number : el.number.value,
        nameGovCom : el.nameGovCom.value,
        company_id : company.id
    }

    console.log(license);

    await fetch('http://localhost:8080/api/calisto/license/add',{
        method: 'POST',
        body: JSON.stringify(license),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
         window.location ='http://127.0.0.1:5500/licenseList.html';   
        }
            );
        
}