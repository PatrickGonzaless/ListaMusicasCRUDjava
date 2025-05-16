console.log("JavaScript de listagem carregado");

document.addEventListener("DOMContentLoaded", function () {

    const Ititulo = document.getElementById("titulo");
    const Iartista = document.getElementById("artista");
    const Ianolancamento = document.getElementById("anolancamento");
    const form = document.getElementById("musicaForm");


    form.addEventListener("submit", function (event) {
        event.preventDefault();
        registerMusic();
    });

    function registerMusic() {
        console.log("Dados enviados:", {
            titulo: Ititulo.value,
            artista: Iartista.value,
            anolancamento: Ianolancamento.value,
        });

        fetch("http://localhost:8080/musicas", {
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
            },
            method: "POST",
            body: JSON.stringify({
                titulo: Ititulo.value,
                artista: Iartista.value,
                anolancamento: Ianolancamento.value,
            }),
        })
            .then((res) => {
                if (!res.ok) {
                    throw new Error(
                        `Erro na requisição: ${res.status} - ${res.statusText}`
                    );
                }
                return res.json();
            })
            .then((res) => {
                alert("Música cadastrada com sucesso!");
                 window.location.href = "../html/listaMusica.html";

            })
            .catch((err) => {
                console.error("Erro ao cadastrar música!", err);
                alert("Erro ao cadastrar música. Ano de lançamento não pode ser preenchido com letras.");
            });

    }

});