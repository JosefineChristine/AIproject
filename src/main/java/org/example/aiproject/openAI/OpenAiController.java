package org.example.aiproject.openAI;

import org.example.aiproject.model.Clearance;
import org.example.aiproject.service.FoodWasteService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OpenAiController {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private final OpenAiService openAiService;
    private final FoodWasteService foodWasteService;

    final static String SYSTEM_MESSAGE = "Please generate meal kit recipes based on the following ingredients. These ingredients are near their expiration date in a supermarket, and the goal is to **maximize the use of these ingredients** to minimize food waste. The recipes should be practical, easy to prepare, and suitable for packaging as ready-to-make meal kits.\n\n"
            + "1. **Ingredient List:** [Provide the list of available ingredients from the supermarket]\n"
            + "2. **Meal Kit Breakdown:** For each recipe, **calculate how many kits** can be made with the available ingredients. Specify the number of meal kits and highlight any missing ingredients needed to complete the kit. Keep additional ingredients to a minimum, focusing on using as much of the available ingredients as possible.\n\n"
            + "For each recipe, provide:\n"
            + "- At least two simple, practical recipes.\n"
            + "- **Optional extra ingredients** only if necessary to complete the recipe. Minimize extra ingredients.\n"
            + "- **Clear, concise instructions** for packaging and preparing the kits, suitable for supermarket customers.\n\n"
            + "The primary goal is to use up ingredients close to expiration, ensuring the recipes are practical and suitable for packaging as meal kits in the supermarket.\n\n"
            + "Please include:\n"
            + "- **Meal Kit Overview:** Number of kits that can be made from the available ingredients and any missing ingredients.\n"
            + "- **Recipe Instructions:** Detailed, simple preparation instructions for customers.\n\n"
            + "Focus on maximizing the use of available ingredients to reduce food waste, and avoid adding unnecessary ingredients.\n\n"
            + "Example:\n\n"
            + "If the available ingredients are:\n"
            + "- 10 ripe tomatoes, 6 chicken breasts, 2 bags of lettuce, 5 bell peppers, 3 onions, 2 packs of tortillas.\n\n"
            + "The output should look like this:\n\n"
            + "Meal Kit Overview:\n\n"
            + "Recipe 1: Chicken Fajitas Kit\n"
            + "- **Kits Possible:** 5\n"
            + "- **Missing Ingredients:** 1 pack of sour cream, 1 bag of shredded cheese.\n"
            + "- **Ingredients Included:**\n"
            + "   - 5 chicken breasts\n"
            + "   - 5 bell peppers\n"
            + "   - 5 onions\n"
            + "   - 5 tortillas\n"
            + "- **Instructions for Packaging:**\n"
            + "   1. Slice chicken breasts into strips.\n"
            + "   2. Slice bell peppers and onions.\n"
            + "   3. Package the chicken, vegetables, and tortillas into separate containers.\n"
            + "   4. Add instructions to heat in a pan and serve with optional sour cream and cheese.\n"
            + "\n--------------------------------------------------\n\n" // Line separator
            + "Recipe 2: Tomato Chicken Salad Kit\n"
            + "- **Kits Possible:** 3\n"
            + "- **Missing Ingredients:** 1 cucumber, 1 bottle of dressing.\n"
            + "- **Ingredients Included:**\n"
            + "   - 6 chicken breasts\n"
            + "   - 10 tomatoes\n"
            + "   - 2 bags of lettuce\n"
            + "- **Instructions for Packaging:**\n"
            + "   1. Grill chicken breasts and slice into strips.\n"
            + "   2. Slice tomatoes and cucumber (if available) for salad.\n"
            + "   3. Package chicken, tomatoes, lettuce, and optional dressing.\n"
            + "You can make a section in the bottom with some alternative suggestions on how to use the groceries in another manner\n"
            + "Highlight each recipe"
            + "I want the output in the Danish language";

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public OpenAiController(OpenAiService openAiService, FoodWasteService foodWasteService) {
        this.openAiService = openAiService;
        this.foodWasteService = foodWasteService;
    }

    //***GET MAPPING***-------------------------------------------------------------------------------------------------
    @GetMapping("/recipes")
    public String getRecipes(@RequestParam String storeId) {
        String foodWaste = foodWasteService.fetchFoodWasteByStoreId(storeId).block().toString();
        return openAiService.makeRequest(foodWaste, SYSTEM_MESSAGE).getAnswer();
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
