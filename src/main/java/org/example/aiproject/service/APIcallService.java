package org.example.aiproject.service;

import org.example.aiproject.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class APIcallService {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    private final WebClient webClient;

    @Value("${API_KEY_SALLING}")
    private String API_KEY;

    //***CONSTRUCTOR***-------------------------------------------------------------------------------------------------
    @Autowired
    public APIcallService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.sallinggroup.com").build();
    }

    //***METHODS***-----------------------------------------------------------------------------------------------------
    public Mono<String> fetchFoodWaste(int id) {
        Mono<String> hello = webClient
                .get()
                .uri("/v1/food-waste/{id}")
                .retrieve()
                .bodyToMono(String.class);
        return hello;
    }

    //TODO *return type?
    public String fetchClearanceForSpecificStore(int id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/food-waste/{id}")
                        .queryParam("id", id)
                        .queryParam("limit", 3)
                        .build())
                .header("X-Api-Key", API_KEY) //check if works here?
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String fetchHello() {
        var obj =  webClient
                .get()
                .uri("/hello/10000")
                .retrieve();
        //.bodyToMono(String.class);

        var hello = obj.bodyToMono(String.class);
        var hej = hello.block();

        return hej;
    }

    public Mono<List<Offer>> fetchOffers() {
        Mono<List<Offer>> offers = webClient
                .get()
                .uri("/offers")
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Offer>>() {});

        return offers;
    }

    public List<Offer> fetchOffersBlock() {
        Mono<List<Offer>> offersMono = webClient
                .get()
                .uri("/offers")
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Offer>>() {});


        List<Offer> offers =  offersMono.block();

        return offers;
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
