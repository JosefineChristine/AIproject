//package org.example.aiproject.config;
//
//import org.example.aiproject.service.FoodWasteService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ApiDataPrinter implements CommandLineRunner {
//
//    private final FoodWasteService foodWasteService;
//
//    public ApiDataPrinter(FoodWasteService foodWasteService) {
//        this.foodWasteService = foodWasteService;
//    }
//
////    @Override
////    public void run(String... args) throws Exception {
//////        foodWasteService.fetchFoodWasteByStoreId("abc74dcc-1696-4e94-bcef-d00c44fb58a9")
//////                .block()
//////                .forEach(System.out::println);
//////        System.out.println(foodWasteService.fetchStoreById("abc74dcc-1696-4e94-bcef-d00c44fb58a9").block());
//////        foodWasteService.fetchStores().forEach(System.out::println);
////
////    }
//
//}
