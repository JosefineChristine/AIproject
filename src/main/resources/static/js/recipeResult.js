//***FETCH CHAT API***--------------------------------------------------------------------------------------------------
//document.addEventListener("DOMContentLoaded", () => {
    // Get storeId from localStorage (which was saved on the foodWasteForSpecificStore page)
//    const storeId = localStorage.getItem("storeId");

//    if (storeId) {
        // Make a request to the /api/recipes endpoint with the storeId
//        fetch(`/api/recipes?storeId=${storeId}`)
//            .then(res => res.text()) // Expecting a text response (recipe result in plain text)
//            .then(data => {
                // Handle the response and display the recipe data
//                console.log("Recipe Data:", data);
                // You can now display the recipes on the page, for example:
//                const recipeResultElement = document.getElementById("recipeResult");
//                if (recipeResultElement) {
//                    recipeResultElement.textContent = data; // Set the content of the element
//                }
//            })
//            .catch(error => {
//                console.error("Fejl ved hentning af opskrifter:", error);
//                alert("Kunne ikke hente opskrifter.");
//            });

//        const goBackButton = document.getElementById("getRecipesBtn");
//        if (goBackButton) {
//            goBackButton.addEventListener("click", (event) => {
//                event.preventDefault();
//                window.history.back();
//            });
//        }


//    } else {
//        console.error("Ingen butik valgt.");
//        alert("Ingen butik valgt. Kan ikke hente opskrifter.");
//    }
//});

//***FETCH CHAT API***--------------------------------------------------------------------------------------------------
document.addEventListener("DOMContentLoaded", () => {
    const storeId = localStorage.getItem("storeId");

    const recipeResultElement = document.getElementById("recipeResult");
    const goBackButton = document.getElementById("getRecipesBtn");

    if (storeId) {
        fetch(`/api/recipes?storeId=${storeId}`)
            .then(res => res.text()) // Assuming plain text or Markdown
            .then(data => {
                if (recipeResultElement) {
                    // Convert Markdown to HTML
                    const html = marked.parse(data);
                    // Typing effect for HTML (line by line)
                    typeHtml(recipeResultElement, html);
                }
            })
            .catch(error => {
                console.error("Fejl ved hentning af opskrifter:", error);
                alert("Kunne ikke hente opskrifter.");
            });

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

// Typing animation for innerHTML with proper rendering
function typeHtml(element, html, speed = 10) {
    element.innerHTML = ''; // Clear existing
    let tempDiv = document.createElement("div");
    tempDiv.innerHTML = html;

    const children = Array.from(tempDiv.childNodes);
    let i = 0;

    function typeNext() {
        if (i >= children.length) return;
        const node = children[i].cloneNode(true);
        element.appendChild(node);
        i++;
        setTimeout(typeNext, speed * 20);
    }

    typeNext();
}



