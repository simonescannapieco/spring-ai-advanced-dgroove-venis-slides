@RestController
@RequestMapping("/api")
public class AudioController {

    private final OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel;

    AudioController(OpenAiAudioTranscriptionModel transcriptionModel,
            SpeechModel speechModel) {
        this.openAiAudioTranscriptionModel = transcriptionModel;
        this.speechModel = speechModel;
    }

    @GetMapping("/transcribe")
    String transcribe(@Value("classpath:filename.mp3") Resource audioFile) {
        return openAiAudioTranscriptionModel.call(audioFile);
    }

}