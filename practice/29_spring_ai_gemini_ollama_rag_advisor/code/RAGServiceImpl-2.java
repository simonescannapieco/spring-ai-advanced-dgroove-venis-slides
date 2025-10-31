    ...
    @Override
    public Answer getGeminiRAGAnswer(QuestionRequest request) {
        /*
         * This code is no longer needed, because all is handled by the logic behind the
         * geminiRetrievalAugmentationAdvisor!
         * 
         * SearchRequest searchRequest = SearchRequest.builder()
         * .query(request.body().question())
         * .topK(4)
         * .similarityThreshold(.2)
         * .build();
         *
         * List<Document> similarDocs =
         * geminiVectorStore.similaritySearch(searchRequest);
         *
         * String similarDocsString = similarDocs.stream()
         * .map(Document::getText)
         * .collect(Collectors.joining(System.lineSeparator()));
         */
        
        ...