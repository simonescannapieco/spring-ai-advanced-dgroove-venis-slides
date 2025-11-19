package it.venis.ai.spring.demo.controllers;

...

@RestController
@RequestMapping("/gemini/multi-modality")
public class GeminiMultimodalityController {

    private final MultiModalityService multiModalityService;

    public GeminiMultimodalityController(MultiModalityService multiModalityService) {

        this.multiModalityService = multiModalityService;
    }

    /**
     * Endpoint per la trascrizione di file audio in testo (Speech-to-Text).
     * Utilizza un file audio predefinito dal classpath e ne estrae la trascrizione testuale
     * tramite i servizi di riconoscimento vocale di Gemini.
     *
     * @param audioFile risorsa audio dal classpath (file WAV predefinito)
     * @return Answer oggetto contenente la trascrizione del file audio
     */
    @PostMapping("/stt")
    public Answer getTranscriptionFromAudioFile(@Value("classpath:Venis_descrizione_azienda.wav") Resource audioFile) {

        return this.multiModalityService.getTranscriptionFromAudioFile(audioFile);

    }

}