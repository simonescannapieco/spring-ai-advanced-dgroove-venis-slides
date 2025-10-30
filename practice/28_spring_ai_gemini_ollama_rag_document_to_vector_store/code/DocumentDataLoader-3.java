    ...
    @PostConstruct
    public void loadVenisHRItaDocumentIntoVectorStore() {

        SearchRequest searchRequest = SearchRequest.builder()
                .query("Check")
                .similarityThresholdAll()
                .build();

        List<Document> similarDocs = ollamaVectorStore.similaritySearch(searchRequest);

        if (similarDocs.size() == 0) {
            TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(venisHRItaDocument);

            List<Document> docs = tikaDocumentReader.get();

            TextSplitter textSplitter = TokenTextSplitter.builder()
                    .withChunkSize(100)
                    .withMaxNumChunks(400)
                    .withKeepSeparator(false)
                    .build();

            this.ollamaVectorStore.add(textSplitter.split(docs));
        }

    }

}