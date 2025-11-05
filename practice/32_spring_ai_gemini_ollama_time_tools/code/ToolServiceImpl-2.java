    ...

    @Override
    public Answer getOllamaToolLocalTimeAnswer(QuestionRequest request) {
        return new Answer(this.ollamaToolChatClient
                .prompt()
                .user(request.body().question())
                .call()
                .content());
    }

}
