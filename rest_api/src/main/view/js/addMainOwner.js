document.getElementById("add_owner").addEventListener("submit", addOwner)

let user = localStorage.getItem('user');
let company_res = localStorage.getItem('company');
let company = JSON.parse(company_res)
let com_id = company.id;
let owner;

async function addOwner(event){
    event.preventDefault();
    owner = {
    company_id : com_id,
    main_owner_id : 0,    
    name : owner_name.value,
    country : owner_country.value,
    identifier : owner_identifier.value,
    share : owner_share.value,
    recvisites : owner_recvisites.value
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
            localStorage.setItem('owner', JSON.stringify(company));
        }
            );
        window.location ='http://127.0.0.1:5500/owners.html';

}