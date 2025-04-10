//***GET FOOD LIST FROM SPECIFIC STORE***-------------------------------------------------------------------------------
// Get the store ID from the URL path
const storeId = new URLSearchParams(window.location.search).get("storeId");

const foodWasteTable = document.getElementById("foodWasteTable").getElementsByTagName("tbody")[0];

goBack();

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

//***FETCH STORE NAME TO PRINT ON HTML PAGE***--------------------------------------------------------------------------
if (storeId) {
    fetch(`/salling/stores/${storeId}`)
        .then(res => res.json())
        .then(store => {
            document.getElementById("storeNameHeader").textContent = `Madspild i butikken: ${store.name}`;
        })
        .catch(err => {
            console.error("Kunne ikke hente butiksnavn:", err);
            document.getElementById("storeNameHeader").textContent = "Butik ikke fundet";
        });
} else {
    document.getElementById("storeNameHeader").textContent = "Ingen butik valgt.";
}

//***FETCH FOOD-WASTE MAKE STRING FROM JSON***--------------------------------------------------------------------------
async function getFoodWasteAsString(storeId) {
    if (!storeId) {
        return JSON.stringify({ error: "Ingen butik valgt." });
    }
    try {
        const response = await fetch(`/salling/food-waste/${storeId}`);
        const foodWaste = await response.json();
        return JSON.stringify(foodWaste); // This is your JSON string
    } catch (error) {
        console.error("Fejl:", error);
        return JSON.stringify({ error: "Fejl ved hentning af data." });
    }
}

//***FETCH RESPONSE FROM CHAT***----------------------------------------------------------------------------------------
//--- Button click: Get recipes based on food waste ---
document.getElementById("getRecipesBtn").addEventListener("click", async () => {
    if (!storeId) return alert("Ingen butik valgt.");

    try {
        // Save storeId to localStorage
        localStorage.setItem("storeId", storeId);

        // Redirect to recipesResult.html
        window.location.href = "/recipesResult.html";
    } catch (err) {
        console.error("Fejl ved redigering af opskrifter:", err);
        alert("Kunne ikke hente opskrifter.");
    }
});

function goBack() {
    // Går tilbage til den forrige side
    document.getElementById("purpleBtn").addEventListener("click", (event) => {
        event.preventDefault();
        window.history.back();
    });
}



//**END***--------------------------------------------------------------------------------------------------------------