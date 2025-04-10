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

    final static String SYSTEM_MESSAGE = "Make recipes from the following ingredients. " +
            "You can add other ingredients to make good recipes.";

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
