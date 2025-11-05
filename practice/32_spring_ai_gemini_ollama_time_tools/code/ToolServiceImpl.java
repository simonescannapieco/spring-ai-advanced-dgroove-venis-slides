package it.venis.ai.spring.demo.services;

...

@Service
public class ToolServiceImpl implements ToolService {

    private final ChatClient geminiToolChatClient;
    private final ChatClient ollamaToolChatClient;

    public ToolServiceImpl(
            @Qualifier("geminiToolChatClient") ChatClient geminiToolChatClient,
            @Qualifier("ollamaToolChatClient") ChatClient ollamaToolChatClient) {
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