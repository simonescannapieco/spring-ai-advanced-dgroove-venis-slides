@RestController
@RequestMapping("/api")
public class AudioController {

    ...

    @GetMapping("/speech-options")
    String spechWithOptions(@RequestParam("message") String message) throws IOException {
        TextToSpeechResponse speechResponse = speechModel.call(
            new TextToSpeechPrompt(message,
                OpenAiAudioSpeechOptions.builder()
                    .voice(OpenAiAudioApi.SpeechRequest.Voice.NOVA)
                    .speed(2.0f)
                    .responseFormat(OpenAiAudioApi.SpeechRequest.AudioResponseFormat.MP3)
                    .build()));
        Path path = Paths.get("speech-options.mp3");
        Files.write(path, speechResponse.getResult().getOutput());
        return "MP3 salvato con successo in " + path.toAbsolutePath();
    }

}