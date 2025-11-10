@Configuration(proxyBeanMethods = false)
class WeatherTools {

    public static final String GET_TEMP_IN_LOCATION_FUNCTION_NAME = "getTemperatureInLocation";

	@Bean(GET_TEMP_IN_LOCATION_FUNCTION_NAME)
	@Description("Ottieni la temperatura corrente nella località specificata.")
	Function<WeatherRequest, TemperatureResponse> currentTemperature() {
		return new TemperatureService();
	}

}

public enum Unit { C, F }

public record WeatherRequest(
    @ToolParam(description = "Il nome di una città o di una nazione.") String location, Unit unit) {}

public record TemperatureResponse(double temp, Unit unit) {}