let res = localStorage.getItem('owner');
let owner = JSON.parse(owner);

document.addEventListener('DOMContentLoaded', loadList);

async function loadList(){
await fetch('http://localhost:8080/api/calisto/owner/get/' + owner.id,{
                    method: 'GET',
                    headers:  {
                        'Content-Type': 'application/json',
                    },
                    }
                    )
                    .then(response => response.json())
    
                    .then(json => {
                        console.log(json);
                            localStorage.setItem('owner',JSON.stringify(json)); 
                    }
                        );
}
res = localStorage.getItem('owner');
owner = JSON.parse(res);

document.getElementById('name').innerHTML = owner.name;
document.getElementById('address').innerHTML = owner.country;
document.getElementById('recvisites').innerHTML = owner.recvisites;
document.getElementById('share').innerHTML = owner.share;