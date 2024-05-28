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

async function asyncLerCarrinhoById(id, proxsucesso, proxerro) {
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

    const novoItem = document.createElement('tr');
    novoItem.innerHTML = `
        <td>${result.id}</td>
        <td>${result.modelo}</td>
        <td>${result.marca}</td>
        <td>${result.ano}</td>
        <td>${result.categoria}</td>
    `;
    document.querySelector('#tabelaCarros tbody').appendChild(novoItem);

    document.getElementById('idCarro').value = '';
    document.getElementById('modeloCarro').value = '';
    document.getElementById('marcaCarro').value = '';
    document.getElementById('anoCarro').value = '';
    document.getElementById('categoriaCarro').value = '';
}

function handleError(error) {
    console.error('Erro ao adicionar carro:', error);

    const mensagemErro = document.getElementById('mensagemErroCarro');
    mensagemErro.textContent = "Erro ao adicionar o carro: " + error.message;
    mensagemErro.style.display = 'block';
}

async function loadCarros() {
    try {
        const response = await fetch('/api/carros');
        if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
        const data = await response.json();

        console.log('Dados carregados:', JSON.stringify(data));

        const tbody = document.querySelector('#tabelaCarros tbody');
        if (!tbody) {
            console.error('Elemento tbody não encontrado.');
            return;
        }
        tbody.innerHTML = '';
        data.forEach(carro => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${carro.id}</td>
                <td>${carro.modelo}</td>
                <td>${carro.marca}</td>
                <td>${carro.ano}</td>
                <td>${carro.categoria}</td>
            `;
            tbody.appendChild(row);
        });
    } catch (error) {
        console.error('Erro ao carregar carros:', error);
    }
}