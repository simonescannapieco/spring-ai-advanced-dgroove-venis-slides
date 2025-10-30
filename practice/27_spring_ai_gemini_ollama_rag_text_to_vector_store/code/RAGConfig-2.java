    ...
    @Bean
    public VectorStore geminiVectorStore(QdrantClient qdrantClient, OpenAiEmbeddingModel geminiEmbeddingModel) {
        return QdrantVectorStore.builder(qdrantClient, geminiEmbeddingModel)
                .collectionName(qdrantCollectionNameGemini)
                .initializeSchema(qdrantInitializeSchema)
                .build();
    }

    @Bean
    public VectorStore ollamaVectorStore(QdrantClient qdrantClient, OllamaEmbeddingModel ollamaEmbeddingModel) {
        return QdrantVectorStore.builder(qdrantClient, ollamaEmbeddingModel)
                .collectionName(qdrantCollectionNameOllama)
                .initializeSchema(qdrantInitializeSchema)
                .build();
    }

}