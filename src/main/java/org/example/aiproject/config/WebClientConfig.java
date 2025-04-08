package org.example.aiproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    //***WHATIS WEBCLIENT***--------------------------------------------------------------------------------------------
    //What is WebClient?
    //WebClient is a tool in Spring that helps your app talk to other websites or services over the internet.
    //Just like when you open a browser and go to https://google.com, your app can use WebClient to "go to" other APIs and get data.

    //  What can it do?
    //- Make GET requests (like: “Hey, give me some data!”)
    //- Make POST requests (like: “Hey, here’s some data!”)
    //- Send headers (like API keys or tokens)
    //- Get the response back — without freezing or blocking your app

    //***METHODS***-----------------------------------------------------------------------------------------------------
    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }

}
