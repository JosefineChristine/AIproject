package org.example.aiproject.openAI;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OpenAiController {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private final OpenAiService openAiService;

    final static String SYSTEM_MESSAGE = "Make recipes from the following ingredients. " +
            "You can add other ingredients to make good recipes.";

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public OpenAiController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    //***GET MAPPING***-------------------------------------------------------------------------------------------------
    @GetMapping("/recipes")
    public MyResponse getRecipes(@RequestParam String foodWaste) {
        return openAiService.makeRequest(foodWaste, SYSTEM_MESSAGE);
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
