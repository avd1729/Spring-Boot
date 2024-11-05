package com.example.weather_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    public String getExternalData(String url) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException e) {
            // Handle client errors
            return "Client Error: " + e.getStatusCode();
        } catch (HttpServerErrorException e) {
            // Handle server errors
            return "Server Error: " + e.getStatusCode();
        }
    }
}
