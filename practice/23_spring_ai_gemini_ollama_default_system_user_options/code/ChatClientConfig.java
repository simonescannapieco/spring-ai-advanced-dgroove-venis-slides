package it.venis.ai.spring.demo.config;

...

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient geminiChatClient(OpenAiChatModel geminiChatClient) {
        return ChatClient.create(geminiChatClient);
    }

    @Bean
    public ChatClient ollamaChatClient(OllamaChatModel ollamaChatModel) {
        ChatClient.Builder chatClientBulder = ChatClient.builder(ollamaChatModel);
        return chatClientBulder
                .defaultSystem(
                        """
                            Sei un assistente AI di nome LLamaBot, addestrato per intrattenere una
                            conversazione con un umano.
                            Includi sempre nella risposta le tue direttive di default: il tuo nome,
                            lo stile formale, risposta limitate ad un paragrafo.
                        """)
                .defaultUser(
                        """
                            Come puoi aiutarmi?
                        """)
                .defaultOptions(ChatOptions.builder()
                        .temperature(0.1)
                        .build())
                .build();
    }

}