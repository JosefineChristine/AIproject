package org.example.aiproject.service;

import org.example.aiproject.model.Clearance;
import org.example.aiproject.model.Store;
import org.example.aiproject.model.StoreClearances;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodWasteService {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private final WebClient webClient;
    @Value("${app.api-key-salling}")
    private String API_KEY_SALLING;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public FoodWasteService(WebClient webClient) {
        this.webClient = webClient;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
//    //fetchFoodWasteByStoreId() uden at filtrere stock==0 fra
//    public Mono<List<Clearance>> fetchFoodWasteByStoreId(String id) { // virker
//        return webClient
//                .get()
//                .uri("https://api.sallinggroup.com/v1/food-waste/"+ id)
//                .header("Authorization", "Bearer " + API_KEY_SALLING)
//                .retrieve()
//                .bodyToMono(StoreClearances.class)
//                .map(StoreClearances::getClearances);
//    }

    public Mono<List<Clearance>> fetchFoodWasteByStoreId(String id) {
        return webClient
                .get()
                .uri("https://api.sallinggroup.com/v1/food-waste/" + id)
                .header("Authorization", "Bearer " + API_KEY_SALLING)
                .retrieve()
                .bodyToMono(StoreClearances.class)
                .map(StoreClearances::getClearances)
                .map(clearances -> clearances.stream()
                        .filter(clearance -> clearance.getOffer().getStock() > 0)
                        .collect(Collectors.toList()));
    }


    public Mono<Store> fetchStoreById(String id) {
        return webClient
                .get()
                .uri("https://api.sallinggroup.com/v2/stores/" + id)
                .header("Authorization", "Bearer " + API_KEY_SALLING)
                .retrieve()
                .bodyToMono(Store.class);
    }

    public Mono<List<Store>> fetchStores() { // virker
        return webClient
                .get()
                .uri("https://api.sallinggroup.com/v2/stores")
                .header("Authorization", "Bearer " + API_KEY_SALLING)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Store>>() {});
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
