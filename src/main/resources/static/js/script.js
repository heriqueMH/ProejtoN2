document.addEventListener('DOMContentLoaded', function() {
    const listaEquipes = document.getElementById('listaEquipes');

    // Dados simulados como se fossem recebidos de uma API
    const equipes = [
        { nome: 'Mercedes' },
        { nome: 'Red Bull' },
        { nome: 'Ferrari' }
    ];

    equipes.forEach(equipe => {
        const itemLista = document.createElement('li');
        itemLista.textContent = equipe.nome;
        listaEquipes.appendChild(itemLista);
    });
});
