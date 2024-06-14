package com.example.demo.Util;

import com.example.demo.Config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class NumberFetch {

    @Autowired
    private AppConfig config;

    @Autowired
    private RestTemplate restTemplate;

    public List<Integer> fetchNumbers(String qualifier) {
        String url = getUrlByQualifier(qualifier);
        if (url == null) {
            return Collections.emptyList();
        }

        try {
            Map<String, List<Integer>> response = restTemplate.getForObject(url, Map.class);
            return (List<Integer>) response.get("numbers");
        } catch (HttpClientErrorException e) {
            // Handle HTTP errors
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                // Handle 404 errors
                return Collections.emptyList();
            } else {
                throw e;
            }
        } catch (Exception e) {
            // Handle other exceptions
            return Collections.emptyList();
        }
    }

    private String getUrlByQualifier(String qualifier) {
        switch (qualifier) {
            case "p":
                return config.getPrimesUrl();
            case "f":
                return config.getFiboUrl();
            case "e":
                return config.getEvenUrl();
            case "r":
                return config.getRandUrl();
            default:
                return null;
        }
    }
}
