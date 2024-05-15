document.addEventListener('DOMContentLoaded', function() {
    const welcomeMessage = document.querySelector('h2');
    const currentTime = new Date().getHours();

    if (currentTime < 12) {
        welcomeMessage.textContent += ' Bom dia!';
    } else if (currentTime < 18) {
        welcomeMessage.textContent += ' Boa tarde!';
    } else {
        welcomeMessage.textContent += ' Boa noite!';
    }
});
