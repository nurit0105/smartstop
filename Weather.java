package com.SmartStop;

import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//API Key: 5919a75387b14f14be3154456221104

@SpringBootApplication
@RestController
public class Weather {

    private String output;

    public String output(){
        return this.output;
    }

    private static final Logger log = LoggerFactory.getLogger(Weather.class);

    public static void main(String[] args){
        SpringApplication.run(Weather.class, args);
    }

    @Bean
    public RestTemplate restTemplateWeather(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner runWeather(RestTemplate restTemplate) throws Exception {
        return args -> {
            String json = restTemplate.getForObject(
                    "https://api.weatherapi.com/v1/current.json?key=5919a75387b14f14be3154456221104&q=Vienna&aqi=no", String.class);
            log.info(json);
            output = json;

            String jsonPathExpression = "$.current.temp_c";
            String filtered = JsonPath.parse(json).read(jsonPathExpression, String.class); //filter Json for needed data

            output = "The current temperature is: "+ filtered + "°C";
        };
    }

    @GetMapping("/weather")
    public String weather(){
        return output;
    }
}
