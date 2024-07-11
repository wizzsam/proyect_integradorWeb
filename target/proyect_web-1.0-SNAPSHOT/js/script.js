document.addEventListener('DOMContentLoaded', function() {
    const itemsPerPage = 6; // Número de tarjetas por página
    const contenedorTarget = document.getElementById('contenedor_target');
    const tarjetas = contenedorTarget.getElementsByClassName('contenedor_tarjeta');
    const totalPages = Math.ceil(tarjetas.length / itemsPerPage);
    let currentPage = 1;

    function showPage(page) {
        for (let i = 0; i < tarjetas.length; i++) {
            tarjetas[i].style.display = 'none';
        }

        const start = (page - 1) * itemsPerPage;
        const end = start + itemsPerPage;
        for (let i = start; i < end && i < tarjetas.length; i++) {
            tarjetas[i].style.display = 'inline-block';
        }

        document.getElementById('prevBtn').disabled = page === 1;
        document.getElementById('nextBtn').disabled = page === totalPages;
    }

    document.getElementById('prevBtn').addEventListener('click', function() {
        if (currentPage > 1) {
            currentPage--;
            showPage(currentPage);
        }
    });

    document.getElementById('nextBtn').addEventListener('click', function() {
        if (currentPage < totalPages) {
            currentPage++;
            showPage(currentPage);
        }
    });

    showPage(currentPage);
});