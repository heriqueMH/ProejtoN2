document.addEventListener("DOMContentLoaded", function() {
    const currentLocation = window.location.pathname.split("/").pop();
    const menuItems = document.querySelectorAll("nav ul li");

    menuItems.forEach(item => {
        const link = item.querySelector("a");
        if (link.getAttribute("href") === currentLocation) {
            item.classList.add("ativo");
        }
    });


    document.querySelectorAll('.btn-create').forEach(button => {
        button.addEventListener('click', function(event) {
            event.preventDefault();
            showForm('form', 'overlay');
        });
    });

    document.addEventListener('click', function(event) {
        const form = document.getElementById('form');
        const overlay = document.getElementById('overlay');
    
        if ((event.target === overlay || !form.contains(event.target)) && !event.target.closest('.btn-create')) {
            hideForm('form', 'overlay');
        }
    });
});

function showForm(formId, overlayId) {
    const form = document.getElementById(formId);
    const overlay = document.getElementById(overlayId);
    form.classList.remove('hidden');
    overlay.classList.remove('hidden');
}

function hideForm(formId, overlayId) {
    const form = document.getElementById(formId);
    const overlay = document.getElementById(overlayId);
    form.classList.add('hidden');
    overlay.classList.add('hidden');
}

