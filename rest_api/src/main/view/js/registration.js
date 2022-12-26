document.getElementById('registration_form').addEventListener('submit',checkForm);

let user;

async function checkForm(event){
    event.preventDefault();

    let el = document.getElementById('registration_form');
    user ={
        name : el.name.value,
        login : el.login.value,
        inn : el.inn.value,
        email : el.email.value,
        phone : el.phone.value,
        password : el.password.value
    }

    console.log(user);
    
    await fetch('http://localhost:8080/api/calisto/user/add',{
        method: 'POST',
        body: JSON.stringify(user),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
            localStorage.setItem('user',JSON.stringify(user));
        
        }
            );
        window.location ='http://127.0.0.1:5500/user.html';   
}
