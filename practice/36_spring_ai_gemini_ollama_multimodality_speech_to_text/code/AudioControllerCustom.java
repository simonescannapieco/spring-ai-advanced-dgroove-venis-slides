@RestController
@RequestMapping("/api")
public class AudioController {

    ...

    @GetMapping("/transcribe-options")
    String transcribeWithOptions(@Value("classpath:filename.mp3") Resource audioFile) {
        var audioTranscriptionResponse = openAiAudioTranscriptionModel.call(new AudioTranscriptionPrompt(
                audioFile, OpenAiAudioTranscriptionOptions.builder()
                .prompt("Topics")
                .language("it")
                .temperature(0.5f)
                .responseFormat(OpenAiAudioApi.TranscriptResponseFormat.VTT).build()));
        return audioTranscriptionResponse.getResult().getOutput();
    }

}