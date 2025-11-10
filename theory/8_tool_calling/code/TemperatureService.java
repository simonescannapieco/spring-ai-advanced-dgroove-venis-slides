public class TemperatureService implements Function<WeatherRequest, TemperatureResponse> {
    
    public WeatherResponse apply(WeatherRequest request) {
        ...
    }
    
}

public enum Unit { C, F }

public record WeatherRequest(
    @ToolParam(description = "Il nome di una città o di una nazione.") String location, Unit unit) {}

public record TemperatureResponse(double temp, Unit unit) {}