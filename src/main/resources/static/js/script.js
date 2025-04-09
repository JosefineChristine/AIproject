


//***FUNCTIONS***-------------------------------------------------------------------------------------------------------
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


//form submission for at lave update:
//**


document.getElementById('storeForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Prevent the default form submission

    const select = document.getElementById('storeSelect');
    const storeId = select.value;

    if (storeId) {
        // Redirect to the food-waste page with the selected store ID
        window.location.href = "/food-waste/" + storeId;
    } else {
        alert("Vælg venligst en butik før du fortsætter."); // Optional: validation
    }
});

/*

async function fetchFoodWasteById(){
    const response = await fetch("/salling/food-waste/")
    const

}

 */


// Initialiser ved at hente butikkernes data
fetchStores();
