package it.venis.ai.spring.demo.config;

...

@Configuration
public class WeatherToolsConfig {

    public static final String GET_TEMP_IN_LOCATION_FUNCTION_NAME = "getTemperatureInLocation";

    ToolCallback toolCallback = FunctionToolCallback
        .builder(GET_TEMP_IN_LOCATION_FUNCTION_NAME, new TemperatureService())
        .description("Ottieni la temperatura corrente nella località specificata.")
        .inputType(WeatherRequest.class)
        .toolMetadata(ToolMetadata.builder()
            .returnDirect(true)
            .build())
        .build();

    @Bean
    public ChatClient geminiWeatherToolsChatClient(OpenAiChatModel geminiChatModel) {

        ChatClient.Builder chatClientBuilder = ChatClient.builder(geminiChatModel);
        return chatClientBuilder
                .defaultToolCallbacks(toolCallback)
                .defaultAdvisors(List.of(new SimpleLoggerAdvisor()))
                .defaultSystem(
                    """
                        Sei un assistente AI di nome WeatherGeminiBot, addestrato per fornire
                        informazioni meteo alle persone.
                        Utilizza quando possibile il tool 'getTemperatureInLocation'.
                    """)
                .build();
    }
    ...