document.addEventListener('DOMContentLoaded', function() {
    loadEquipes();
});

async function loadEquipes() {
    try {
        const response = await fetch('/api/equipes');
        if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
        const data = await response.json();

        console.log('Dados carregados:', JSON.stringify(data));

        const tbody = document.querySelector('#tabelaEquipes tbody');
        if (!tbody) {
            console.error('Elemento tbody não encontrado.');
            return;
        }
        tbody.innerHTML = '';
        data.forEach(equipes => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${equipes.nomeEquipe}</td>
                <td>${equipes.qtdeFunc}</td>
                <td>${equipes.pais}</td>
                <td>${equipes.pilotos}</td>
                <td>${equipes.carros}</td>
            `;
            tbody.appendChild(row);
        });
    } catch (error) {
        console.error('Erro ao carregar equipes:', error);
    }
}