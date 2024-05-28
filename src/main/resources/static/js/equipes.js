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
    const pilotos = equipe.pilotos ? equipe.pilotos.map(piloto => `<p><strong>Piloto:</strong> ${piloto.nome}</p>`).join('') : '<p>Nenhum piloto disponível</p>';
    const card = document.createElement('div');
    card.className = 'card';
    card.innerHTML = `
        <p><strong>Nome:</strong> ${equipe.nomeEquipe}</p>
        ${pilotos}
        <p><strong>País:</strong> ${equipe.pais ? equipe.pais.nome : 'N/A'}</p>
        <p><strong>Quantidade de Funcionários:</strong> ${equipe.qtdeFunc}</p>
    `;
    cardContainer.appendChild(card);
}



