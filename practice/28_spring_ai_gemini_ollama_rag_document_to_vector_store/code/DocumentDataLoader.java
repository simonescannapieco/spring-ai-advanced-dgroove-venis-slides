package it.venis.ai.spring.demo.rag;

...

@Component
@Profile("rag-document-to-vector-store")
public class DocumentDataLoader {

    private final VectorStore geminiVectorStore;
    private final VectorStore ollamaVectorStore;

    public DocumentDataLoader(@Qualifier("geminiVectorStore") VectorStore geminiVectorStore,
            @Qualifier("ollamaVectorStore") VectorStore ollamaVectorStore) {
        this.geminiVectorStore = geminiVectorStore;
        this.ollamaVectorStore = ollamaVectorStore;

    }

    @Value("classpath:Venis_HR_Policies_ENG.pdf")
    Resource venisHREngDocument;

    @Value("classpath:Venis_Politiche_HR_ITA.pdf")
    Resource venisHRItaDocument;

    ...

