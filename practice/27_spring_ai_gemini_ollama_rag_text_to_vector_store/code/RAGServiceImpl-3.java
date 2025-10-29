    ...
    @Value("classpath:templates/get-rag-data-system-ita-prompt.st")
    private Resource ragDataSystemItaPrompt;

    @Override
    public Answer getOllamaRAGTextToVectorStoreAnswer(QuestionRequest request) {

        SearchRequest searchRequest = SearchRequest.builder()
                .query(request.body().question())
                .topK(4)
                .similarityThreshold(.3)
                .build();

        List<Document> similarDocs = ollamaVectorStore.similaritySearch(searchRequest);

        String similarDocsString = similarDocs.stream()
                .map(Document::getText)
                .collect(Collectors.joining(System.lineSeparator()));

        return new Answer(this.ollamaMemoryChatClient.prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, request.username()))
                .system(s -> s.text(this.ragDataSystemItaPrompt)
                        .params(Map.of("documenti", similarDocsString)))
                .user(request.body().question())
                .templateRenderer(StTemplateRenderer.builder().startDelimiterToken('<')
                        .endDelimiterToken('>')
                        .build())
                .call()
                .content());
    }

}