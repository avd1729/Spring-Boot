package com.example.weather_api.controller;

import com.example.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/{city}")
    @Cacheable(value = "weather", key = "#city")
    public String getWeather(@PathVariable String city) {
        return weatherService.getWeatherByCity(city);
    }
}
