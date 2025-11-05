package it.venis.ai.spring.demo.controllers;

...

@RestController
public class QuestionController {

    ...
    private final ToolService toolService;

    public QuestionController(QuestionService service, RAGService ragService, ToolService toolService) {
        this.service = service;
        this.ragService = ragService;
        this.toolService = toolService;
    }

    ...

    @PostMapping("/gemini/ask/time-tools/local-time")
    public Answer getGeminiToolLocalTimeAnswer(@RequestBody QuestionRequest request) {
        return this.toolService.getGeminiToolLocalTimeAnswer(request);
    }

    @PostMapping("/ollama/ask/time-tools/local-time")
    public Answer getOllamaToolLocalTimeAnswer(@RequestBody QuestionRequest request) {
        return this.toolService.getOllamaToolLocalTimeAnswer(request);
    }

}
