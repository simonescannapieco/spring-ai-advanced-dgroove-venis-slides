@Override
public Answer getOllamaToolLocalTimeAnswer(QuestionRequest request) {

    return new Answer(this.ollamaToolChatClient
        .prompt()
        .tools(timeTools)
        ...
        .call()
        .content());
        
}