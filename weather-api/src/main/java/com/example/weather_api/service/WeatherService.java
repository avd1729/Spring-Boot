package com.example.weather_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

//    private final String API_KEY = "your_api_key";
    private final String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/pollachi/2024-11-05/2024-11-05?key=";

    public String getWeatherByCity(String city) {
        String url = BASE_URL;
        return restTemplate.getForObject(url, String.class);
    }
}
