package com.example.weather_api.service;

import com.example.weather_api.model.Weather;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = currentDate.format(formatter);

    public String getWeatherByCity(String city) {
        String url = BASE_URL + city + "/" + formattedDate + "/" + "?key=";
        return restTemplate.getForObject(url, String.class);
    }

//    public Weather getWeatherByCity(String city) {
//        String url = BASE_URL + city + "/" + formattedDate + "/" + "?key=";
//        String jsonResponse = restTemplate.getForObject(url, String.class);
//
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode root = mapper.readTree(jsonResponse);
//            Weather weather = new Weather();
//            weather.setCity(city);
//            weather.setLatitude(root.path("latitude").asDouble());
//            weather.setLongitude(root.path("longitude").asDouble());
//            weather.setTemperature(root.path("currentConditions").path("temp").asDouble());
//            weather.setHumidity(root.path("currentConditions").path("humidity").asDouble());
//            weather.setPressure(root.path("currentConditions").path("pressure").asDouble());
//            weather.setWindSpeed(root.path("currentConditions").path("windSpeed").asDouble());
//            return weather;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
