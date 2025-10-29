    ...
    @Bean
    public QdrantClient qdrantClient() {
        QdrantGrpcClient.Builder grpcClientBuilder = QdrantGrpcClient.newBuilder(
                qdrantHost == null ? "localhost" : qdrantHost,
                qdrantPort == null ? 6334 : Integer.valueOf(qdrantPort),
                useTls == null ? false : Boolean.valueOf(useTls));
        return new QdrantClient(grpcClientBuilder.build());
    }

    @Value("${spring.ai.vectorstore.qdrant.collection-name.gemini:#{null}}")
    private String qdrantCollectionNameGemini;
    @Value("${spring.ai.vectorstore.qdrant.collection-name.ollama:#{null}}")
    private String qdrantCollectionNameOllama;
    @Value("${spring.ai.vectorstore.qdrant.initialize-schema:#{null}}")
    private String qdrantInitializeSchema;

    @Bean
    public VectorStore geminiVectorStore(QdrantClient qdrantClient,
            @Qualifier("openAiEmbeddingModel") EmbeddingModel geminiEmbeddingModel) {
        return QdrantVectorStore.builder(qdrantClient, geminiEmbeddingModel)
            .collectionName(qdrantCollectionNameGemini == null ? "vector_store_gemini" : qdrantCollectionNameGemini)
            .initializeSchema(qdrantInitializeSchema == null ? false : Boolean.valueOf(qdrantInitializeSchema))
            .build();
    }

    @Bean
    public VectorStore ollamaVectorStore(QdrantClient qdrantClient,
            @Qualifier("ollamaEmbeddingModel") EmbeddingModel ollamaEmbeddingModel) {
        return QdrantVectorStore.builder(qdrantClient, ollamaEmbeddingModel)
            .collectionName(qdrantCollectionNameOllama == null ? "vector_store_ollama" : qdrantCollectionNameOllama)
            .initializeSchema(qdrantInitializeSchema == null ? false : Boolean.valueOf(qdrantInitializeSchema))
            .build();
    }}