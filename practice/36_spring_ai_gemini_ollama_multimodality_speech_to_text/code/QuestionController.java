package it.venis.ai.spring.demo.controllers;

...

@RestController
@Configuration
public class QuestionController {

    ...
    private final MultiModalityService multiModalityService;
    ...

    public QuestionController(QuestionService service,
            RAGService ragService,
            TimeToolsService timeToolsService,
            MultiModalityService multiModalityService,
            ...) {

        ...
        this.multiModalityService = multiModalityService;
        ...

    }

    ...

    @PostMapping("/gemini/ask/multi-modality/transcribe")
    public Answer getTranscriptionFromAudioFile(@Value("classpath:Venis_descrizione_azienda.wav") Resource audioFile) {
        return this.multiModalityService.getTranscriptionFromAudioFile(audioFile);
    }
}