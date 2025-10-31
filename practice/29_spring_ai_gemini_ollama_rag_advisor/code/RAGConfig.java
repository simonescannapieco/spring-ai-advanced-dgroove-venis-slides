package it.venis.ai.spring.demo.config;

...

@Configuration
public class RAGConfig {

    ...

    @Bean
    RetrievalAugmentationAdvisor geminiRetrievalAugmentationAdvisor(
            @Qualifier("geminiVectorStore") VectorStore geminiVectorStore) {

        return RetrievalAugmentationAdvisor.builder()
                .documentRetriever(
                        VectorStoreDocumentRetriever.builder()
                                .vectorStore(geminiVectorStore)
                                .topK(4)
                                .similarityThreshold(.2)
                                .build())
                .build();
    }

}
