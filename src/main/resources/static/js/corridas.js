document.addEventListener('DOMContentLoaded', function() {
    loadCorridas();
});

async function loadCorridas() {
    try {
        const response = await fetch('/api/corridas');
        if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
        const data = await response.json();

        console.log('Dados carregados:', JSON.stringify(data));

        const tbody = document.querySelector('#tabelaCorridas tbody');
        if (!tbody) {
            console.error('Elemento tbody não encontrado.');
            return;
        }
        tbody.innerHTML = '';
        data.forEach(corrida => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${corrida.nome}</td>
                <td>${corrida.data}</td>
                <td>${corrida.circuito}</td>
                <td>${corrida.condicoesClimaticas}</td>
            `;
            tbody.appendChild(row);
        });
    } catch (error) {
        console.error('Erro ao carregar corridas:', error);
    }
}