package it.venis.ai.spring.demo.controllers;

...

@RestController
@RequestMapping("/gemini/multi-modality")
public class GeminiMultimodalityController {

    private final MultiModalityService multiModalityService;

    public GeminiMultimodalityController(MultiModalityService multiModalityService) {

        this.multiModalityService = multiModalityService;
    }

    ...
    
    /**
     * Endpoint per l'analisi e descrizione di immagini (Image-to-Text).
     * Carica un'immagine predefinita dal classpath e utilizza le capacità di visione
     * di Gemini per generare una descrizione testuale del contenuto dell'immagine.
     *
     * @param audioFile risorsa immagine dal classpath (file PNG predefinito)
     * @return Answer oggetto contenente la descrizione generata dell'immagine
     */
    @PostMapping("/itt")
    public Answer getDescriptionFromImage(@Value("classpath:multimodal.test.png") Resource audioFile) {

        return this.multiModalityService.getDescriptionFromImage(audioFile);

    }

}