/*!
* Start Bootstrap - Creative v7.0.7 (https://startbootstrap.com/theme/creative)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-creative/blob/master/LICENSE)
*/
//
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            rootMargin: '0px 0px -40%',
        });
    }
    ;

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

    // Activate SimpleLightbox plugin for portfolio items
    new SimpleLightbox({
        elements: '#portfolio a.portfolio-box'
    });

});

// Üzenetek Modal
function initMessageModal() {
    const rows = document.querySelectorAll('#messageTable tr');
    const modal = new bootstrap.Modal(document.getElementById('messageModal'));

    rows.forEach(row => {
        row.addEventListener('click', () => {
            const id = row.getAttribute('data-id');
            console.log(id);
            console.log(messages);

            let selectedRow = messages.filter(e => e.id === Number(id))[0];

            document.getElementById('modalName').textContent = selectedRow.fullname;
            document.getElementById('modalEmail').textContent = selectedRow.email;
            document.getElementById('modalPhone').textContent = selectedRow.phonenumber;
            document.getElementById('modalDate').textContent = new Date(selectedRow.createdAt).toLocaleString();
            document.getElementById('modalMessage').textContent = selectedRow.message;

            modal.show();
        });
    });
}

document.addEventListener('DOMContentLoaded', initMessageModal);
document.body.addEventListener('htmx:afterSwap', (e) => {
    if (e.target.querySelector('#messageTable')) {
        initMessageModal();
    }
});