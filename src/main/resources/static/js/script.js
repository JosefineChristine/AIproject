// Hent butikkernes data fra backend
async function fetchStores() {
    const response = await fetch("/salling/stores");
    const stores = await response.json();

    const storeSelect = document.getElementById('storeSelect');

    // Populer dropdown med butikker
    stores.forEach(store => {
        const option = document.createElement('option');
        option.value = store.id;
        option.textContent = store.name;
        storeSelect.appendChild(option);
    });
}

// Initialiser ved at hente butikkernes data
fetchStores();
