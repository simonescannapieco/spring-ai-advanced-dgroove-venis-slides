package it.venis.ai.spring.demo.controllers;

...

@RestController
public class QuestionController {

    ...

    @PostMapping("/ollama/ask/rag")
    public Answer getOllamaRAGAnswer(@RequestBody QuestionRequest request) {

        return this.ragService.getOllamaRAGAnswer(request);

    }

    @PostMapping("/ollama/ask/rag/web-search")
    public Answer getOllamaWebSearchRAGAnswer(@RequestBody QuestionRequest request) {

        return this.ragService.getOllamaWebSearchRAGAnswer(request);

    }

}
