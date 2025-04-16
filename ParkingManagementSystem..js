// Smooth Scroll for Navigation Links
document.querySelectorAll('header a').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const targetId = this.getAttribute('href').substring(1);
        const targetSection = document.getElementById(targetId);
        if (targetSection) {
            targetSection.scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            });
        }
    });
});

// Dynamic Footer Year Update
const footer = document.querySelector('footer');
const year = new Date().getFullYear();
footer.innerHTML += `<p>&copy; ${year} Intelligent Parking Solutions. All rights reserved.</p>`;

// Simulate Dynamic Data Updates (e.g., for Parking Availability)
const features = document.querySelectorAll('.feature');
let counter = 1;

setInterval(() => {
    features.forEach(feature => {
        feature.style.backgroundColor = counter % 2 === 0 ? '#f0f8ff' : 'white';
        feature.style.transition = 'background-color 0.5s ease';
    });
    counter++;
}, 5000);
