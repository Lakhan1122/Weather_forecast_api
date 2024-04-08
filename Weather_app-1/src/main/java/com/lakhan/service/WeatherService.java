package com.lakhan.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;



import com.lakhan.config.RapidAPIConfig;

@Service
public class WeatherService {
	
	    @Autowired
	    private RestTemplate restTemplate;

	    @Autowired
	    private RapidAPIConfig rapidAPIConfig;

	    public String getForecastSummary(String cityName) throws IOException, InterruptedException {
	        // Construct the URI with the required endpoint and query parameters
	    	URI uri = UriComponentsBuilder.fromUriString("https://" + rapidAPIConfig.getRapidApiHost() + "/rapidapi/forecast/" + cityName + "/summary/")
	    	        .build()
	    	        .toUri();


	        // Create HttpRequest with necessary headers
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(uri)
	                .header("X-RapidAPI-Key", rapidAPIConfig.getRapidApiKey())
	                .header("X-RapidAPI-Host", rapidAPIConfig.getRapidApiHost())
	                .GET()
	                .build();

	        try {
	            // Send the request and get the response
	            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

	            // Check if response is successful
	            if (response.statusCode() == 200) {
	                return response.body(); // Return the response body on success
	            } else {
	                // Handle error status codes
	                return "Error: " + response.statusCode(); // Return error message
	            }
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace(); // Print stack trace for any exceptions
	            return "Error occurred: " + e.getMessage(); // Return error message
	        }
	    }






	    public String getHourlyForecast(String cityName) throws IOException, InterruptedException {
	        String apiKey = "cd5b264d33744b0c5e89b09f48dcd959";
	        String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid=" + apiKey;
	        return restTemplate.getForObject(url, String.class);
	    }

}
