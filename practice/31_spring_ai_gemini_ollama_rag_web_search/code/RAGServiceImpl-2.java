    ...
    
    @Override
    public Answer getOllamaWebSearchRAGAnswer(QuestionRequest request) {
        return new Answer(this.ollamaChatClient.prompt()
            .advisors(List.of(this.webSearchRetrievalAugmentationAdvisor))
            .user(request.body().question())
            .call()
            .content());
        }

}