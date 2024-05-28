document.addEventListener('DOMContentLoaded', function() {
    loadEquipes();
});

document.addEventListener('DOMContentLoaded', function() {
    loadEquipes();
});

async function loadEquipes() {
    fetch('/api/equipes')
        .then(response => {
            if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
            return response.json();
        })
        .then(data => {
            const cardContainer = document.getElementById('cardContainerEquipes');
            cardContainer.innerHTML = '';
            data.forEach(equipe => addEquipeCard(equipe));
        })
        .catch(error => console.error('Erro ao carregar equipes:', error));
}

function addEquipeCard(equipe) {
    const cardContainer = document.getElementById('cardContainerEquipes');
    const card = document.createElement('div');
    card.className = 'card';
    card.innerHTML = `
        <h3>Equipe ID: ${equipe.id}</h3>
        <p><strong>Nome:</strong> ${equipe.nome}</p>
        <p><strong>País:</strong> ${equipe.pais ? equipe.pais.nome : 'N/A'}</p>
        <p><strong>Quantidade de Funcionários:</strong> ${equipe.qtdeFunc}</p>
    `;
    cardContainer.appendChild(card);
}
