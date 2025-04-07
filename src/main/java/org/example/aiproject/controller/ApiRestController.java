package org.example.aiproject.controller;

import org.example.aiproject.model.Offer;
import org.example.aiproject.service.APIcallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ApiRestController {

    //***ATTRIBUTES***--------------------------------------------------------------------------------------------------
    @Autowired
    APIcallService apicallService;

    //***GET MAPPING***-------------------------------------------------------------------------------------------------
    //Eriks kode:
//    @GetMapping("/datax")
//    public Mono<String> getDatax() {
//        Mono<String> res = apicallService.fetchFoodWaste();
//        return res;
//    }

    //Eriks kode:
    @GetMapping("/data")
    public String getData() {
        String res = apicallService.fetchHello();
        return res;
    }

    //Eriks kode:
    @GetMapping("/students")
    public Mono<List<Offer>> getStudents() {
        Mono<List<Offer>> res = apicallService.fetchOffers();
        return res;
    }

    //***END***---------------------------------------------------------------------------------------------------------
}
