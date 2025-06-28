package org.example;

public class WeatherService {
    private final ExternalApi api;

    public WeatherService(ExternalApi api) {
        this.api = api;
        System.out.println("WeatherService initialized with external API.");
    }

    public String fetchWeather() {
        System.out.println("Fetching weather data from external API...");
        return api.getData();
    }
}
