    ...
    @Override
    public List<Document> retrieve(Query query) {
        Assert.notNull(query, "query cannot be null");
        String q = query.text();
        Assert.hasText(q, "query.text() cannot be empty");

        TavilyResponsePayload response = restClient.post()
                .body(new TavilyRequestPayload(q, "advanced", resultLimit))
                .retrieve()
                .body(TavilyResponsePayload.class);

        if (response == null || CollectionUtils.isEmpty(response.results())) {
            return List.of();
        }

        List<Document> docs = new ArrayList<>(response.results().size());
        for (TavilyResponsePayload.Hit hit : response.results()) {
            // Map each Tavily hit into a Spring AI Document with metadata and score.
            Document doc = Document.builder()
                    .text(hit.content())
                    .metadata("title", hit.title())
                    .metadata("url", hit.url())
                    .score(hit.score())
                    .build();
            docs.add(doc);
        }
        return docs;
    }
    
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    record TavilyRequestPayload(String query, String searchDepth, int maxResults) {}
    ...
