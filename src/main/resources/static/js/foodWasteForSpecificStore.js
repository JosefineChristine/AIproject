// Get the store ID from the URL path
const storeId = new URLSearchParams(window.location.search).get("storeId");

const foodWasteTable = document.getElementById("foodWasteTable").getElementsByTagName("tbody")[0];

if (!storeId) {
    foodWasteTable.innerHTML = "<tr><td colspan='2'>Ingen butik valgt.</td></tr>";
} else {
    fetch(`/salling/food-waste/${storeId}`)
        .then(res => res.json())
        .then(data => {
            if (!data || data.length === 0) {
                foodWasteTable.innerHTML = "<tr><td colspan='2'>Ingen madspild fundet.</td></tr>";
                return;
            }

            // Clear the "loading" message
            foodWasteTable.innerHTML = "";

            // Populate the table with the data
            data.forEach(item => {
                const row = foodWasteTable.insertRow();
                const productCell = row.insertCell(0);
                const stockCell = row.insertCell(1);

                productCell.textContent = item.product.description;
                stockCell.textContent = item.offer.stock;
            });
        })
        .catch(error => {
            console.error("Fejl:", error);
            foodWasteTable.innerHTML = "<tr><td colspan='2'>Fejl ved hentning af data.</td></tr>";
        });
}