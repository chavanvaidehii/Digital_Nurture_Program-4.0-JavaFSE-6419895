package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {

    @Test
    public void testFetchWeather() {
        System.out.println(" Starting testFetchWeather...");

        //  Mock the external API
        ExternalApi mockApi = mock(ExternalApi.class);
        System.out.println("ExternalApi mocked successfully.");

        //  Stub the method to return mock data
        when(mockApi.getData()).thenReturn("Sunny");
        System.out.println("Mock data 'Sunny' set for getData() method.");

        // Call the service
        WeatherService service = new WeatherService(mockApi);
        String result = service.fetchWeather();

        // Assert the result
        assertEquals("Sunny", result);
        System.out.println("Test passed. Received weather: " + result);
    }
}
