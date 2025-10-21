/* Központi HTMX listener */
document.body.addEventListener("htmx:afterSwap", function (evt) {
    if (evt.detail.target.id === "content") {
    initCpuChart()
    }
});

/* Processzor-átlagárak gyártónként Diagram Chart.js-ben */
function initCpuChart(){
    const canvas = document.getElementById("priceByCPU");

    if (!canvas) return;

    const cpuLabels = canvas.getAttribute("data-labels").replace(/[\[\]\s]/g, '').split(",");
    const cpuAvgPrices = canvas.getAttribute("data-values").replace(/[\[\]\s]/g, '').split(",").map(Number);

    new Chart(document.getElementById('priceByCPU'), {
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