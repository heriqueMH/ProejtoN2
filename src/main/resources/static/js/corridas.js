document.addEventListener('DOMContentLoaded', function() {
    loadCorridas();
});

function addCorrida() {
    const nome = document.getElementById('nomeCorrida').value;
    const data = document.getElementById('dataCorrida').value;
    const circuito = document.getElementById('circuitoCorrida').value;
    const condicoes_Climaticas = document.getElementById('condicoesClimaticas').value;
    const cidade_id = document.getElementById('cidadeId').value;

    const dadosCorrida = { nome, data, circuito, condicoes_Climaticas, cidade_id };

    fetch('/api/corridas', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dadosCorrida)
    })
    .then(response => response.json())
    .then(data => {
        alert('Corrida criada com sucesso!');
        document.getElementById('formCriarCorrida').reset();
    })
    .catch(error => console.error('Erro ao criar corrida:', error));
}
async function loadCorridas() {
    fetch('/api/corridas')
        .then(response => {
            if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
            return response.json();
        })
        .then(data => {
            const cardContainer = document.getElementById('cardContainerCorridas');
            cardContainer.innerHTML = '';
            data.forEach(corrida => addCorridaCard(corrida));
        })
        .catch(error => console.error('Erro ao carregar corridas:', error));
}

function addCorridaCard(corrida) {
    const cardContainer = document.getElementById('cardContainerCorridas');
    const card = document.createElement('div');
    card.className = 'card';
    card.innerHTML = `
        <p><strong>Nome:</strong> ${corrida.nome}</p>
        <p><strong>Data:</strong> ${corrida.data}</p>
        <p><strong>Circuito:</strong> ${corrida.circuito}</p>
    `;
    cardContainer.appendChild(card);
}