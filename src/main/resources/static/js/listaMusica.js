document.addEventListener("DOMContentLoaded", () => {

  listMusics();
});


const tabelaMain = document.getElementById("tableContainer");
const tabela = document.querySelector("table");
const tbody = document.getElementById("musicaList");
const emptyMessage = document.querySelector(".empty_msg");

function listMusics() {
  fetch(`http://localhost:8080/musicas`, {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "GET",
  })
    .then((res) => {
      if (!res.ok) {
        throw new Error(
          `Erro na requisição: ${res.status} - ${res.statusText}`
        );
      }
      return res.json();
    })
    .then((musicas) => {
      listarMusicas(musicas);
       console.log("Músicas recebidas:", musicas);
      tabela.style.display = "block";
    })
    .catch((err) => {
      alert("Erro ao buscar musicas: " + err.message);
    });
}


function listarMusicas(musicas) {
  tbody.innerHTML = "";

  if (musicas.length === 0) {
    tabelaMain.style.display = "none";
    emptyMessage.style.display = "block"; 
    return;
  }
   
  tabelaMain.style.display = "block";
  emptyMessage.style.display = "none";
  

  musicas.forEach((musica) => {
    const tr = document.createElement("tr");

    tr.innerHTML = `
      <td>${musica.id}</td>
      <td>${musica.titulo}</td>
      <td>${musica.artista}</td>
      <td>${musica.anolancamento}</td>
    `;
    tbody.appendChild(tr);
  });
  
}