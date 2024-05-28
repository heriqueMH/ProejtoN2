document.addEventListener('DOMContentLoaded', function() {
    loadCarros();
});

async function asyncCriarCarro(dadosCarro, proxsucesso, proxerro) {
    const URL = `/api/carros`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosCarro),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => { if (!resposta.ok) throw new Error(`Erro HTTP! Status: ${resposta.status}`); return resposta.json(); })
        .then(proxsucesso)
        .catch(proxerro);
}

async function asyncLerCarros(proxsucesso, proxerro) {
    const URL = `/api/carros`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw new Error(`HTTP error! Status: ${resposta.status}`); return resposta.json(); })
        .then(proxsucesso)
        .catch(proxerro);
}

async function asyncLerCarroById(id, proxsucesso, proxerro) {
    const URL = `/api/carros/${id}`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw new Error(`HTTP error! Status: ${resposta.status}`); return resposta.json(); })
        .then(proxsucesso)
        .catch(proxerro);
}

async function asyncAlterarCarro(dadosCarro, proxsucesso, proxerro) {
    const URL = `/api/carros/${dadosCarro.id}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosCarro),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => { if (!resposta.ok) throw new Error(`HTTP error! Status: ${resposta.status}`); return resposta.json(); })
        .then(proxsucesso)
        .catch(proxerro);
}

async function asyncApagarCarro(id, proxsucesso, proxerro) {
    const URL = `/api/carros/${id}`;
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta.text();
        })
        .then(proxsucesso)
        .catch(proxerro);
}

function getCarroData() {
    return {
        id: document.getElementById('idCarro').value,
        modelo: document.getElementById('modeloCarro').value,
        marca: document.getElementById('marcaCarro').value,
        ano: document.getElementById('anoCarro').value,
        categoria: document.getElementById('categoriaCarro').value,
    };
}

function handleSuccess(result) {
    console.log('Carro adicionado com sucesso:', result);
    addCarroCard(result);
}

function handleError(error) {
    console.error('Erro ao adicionar carro:', error);

    const mensagemErro = document.getElementById('mensagemErroCarro');
    mensagemErro.textContent = "Erro ao adicionar o carro: " + error.message;
    mensagemErro.style.display = 'block';
}

async function loadCarros() {
    fetch('/api/carros')
        .then(response => {
            if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
            return response.json();
        })
        .then(data => {
            const cardContainer = document.getElementById('cardContainer');
            if (!cardContainer) {
                console.error('Elemento cardContainer não encontrado.');
                return;
            }
            cardContainer.innerHTML = '';
            data.forEach(carro => addCarroCard(carro));
        })
        .catch(error => console.error('Erro ao carregar carros:', error));
}

function addCarroCard(carro) {
    const cardContainer = document.getElementById('cardContainer');
    const card = document.createElement('div');
    card.className = 'card';
    card.innerHTML = `
        <h3>Carro ID: ${carro.id}</h3>
        <p><strong>Modelo:</strong> ${carro.modelo}</p>
        <p><strong>Marca:</strong> ${carro.marca}</p>
        <p><strong>Ano:</strong> ${carro.ano}</p>
        <p><strong>Categoria:</strong> ${carro.categoria}</p>
    `;
    cardContainer.appendChild(card);
}