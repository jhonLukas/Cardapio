const apiUrl = "http://localhost:8080/food";
// Função para carregar o cardápio
function carregarCardapio() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const menuList = document.getElementById("menuList");
            menuList.innerHTML = ""; // Limpa antes de adicionar os novos itens

            data.forEach(comida => {
                const card = document.createElement("div");
                card.classList.add("card");
                card.innerHTML = `
                    <img src="${comida.image}" alt="${comida.title}">
                    <h3>${comida.title}</h3>
                    <p>R$ ${comida.price.toFixed(2)}</p>
                `;
                menuList.appendChild(card);
            });
        })
        .catch(error => console.error("Erro ao carregar cardápio:", error));
}

// Função para adicionar uma nova comida
document.getElementById("foodForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const title = document.getElementById("title").value;
    const image = document.getElementById("image").value;
    const price = parseFloat(document.getElementById("price").value);

    const novaComida = { title, image, price };

    fetch(apiUrl, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(novaComida)
    })
    .then(response => response.json())
    .then(() => {
        carregarCardapio(); // Atualiza a lista
        document.getElementById("foodForm").reset(); // Limpa o formulário
    })
    .catch(error => console.error("Erro ao adicionar comida:", error));
});

// Carregar o cardápio quando a página abrir
carregarCardapio();
