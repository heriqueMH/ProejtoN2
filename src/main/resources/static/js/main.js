document.addEventListener("DOMContentLoaded", function() {
    const currentLocation = window.location.pathname.split("/").pop();
    const menuItems = document.querySelectorAll("nav ul li");

    menuItems.forEach(item => {
        const link = item.querySelector("a");
        if (link.getAttribute("href") === currentLocation) {
            item.classList.add("ativo");
        }
    });
});