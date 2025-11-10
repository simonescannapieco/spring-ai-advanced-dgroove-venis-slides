    ...

    @Bean
    public ChatClient ollamaWeatherToolsChatClient(OllamaChatModel ollamaChatModel) {

        ChatClient.Builder chatClientBuilder = ChatClient.builder(ollamaChatModel);

        return chatClientBuilder
                .defaultToolCallbacks(toolCallback)
                .defaultAdvisors(List.of(new SimpleLoggerAdvisor(), new OllamaCostSavingsAdvisor()))
                .defaultSystem(
                    """
                        Sei un assistente AI di nome WeatherLlamaBot, addestrato per fornire
                        informazioni meteo alle persone.
                    """)
                .build();
    }

}
