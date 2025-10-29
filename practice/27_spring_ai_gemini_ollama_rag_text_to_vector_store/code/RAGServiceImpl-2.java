    ...
    @Value("classpath:templates/get-rag-data-system-eng-prompt.st")
    private Resource ragDataSystemEngPrompt;

    @Override
    public Answer getGeminiRAGTextToVectorStoreAnswer(QuestionRequest request) {

        SearchRequest searchRequest = SearchRequest.builder()
                .query(request.body().question())
                .topK(4)
                .similarityThreshold(.2)
                .build();

        List<Document> similarDocs = geminiVectorStore.similaritySearch(searchRequest);

        String similarDocsString = similarDocs.stream()
                .map(Document::getText)
                .collect(Collectors.joining(System.lineSeparator()));

        return new Answer(this.geminiChatClient.prompt()
                .system(s -> s.text(this.ragDataSystemEngPrompt)
                        .params(Map.of("documenti", similarDocsString)))
                .user(request.body().question())
                .templateRenderer(StTemplateRenderer.builder().startDelimiterToken('<')
                        .endDelimiterToken('>')
                        .build())
                .call()
                .content());
    }

    ...