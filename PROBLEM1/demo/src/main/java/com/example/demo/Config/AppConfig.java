package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${app.window-size}")
    private int windowSize;

    @Value("${app.request-timeout}")
    private int requestTimeout;

    @Value("${test.server.primes}")
    private String primesUrl;

    @Value("${test.server.fibo}")
    private String fiboUrl;

    @Value("${test.server.even}")
    private String evenUrl;

    @Value("${test.server.rand}")
    private String randUrl;

    public int getWindowSize() {
        return windowSize;
    }

    public int getRequestTimeout() {
        return requestTimeout;
    }

    public String getPrimesUrl() {
        return primesUrl;
    }

    public String getFiboUrl() {
        return fiboUrl;
    }

    public String getEvenUrl() {
        return evenUrl;
    }

    public String getRandUrl() {
        return randUrl;
    }
}
