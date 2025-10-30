    ...
    @PostConstruct
    public void loadVenisHREngDocumentIntoVectorStore() {

        SearchRequest searchRequest = SearchRequest.builder()
                .query("Check")
                .similarityThresholdAll()
                .build();

        List<Document> similarDocs = geminiVectorStore.similaritySearch(searchRequest);

        if (similarDocs.size() == 0) {
            TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(venisHREngDocument);

            List<Document> docs = tikaDocumentReader.get();

            TextSplitter textSplitter = TokenTextSplitter.builder()
                    .withChunkSize(100)
                    .withMaxNumChunks(400)
                    .withKeepSeparator(true)
                    .build();

            this.geminiVectorStore.add(textSplitter.split(docs));
        }

    }

    ...