package com.lakhan.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.lakhan.service.WeatherService;

@RestController
@CrossOrigin(origins = "https://6613b7fd914aad7c9689c71c--spontaneous-salamander-0ee224.netlify.app/")
public class WeatherController {
	
	    @Autowired
	    private WeatherService weatherService;

	    private final String validClientId = "13";
	    private final String validClientSecret = "lakhan";

	    @GetMapping("/api/weather/forecast-summary")
	    public ResponseEntity<String> getForecastSummary(@RequestParam String cityName,
	                                                     @RequestHeader(value = "clientId", required = false) String clientId,
	                                                     @RequestHeader(value = "clientSecret", required = false) String clientSecret) {
	        // Check if clientId and clientSecret are provided
	        if (clientId == null || clientSecret == null) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing credentials");
	        }

	        // Validate the client credentials
	        if (!isValidClient(clientId, clientSecret)) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }

	        try {
	            // Call the service to get the forecast summary
	            String summary = weatherService.getForecastSummary(cityName);
	            return ResponseEntity.ok(summary);
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching forecast summary");
	        }
	    }



	    @GetMapping("/api/weather/hourly-forecast")
	    public ResponseEntity<String> getHourlyForecast(@RequestParam String cityName,
	                                                    @RequestHeader(value = "clientId", required = true) String clientId,
	                                                    @RequestHeader(value = "clientSecret", required = true) String clientSecret) {
	        if (clientId == null || clientSecret == null || !isValidClient(clientId, clientSecret)) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }

	        try {
	            String forecast = weatherService.getHourlyForecast(cityName);
	            return ResponseEntity.ok(forecast);
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching hourly forecast");
	        }
	    }

	   

	    private boolean isValidClient(String clientId, String clientSecret) {
	        return validClientId.equals(clientId) && validClientSecret.equals(clientSecret);
	    }
}
