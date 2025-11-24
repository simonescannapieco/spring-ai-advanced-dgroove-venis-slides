package it.venis.ai.spring.demo.controllers;
...
@RestController
@RequestMapping("/gemini/multi-modality")
public class GeminiMultimodalityController {

    /** Chiave API di Google AI recuperata dalle proprietà di configurazione */
    @Value("${GOOGLE_AI_API_KEY}")
    private String geminiApiKey;

    /** URL base dell'API Gemini per le richieste ai modelli */
    @Value("${gemini.api.models.url}")
    private String geminiApiUrl;

    /** Servizio per le operazioni multimodali (STT, ITT, TTS) */
    private final MultiModalityService multiModalityService;

    /** Client HTTP REST per le chiamate all'API di Gemini */
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Costruttore del controller per la gestione delle funzionalità multimodali di Gemini.
     *
     * @param multiModalityService servizio per le operazioni multimodali (STT, ITT, TTS)
     */
    public GeminiMultimodalityController(MultiModalityService multiModalityService) {

        this.multiModalityService = multiModalityService;
    }
    ...
}