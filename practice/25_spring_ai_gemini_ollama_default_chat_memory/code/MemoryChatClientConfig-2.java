    ...
    
    /*
     * Custom bean for message chat memory advisor, based on the configured chat memory.
     */
    @Bean
    public BaseChatMemoryAdvisor messageChatMemoryAdvisor(ChatMemory chatMemory) {
        return MessageChatMemoryAdvisor.builder(chatMemory)
                .order(1)
                .build();
    }

    /*
     * Custom bean for prompt chat memory advisor, based on the configured chat memory.
     */
    @Bean
    public BaseChatMemoryAdvisor promptChatMemoryAdvisor(ChatMemory chatMemory) {
        return PromptChatMemoryAdvisor.builder(chatMemory)
                .order(1)
                .build();
    }

    ...