let res = localStorage.getItem("link");
let url = JSON.parse(res);

let a = document.getElementById("a");
a.href = url;
a.download = "";