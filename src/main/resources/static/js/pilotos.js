document.addEventListener('DOMContentLoaded', function() {
    loadPilotos();
});

async function addPiloto() {
    const nomePiloto = document.getElementById('nomePiloto').value;
    const idadePiloto = document.getElementById('idadePiloto').value;
    const nacionalidadePiloto = document.getElementById('nacionalidadePiloto').value;

    const dadosPiloto = { nomePiloto, idade: idadePiloto, nacionalidade: nacionalidadePiloto };

    fetch('/api/pilotos', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dadosPiloto)
    })
    .then(response => response.json())
    .then(data => {
        alert('Piloto criado com sucesso!');
        document.getElementById('formCriarPiloto').reset();
        hideForm('pilotoForm', 'overlayPiloto');
        loadPilotos();
    })
    .catch(error => console.error('Erro ao criar piloto:', error));
}

async function loadPilotos() {
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
        <p><strong>Idade:</strong> ${piloto.idade}</p>
        <p><strong>Nacionalidade:</strong> ${piloto.nacionalidade}</p>
    `;
    cardContainer.appendChild(card);
}