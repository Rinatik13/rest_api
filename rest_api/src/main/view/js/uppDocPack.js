// document.querySelector("button").addEventListener("click", upp)
// let url = "";
// async function upp (event) {
//     event.preventDefault();
// await fetch('http://localhost:8080/api/calisto/tender/build/1',{
//         method: 'GET'
//         }
//         )
//         .then(response => response.json())
//         .then(json => {
//             console.log(json);
//         localStorage.setItem("link", JSON.stringify(json.href))
        
//         }
//             );

document.addEventListener("DOMContentLoaded", loadList)

function loadList(){
let res1 = localStorage.getItem('link');
let url1 = JSON.parse(res1);
let a = document.getElementById("a");
a.innerText = "Скачать";
a.href = url1;
a.download = ""; 
}

