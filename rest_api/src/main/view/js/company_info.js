let res = localStorage.getItem('user');
let user_info = JSON.parse(res);
let companyList = user_info.companyList;
let a = 1;
let company = companyList[a]

let doc = document.getElementById("my_company_info");

doc.full_name.innerText = company.fullNameCompany;