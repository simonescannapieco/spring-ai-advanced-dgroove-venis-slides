package it.venis.ai.spring.demo.config;

...

@Configuration
public class HelpDeskChatClientConfig {

    @Value("classpath:/templates/get-help-desk-system-prompt.st")
    Resource helpDeskSystemPrompt;

    @Bean
    public ChatClient geminiHelpDeskToolsChatClient(
        OpenAiChatModel geminiChatModel, 
        HelpDeskTools helpDeskTools, 
        ChatMemory chatMemory, 
        @Qualifier("messageChatMemoryAdvisor") BaseChatMemoryAdvisor chatMemoryAdvisor) {

        ChatClient.Builder chatClientBuilder = ChatClient.builder(geminiChatModel);

        return chatClientBuilder
                .defaultTools(helpDeskTools)
                .defaultAdvisors(List.of(new SimpleLoggerAdvisor(), chatMemoryAdvisor))
                .defaultSystem(helpDeskSystemPrompt)
                .build();
    }

    ...