document.getElementById("add_owner").addEventListener("submit", addOwner)

let user = localStorage.getItem('user');
let company_res = localStorage.getItem('company');
let company = JSON.parse(company_res)
let owner;

async function addOwner(event){
    event.preventDefault();
    let el = document.getElementById(" add_owner");

    owner = {
    name : el.owner_name.value,
    country : el.owner_country.value,
    identifier : el.owner_identifier.value,
    share : el.owner_share.value,
    recvisites : el.owner_recvisites.value
    }
    console.log(owner);
    await fetch('http://localhost:8080/api/calisto/owner/add',{
        method: 'POST',
        body: JSON.stringify(owner),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
            company.employeeList = res_list;
            company.employeeList.push(json);
            localStorage.setItem('owner', JSON.stringify(company));
        }
            );
        window.location ='http://127.0.0.1:5500/owners.html';

}