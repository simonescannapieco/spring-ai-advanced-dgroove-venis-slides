package it.venis.ai.spring.demo.controllers;

...

@RestController
@Configuration
public class QuestionController {

    ...
    private final ChatClient geminiHelpDeskToolsChatClient;
    private final ChatClient ollamaHelpDeskToolsChatClient;

    public QuestionController(QuestionService service,
            RAGService ragService,
            TimeToolsService timeToolsService,
            @Qualifier("geminiWeatherToolsChatClient") ChatClient geminiWeatherToolsChatClient,
            @Qualifier("ollamaWeatherToolsChatClient") ChatClient ollamaWeatherToolsChatClient,
            @Qualifier("geminiHelpDeskToolsChatClient") ChatClient geminiHelpDeskToolsChatClient,
            @Qualifier("ollamaHelpDeskToolsChatClient") ChatClient ollamaHelpDeskToolsChatClient) {

        this.service = service;
        this.ragService = ragService;
        this.timeToolsService = timeToolsService;
        this.geminiWeatherToolsChatClient = geminiWeatherToolsChatClient;
        this.ollamaWeatherToolsChatClient = ollamaWeatherToolsChatClient;
        this.geminiHelpDeskToolsChatClient = geminiHelpDeskToolsChatClient;
        this.ollamaHelpDeskToolsChatClient = ollamaHelpDeskToolsChatClient;

    }

    ...
