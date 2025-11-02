    ...

    record TavilyResponsePayload(List<Hit> results) {
        record Hit(String title, String url, String content, Double score) {}
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private RestClient.Builder clientBuilder;
        private int resultLimit = DEFAULT_RESULT_LIMIT;

        private Builder() {}

        public Builder restClientBuilder(RestClient.Builder clientBuilder) {
            this.clientBuilder = clientBuilder;
            return this;
        }

        public Builder maxResults(int maxResults) {
            if (maxResults <= 0) {
                throw new IllegalArgumentException("maxResults must be greater than 0");
            }
            this.resultLimit = maxResults;
            return this;
        }

        public WebSearchDocumentRetriever build() {
            return new WebSearchDocumentRetriever(clientBuilder, resultLimit);
        }
    }
}
