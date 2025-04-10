

//***FETCH STORE NAME TO PRINT ON HTML PAGE***--------------------------------------------------------------------------
if (storeId) {
    fetch(`/salling/stores/${storeId}`)
        .then(res => res.json())
        .then(store => {
            document.getElementById("storeNameHeader").textContent = `Opskrifter baseret på madspild i butikken: ${store.name}`;
        })
        .catch(err => {
            console.error("Kunne ikke hente butiksnavn:", err);
            document.getElementById("storeNameHeader").textContent = "Butik ikke fundet";
        });
} else {
    document.getElementById("storeNameHeader").textContent = "Ingen butik valgt.";
}