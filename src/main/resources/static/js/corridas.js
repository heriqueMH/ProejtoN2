document.addEventListener('DOMContentLoaded', function() {
    loadCorridas();
});

async function addCorrida() {
    const nomeCorrida = document.getElementById('nomeCorrida').value;
    const dataCorrida = document.getElementById('dataCorrida').value;
    const localCorrida = document.getElementById('localCorrida').value;

    const dadosCorrida = { nomeCorrida, data: dataCorrida, local: localCorrida };

    fetch('/api/corridas', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dadosCorrida)
    })
    .then(response => response.json())
    .then(data => {
        alert('Corrida criada com sucesso!');
        document.getElementById('formCriarCorrida').reset();
        hideForm('corridaForm', 'overlayCorrida');
        loadCorridas();
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
        <p><strong>Nome:</strong> ${corrida.nomeCorrida}</p>
        <p><strong>Data:</strong> ${corrida.data}</p>
        <p><strong>Local:</strong> ${corrida.local}</p>
    `;
    cardContainer.appendChild(card);
}