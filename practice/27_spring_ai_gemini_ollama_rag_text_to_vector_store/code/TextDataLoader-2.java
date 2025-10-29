    ...
    @PostConstruct
    public void loadSSCVInfoIntoVectorStore() {
        List<String> ssCVInfo = List.of(...);
        SearchRequest searchRequest = SearchRequest.builder()
                .query("Check")
                .similarityThresholdAll()
                .build();
        List<Document> similarDocs = ollamaVectorStore.similaritySearch(searchRequest);
        if (similarDocs.size() == 0) {
            List<Document> documents = ssCVInfo.stream().map(Document::new).collect(Collectors.toList());
            this.ollamaVectorStore.add(documents);
        }

    }

}
