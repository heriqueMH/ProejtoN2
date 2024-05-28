document.addEventListener('DOMContentLoaded', function() {
    loadEquipes();
});

async function addEquipe() {
    const nomeEquipe = document.getElementById('nomeEquipe').value;
    const paisEquipe = document.getElementById('paisEquipe').value;
    const qtdeFunc = document.getElementById('qtdeFunc').value;

    const dadosEquipe = { nomeEquipe, pais: paisEquipe, qtdeFunc };

    fetch('/api/equipes', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dadosEquipe)
    })
    .then(response => response.json())
    .then(data => {
        alert('Equipe criada com sucesso!');
        document.getElementById('formCriarEquipe').reset();
        hideForm('equipeForm', 'overlay');
        addEquipeCard(data);  
    })
    .catch(error => console.error('Erro ao criar equipe:', error));
}

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
    const pilotos = equipe.pilotos ? equipe.pilotos.map(piloto => `<p><strong>Piloto:</strong> ${piloto.nome}</p>`).join('') : '<p>Nenhum piloto disponível</p>';
    card.innerHTML = `
        <p><strong>Nome:</strong> ${equipe.nomeEquipe}</p>
        ${pilotos}
        <p><strong>País:</strong> ${equipe.pais ? equipe.pais.nome : 'N/A'}</p>
        <p><strong>Quantidade de Funcionários:</strong> ${equipe.qtdeFunc}</p>
    `;
    cardContainer.appendChild(card);
}
