
    ...
    
    @Bean
    public ChatClient ollamaHelpDeskToolsChatClient(
        OllamaChatModel ollamaChatModel, 
        HelpDeskTools helpDeskTools, 
        ChatMemory chatMemory, 
        @Qualifier("messageChatMemoryAdvisor") BaseChatMemoryAdvisor chatMemoryAdvisor) {

        ChatClient.Builder chatClientBuilder = ChatClient.builder(ollamaChatModel);

        return chatClientBuilder
                .defaultTools(helpDeskTools)
                .defaultAdvisors(List.of(new SimpleLoggerAdvisor(), 
                                         new OllamaCostSavingsAdvisor(), 
                                         chatMemoryAdvisor))
                .defaultSystem(helpDeskSystemPrompt)
                .build();
    }

}