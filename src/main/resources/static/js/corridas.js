document.addEventListener('DOMContentLoaded', function() {
    loadCorridas();
});

document.addEventListener('DOMContentLoaded', function() {
    loadCorridas();
});

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
        <h3>Corrida ID: ${corrida.id}</h3>
        <p><strong>Nome:</strong> ${corrida.nome}</p>
        <p><strong>Data:</strong> ${corrida.data}</p>
        <p><strong>Cidade:</strong> ${corrida.cidade ? corrida.cidade.nome : 'N/A'}</p>
    `;
    cardContainer.appendChild(card);
}
