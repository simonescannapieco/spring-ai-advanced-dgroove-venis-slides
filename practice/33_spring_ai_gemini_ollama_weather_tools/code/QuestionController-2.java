    ...

    @PostMapping("/gemini/ask/weather-tools/temperature")
    public TemperatureResponse getGeminiTemperatureToolAnswer(@RequestBody WeatherRequest request) {

        return this.geminiWeatherToolsChatClient
                .prompt()
                .call()
                .entity(TemperatureResponse.class);
    }

    @PostMapping("/ollama/ask/weather-tools/temperature")
    public TemperatureResponse getOllamaTemperatureToolAnswer(@RequestBody WeatherRequest request) {

        return this.ollamaWeatherToolsChatClient
                .prompt()
                .call()
                .entity(TemperatureResponse.class);
    }

}
