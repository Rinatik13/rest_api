document.getElementById('login_info').addEventListener('submit',getUser);

let user = {
    login: '',
    password: ''
}
document.getElementById('error_login').innerHTML = 'test'
let el = document.getElementById('login_info');


async function getUser(event){
    event.preventDefault();

    if(el.login === null || el.password === null){
        document.getElementById('error_login').innerHTML = 'Введите логин и пароль.'
    }
    else{
    user.login = el.login.value;
    user.password = el.password.value;
    await fetch('http://localhost:8080/api/calisto/user/get',{
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
                if(json.login === null || json.password === null){
                    document.getElementById('error_login').innerText = 'Логин или пароль не верные.'
                }
                else{
                localStorage.setItem('user',JSON.stringify(json));
                window.location = 'http://127.0.0.1:5500/companyList.html';    
                }
        }
            );
    }
}
