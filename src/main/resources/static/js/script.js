
//***FUNCTIONS***-------------------------------------------------------------------------------------------------------
async function fetchStores() {
    try {
        const response = await fetch("/salling/stores");
        const stores = await response.json();

        const storeSelect = document.getElementById('storeSelect');

        stores.forEach(store => {
            const option = document.createElement('option');
            option.value = store.id;         // Brug butik ID som value
            option.textContent = store.name; // Vis butik navn
            storeSelect.appendChild(option);

        });
    } catch (error) {
        console.error("Kunne ikke hente butikker:", error);
    }
}

fetchStores();


//----------------------------------------------------------------------------------------------------------------------
// When formula is submitted, redirect to /food-waste/{id}
document.getElementById('storeForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Stop standard submit

    const storeId = document.getElementById('storeSelect').value;

    if (storeId) {
        // Redirect to the food waste data page for the selected store
        window.location.href = `foodWasteForSpecificStore.html?storeId=${storeId}`;
    } else {
        alert("Choose a store before you submit.");
    }
});

//----------------------------------------------------------------------------------------------------------------------
// Fetch food waste by store ID




