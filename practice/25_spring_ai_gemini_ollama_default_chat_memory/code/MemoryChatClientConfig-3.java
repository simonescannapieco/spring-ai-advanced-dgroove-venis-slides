    ...
    
    /*
     * Custom chat client based on the configured chat advisor.
     */
    @Bean
    public ChatClient ollamaMemoryChatClient(OllamaChatModel ollamaChatModel, 
                ChatMemory chatMemory, 
                @Qualifier("promptChatMemoryAdvisor") BaseChatMemoryAdvisor chatMemoryAdvisor) {

        ChatClient.Builder chatClientBuilder = ChatClient.builder(ollamaChatModel);

        return chatClientBuilder
                .defaultAdvisors(List.of(
                        new SimpleLoggerAdvisor(),
                        new OllamaCostSavingsAdvisor(),
                        chatMemoryAdvisor))
                .defaultSystem(
                        """
                            Sei un assistente AI di nome LLamaMemoryBot, addestrato per intrattenere una
                            conversazione con un umano.
                        """)
                .defaultOptions(ChatOptions.builder()
                        .temperature(0.1)
                        .build())
                .build();

    }

}