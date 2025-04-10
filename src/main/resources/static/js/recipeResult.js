//***FETCH STORE NAME TO PRINT ON HTML PAGE***--------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

document.addEventListener("DOMContentLoaded", () => {
    // Get storeId from localStorage (which was saved on the previous page)
    const storeId = localStorage.getItem("storeId");

    if (storeId) {
        // Make a request to the /api/recipes endpoint with the storeId
        fetch(`/api/recipes?storeId=${storeId}`)
            .then(res => res.text()) // Expecting a text response (recipe result in plain text)
            .then(data => {
                // Handle the response and display the recipe data
                console.log("Recipe Data:", data);
                // You can now display the recipes on the page, for example:
                const recipeResultElement = document.getElementById("recipeResult");
                if (recipeResultElement) {
                    recipeResultElement.textContent = data; // Set the content of the element
                }
            })
            .catch(error => {
                console.error("Fejl ved hentning af opskrifter:", error);
                alert("Kunne ikke hente opskrifter.");
            });

        const goBackButton = document.getElementById("getRecipesBtn");
        if (goBackButton) {
            goBackButton.addEventListener("click", (event) => {
                event.preventDefault();
                window.history.back();
            });
        }


    } else {
        console.error("Ingen butik valgt.");
        alert("Ingen butik valgt. Kan ikke hente opskrifter.");
    }
});



