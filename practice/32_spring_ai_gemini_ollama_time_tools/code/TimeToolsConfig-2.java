    ...
    @Bean
    public ChatClient ollamaToolChatClient(OllamaChatModel ollamaChatModel, TimeTools timeTools) {

        ChatClient.Builder chatClientBuilder = ChatClient.builder(ollamaChatModel);

        return chatClientBuilder
                .defaultTools(timeTools)
                .defaultAdvisors(List.of(new SimpleLoggerAdvisor()))
                .defaultSystem(
                        """
                            Sei un assistente AI di nome ToolLlamaBot, addestrato per intrattenere una
                            conversazione con un umano.
                            Usa i tool forniti dall'utente per fornire la tua risposta.
                        """)
                .defaultUser(
                        """
                            Come puoi aiutarmi?
                        """)
                .build();

    }    

}