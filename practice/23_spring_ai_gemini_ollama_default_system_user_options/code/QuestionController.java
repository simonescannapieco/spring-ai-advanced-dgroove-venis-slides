package it.venis.ai.spring.demo.controllers;

...

@RestController
public class QuestionController {
    
    private final QuestionService service;

    public QuestionController(QuestionService service) {

        this.service = service;

    }

    ...

    @PostMapping("/ollama/ask")
    public Answer ollamaAskQuestion(@RequestBody Question question) {

        return this.service.getOllamaAnswer(question);

    }

    @PostMapping("/ollama/ask/default")
    public Answer ollamaAskDefaultQuestion(@RequestBody Question question) {

        return this.service.getOllamaDefaultAnswer(question);

    }

}
