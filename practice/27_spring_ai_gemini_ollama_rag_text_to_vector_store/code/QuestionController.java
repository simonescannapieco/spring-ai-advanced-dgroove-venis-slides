package it.venis.ai.spring.demo.controllers;

...

@RestController
public class QuestionController {

    private final QuestionService service;
    private final RAGService ragService;

    public QuestionController(QuestionService service, RAGService ragService) {
        this.service = service;
        this.ragService = ragService;
    }

    ...

    @PostMapping("/gemini/ask/rag")
    public Answer getGeminiRAGAnswer(@RequestBody QuestionRequest request) {
        return this.ragService.getGeminiRAGAnswer(request);
    }

    @PostMapping("/ollama/ask/rag")
    public Answer getOllamaRAGAnswer(@RequestBody QuestionRequest request) {
        return this.ragService.getOllamaRAGAnswer(request);
    }

}
