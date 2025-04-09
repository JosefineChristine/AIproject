package org.example.aiproject.controller;

import org.example.aiproject.model.Clearance;
import org.example.aiproject.model.Store;
import org.example.aiproject.service.FoodWasteService;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/salling")
public class FoodWasteController {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private final FoodWasteService foodWasteService;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public FoodWasteController(FoodWasteService foodWasteService) {
        this.foodWasteService = foodWasteService;
    }

    //***GET MAPPING***-------------------------------------------------------------------------------------------------

    @GetMapping("/stores")
    public List<Store> getStores() {
        return foodWasteService.fetchStores();
    }

    @GetMapping("/food-waste/{id}")
    public Mono<List<Clearance>> getFoodWasteByStore(@PathVariable String id) {
        return foodWasteService.fetchFoodWasteByStoreId(id);
    }

    //***END***---------------------------------------------------------------------------------------------------------
}

