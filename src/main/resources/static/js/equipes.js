window.onload = function() {
    fetch('http://localhost:3000/api/equipes')  // Endereço da API que retorna as equipes
        .then(response => response.json())
        .then(data => {
            const lista = document.getElementById('listaDeEquipes');
            data.forEach(equipe => {
                const item = document.createElement('li');
                item.textContent = equipe.nomeEquipe + " - " + equipe.qtdeFunc + " membros";
                lista.appendChild(item);
            });
        })
        .catch(error => console.error('Erro ao buscar equipes:', error));
}

document.getElementById('formEquipe').onsubmit = function(event) {
    event.preventDefault();

    const nomeEquipe = document.getElementById('nomeEquipe').value;
    const qtdeFunc = document.getElementById('qtdeFunc').value;

    fetch('api/equipes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nomeEquipe, qtdeFunc })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Equipe adicionada com sucesso:', data);
        alert('Equipe adicionada com sucesso!');
        window.location.reload();
    })
    .catch(error => console.error('Erro ao adicionar equipe:', error));
};

