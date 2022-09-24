document.getElementById('add_company').addEventListener('submit', addCompany);

let company;

async function addCompany(event){
    event.preventDefault();

    let el = document.getElementById('add_company');
    let res = localStorage.getItem('user');
    let user_info = JSON.parse(res);
    let id_user = user_info.id;
    company = {
    fullNameFormCompany: el.company_name_form.value,
    smallNameCompany: el.company_smile_name.value,
    fullNameCompany: el.company_full_name.value,
    addressCompany: el.company_address.value,
    mailAddressCompany: el.company_post_address.value,
    innCompany: el.company_inn.value,
    kppCompany: el.company_kpp.value,
    registrationNumberCompany: el.company_ogrn.value,
    registrationNumberGovCompany: el.company_gov_number.value,
    dateRegistrationNumberGovDoc: el.company_date_reg.value,
    dateRegistrationCompany: el.company_date_reg.value,
    bankNumber: el.company_bik.value,
    nameFormBank: el.company_form_name_bank.value,
    nameBank: el.company_name_bank.value,
    addressBank: el.company_bank_address.value,
    checkingAccountBank: el.company_bank_schet.value,
    correspondentAccountBank: el.company_kor_schet.value,
    okpoCompany: el.company_okpo.value,
    okatoCompany: el.company_okato.value,
    okvedCompany: el.company_okved.value,
    emailCompany: el.company_email.value,
    telephoneCompany: el.company_phone.value,
    webSiteCompany: el.company_web_site.value,
    user_id: id_user
    }


    await fetch('http://localhost:8080/api/calisto/company/add',{
        method: 'POST',
        body: JSON.stringify(company),
        headers:  {
            'Content-Type': 'application/json',
        },
        }
        )
        .then(response => response.json())
        .then(json => {
            console.log(json);
         window.location ='http://127.0.0.1:5500/companyList.html';   
        }
            );
        
    }