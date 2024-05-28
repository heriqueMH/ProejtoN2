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
    try {
        const response = await fetch('/api/pilotos');
        if (!response.ok) throw new Error(`HTTP error! status: ${response.status}`);
        const data = await response.json();

        console.log('Dados carregados:', JSON.stringify(data));

        const tbody = document.querySelector('#tabelaPilotos tbody');
        if (!tbody) {
            console.error('Elemento tbody não encontrado.');
            return;
        }
        tbody.innerHTML = '';
        data.forEach(piloto => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${piloto.nome}</td>
                <td>${piloto.numSuperLicenca}</td>
                <td>${piloto.dataDeNascimento}</td>
                <td>${piloto.equipe}</td>
            `;
            tbody.appendChild(row);
        });
    } catch (error) {
        console.error('Erro ao carregar pilotos:', error);
    }
}