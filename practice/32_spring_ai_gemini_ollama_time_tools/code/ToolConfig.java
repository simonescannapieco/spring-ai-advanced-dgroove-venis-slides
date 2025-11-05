package it.venis.ai.spring.demo.config;

...

@Configuration
public class ToolConfig {
    
    @Bean
    public ChatClient geminiToolChatClient(OpenAiChatModel geminiChatModel, TimeTools timeTools) {

        ChatClient.Builder chatClientBuilder = ChatClient.builder(geminiChatModel);

        return chatClientBuilder
                .defaultTools(timeTools)
                .defaultAdvisors(List.of(new SimpleLoggerAdvisor()))
                .defaultSystem(
                        """
                            Sei un assistente AI di nome ToolGeminiBot, addestrato per intrattenere una
                            conversazione con un umano.
                            Usa i tool forniti dall'utente per fornire la tua risposta.
                        """)
                .defaultUser(
                        """
                            Come puoi aiutarmi?
                        """)
                .build();

    }  

    ...
