package it.venis.ai.spring.demo.services;

...

@Service
public class TimeToolsServiceImpl implements TimeToolsService {

    private final ChatClient geminiToolChatClient;
    private final ChatClient ollamaToolChatClient;

    public TimeToolsServiceImpl(
            @Qualifier("geminiTimeToolsChatClient") ChatClient geminiToolChatClient,
            @Qualifier("ollamaTimeToolsChatClient") ChatClient ollamaToolChatClient) {

        this.geminiToolChatClient = geminiToolChatClient;
        this.ollamaToolChatClient = ollamaToolChatClient;

    }

    @Override
    public Answer getGeminiToolLocalTimeAnswer(QuestionRequest request) {

        return new Answer(this.geminiToolChatClient
                .prompt()
                .user(request.body().question())
                .call()
                .content());

    }

    ...