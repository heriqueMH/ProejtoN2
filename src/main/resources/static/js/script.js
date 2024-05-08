document.addEventListener('DOMContentLoaded', function() {
    const listaEquipes = document.getElementById('listaEquipes');
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
