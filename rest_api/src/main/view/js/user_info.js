let res = localStorage.getItem('user');
let user_info = JSON.parse(res);
console.log(user_info);
document.getElementById('login_info').innerText = user_info.login;
document.getElementById('name_info').innerText = user_info.name;
document.getElementById('phone_info').innerText = user_info.phone;
document.getElementById('email_info').innerText = user_info.email;
document.getElementById('inn_info').innerText = user_info.inn;