    ...
    @Value("${demo.rag.prompt.system.eng}")
    private Resource ragDataSystemEngPrompt;

    @Override
    public Answer getGeminiRAGAnswer(QuestionRequest request) {

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
                // .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID,
                // request.username()))
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