/* Központi HTMX listener */
document.body.addEventListener("htmx:afterSwap", function (evt) {
    if (evt.detail.target.id === "content") {
        initCpuChart();
        initOSChart();
    }
});

/* Processzor-átlagárak gyártónként Diagram Chart.js-ben */
function initCpuChart() {
    const canvas = document.getElementById("priceByCPU");

    if (!canvas) return;

    const cpuLabels = canvas.getAttribute("data-labels").replace(/[\[\]\s]/g, '').split(",");
    const cpuAvgPrices = canvas.getAttribute("data-values").replace(/[\[\]\s]/g, '').split(",").map(Number);

    new Chart(canvas, {
        type: 'bar',
        data: {
            labels: cpuLabels,
            datasets: [{
                label: 'Átlagár (Ft)',
                data: cpuAvgPrices,
                backgroundColor: ['#f87171', '#60a5fa', '#34d399']
            }]
        },
        options: {
            maintainAspectRatio: true,
            aspectRatio: 3/2,
            plugins: {
                title: {
                    display: true,
                    text: 'Átlagár processzorgyártónként'
                },
                legend: {display: false}
            },
            scales: {
                y: {beginAtZero: true}
            }
        }
    });
}

/* Notebookok száma OS szerint Chart.js-ben */
function initOSChart() {
    const canvas = document.getElementById("notebooksByOS");
    if (!canvas) return;

    const osLabels = canvas.getAttribute("data-labels").replace(/[\[\]]/g, '').split(",");
    const osCounts = canvas.getAttribute("data-values").replace(/[\[\]\s]/g, '').split(",").map(Number);

    new Chart(canvas, {
        type: 'doughnut',
        data: {
            labels: osLabels,
            datasets: [{
                data: osCounts,
                backgroundColor: ['#fbbf24', '#34d399', '#60a5fa', '#818cf8', '#aaaaaa', '#f87171',]
            }]
        },
        options: {
            maintainAspectRatio: true,
            aspectRatio: 1,
            plugins: {
                title: {
                    display: true,
                    text: 'Notebookok száma OS szerint',
                    position: 'bottom'
                },
                legend: {
                    position: 'bottom',
                    padding: 15
                }
            }
        }
    });
}