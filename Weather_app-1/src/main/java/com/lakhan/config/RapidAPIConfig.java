package com.lakhan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RapidAPIConfig {
	
	
	    @Value("${rapidapi.host}")
	    private String rapidApiHost;

	    @Value("${rapidapi.key}")
	    private String rapidApiKey;

	    @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

	    public String getRapidApiHost() {
	        return rapidApiHost;
	    }

	    public String getRapidApiKey() {
	        return rapidApiKey;
	    }

}
