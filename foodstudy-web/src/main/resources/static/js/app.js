/* -----------------------------------------------------
   SCRIPT GLOBAL DO FOODSTUDY
------------------------------------------------------ */

console.log("FoodStudy JS carregado com sucesso!");

// URL base da API
const API_URL = "http://localhost:8080";

// Chamada genérica GET
async function apiGet(endpoint) {
    const response = await fetch(`${API_URL}${endpoint}`);
    return await response.json();
}

// Carregar produtos (usado em produtos.html)
async function carregarProdutos() {
    const tabela = document.getElementById("tabela-produtos");

    if (!tabela) return; // garante que está na página certa

    const dados = await apiGet("/produtos");

    tabela.innerHTML = "";

    dados.forEach(prod => {
        tabela.innerHTML += `
            <tr>
                <td>${prod.id}</td>
                <td>${prod.nome}</td>
                <td>${prod.descricao}</td>
                <td>R$ ${prod.preco.toFixed(2)}</td>
                <td>${prod.tipo}</td>
            </tr>
        `;
    });
}
