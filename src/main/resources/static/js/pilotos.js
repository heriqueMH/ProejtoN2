document.addEventListener('DOMContentLoaded', function() {
    loadPilotos();
});


async function asyncLerPilotos(proxsucesso, proxerro) {
    const URL = `/api/pilotos`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw new Error(`HTTP error! Status: ${resposta.status}`); return resposta.json(); })
        .then(proxsucesso)
        .catch(proxerro);
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
        <p><strong>Piloto:</strong> ${piloto.nome}</p>
        <p><strong>Equipe:</strong> ${piloto.equipe.nomeEquipe}</p>
        <p><strong>Nascimento:</strong> ${piloto.dataDeNascimento}</p>
    `;
    cardContainer.appendChild(card);
}