document.addEventListener('DOMContentLoaded', function() {
    loadPilotos();
    loadEquipesOptions();
});

async function addPiloto() {
    const nomePiloto = document.getElementById('nomePiloto').value;
    const numSuperLicenca = document.getElementById('numSuperLicenca').value;
    const dataNasc = document.getElementById('dataNasc').value;
    const equipeId = document.getElementById('equipeId').value;

    const dadosPiloto = { nome: nomePiloto, num_Superlicenca: numSuperLicenca, data_De_Nascimento: dataNasc, equipe_id: equipeId };

    fetch('/api/pilotos', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dadosPiloto)
    })
    .then(response => response.json())
    .then(data => {
        alert('Piloto criado com sucesso!');
        document.getElementById('formCriarPiloto').reset();
    })
    .catch(error => console.error('Erro ao criar piloto:', error));
}

function loadPilotos() {
    fetch('/api/pilotos')
        .then(response => {
            if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
            return response.json();
        })
        .then(data => {
            const cardContainer = document.getElementById('cardContainerPilotos');
            cardContainer.innerHTML = '';
            data.forEach(piloto => addPilotoCard(piloto));
        })
        .catch(error => console.error('Erro ao carregar pilotos:', error));
}

function addPilotoCard(piloto) {
    const cardContainer = document.getElementById('cardContainerPilotos');
    const card = document.createElement('div');
    card.className = 'card';
    card.innerHTML = `
        <p><strong>Nome:</strong> ${piloto.nome}</p>
        <p><strong>Data de Nascimento:</strong> ${piloto.dataDeNascimento}</p>
        <p><strong>Superlicença:</strong> ${piloto.numSuperlicenca}</p>
    `;
    cardContainer.appendChild(card);
}

function loadEquipesOptions() {
    fetch('/api/equipes')
        .then(response => {
            if (!response.ok) throw new Error('Erro ao carregar equipes');
            return response.json();
        })
        .then(equipes => {
            const selectEquipe = document.getElementById('equipeId');
            equipes.forEach(equipe => {
                let option = document.createElement('option');
                option.value = equipe.id;
                option.textContent = equipe.nomeEquipe;
                selectEquipe.appendChild(option);
            });
        })
        .catch(error => console.error('Erro ao carregar equipes:', error));
}