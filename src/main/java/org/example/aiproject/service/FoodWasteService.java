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

@Service
public class FoodWasteService {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private final WebClient webClient;
    @Value("${app.api-key}")
    private String API_KEY;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    public FoodWasteService(WebClient webClient) {
        this.webClient = webClient;
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public Mono<List<Clearance>> fetchFoodWasteByStoreId(String id) { // virker
        return webClient
                .get()
                .uri("https://api.sallinggroup.com/v1/food-waste/"+ id)
                .header("Authorization", "Bearer " + API_KEY)
                .retrieve()
                .bodyToMono(StoreClearances.class)
                .map(StoreClearances::getClearances);
    }

    public Mono<Store> fetchStoreById(String id) { // virker
        return webClient
                .get()
                .uri("https://api.sallinggroup.com/v2/stores/" + id)
                .header("Authorization", "Bearer " + API_KEY)
                .retrieve()
                .bodyToMono(Store.class);
    }

//    public String fetchStoreIdByName(String name) {
//        List<Store> stores = fetchStores();
//        Store selectedStore = null;
//        for(Store store : stores){
//            if(store.getName().equalsIgnoreCase(name)){
//               selectedStore = store;
//            }
//        }
//        return selectedStore.getId();
//    }

    public List<Store> fetchStores() { // virker
        Mono<List<Store>> storesMono = webClient
                .get()
                .uri("https://api.sallinggroup.com/v2/stores")
                .header("Authorization", "Bearer " + API_KEY)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Store>>() {});

        List<Store> storeList = storesMono.block();

        return storeList;
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
