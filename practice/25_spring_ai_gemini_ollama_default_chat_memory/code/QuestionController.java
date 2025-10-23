package it.venis.ai.spring.demo.controllers;

...

@RestController
public class QuestionController {
    
    private final QuestionService service;

    public QuestionController(QuestionService service) {

        this.service = service;

    }

    ...

    @PostMapping("/ollama/ask/default")
    public Answer ollamaAskDefaultQuestion(@RequestBody Question question) {

        return this.service.getOllamaDefaultAnswer(question);

    }

    @PostMapping("/ollama/ask/memory")
    public Answer getOllamaMemoryAwareAnswer(@RequestBody Question question) {

        return this.service.getOllamaMemoryAwareAnswer(question);

    }

}
