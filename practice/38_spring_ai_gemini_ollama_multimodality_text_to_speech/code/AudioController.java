@RestController
@RequestMapping("/api")
public class AudioController {

    private final TextToSpeechModel speechModel;

    AudioController(TextToSpeechModel speechModel) {
        this.speechModel = speechModel;
    }

    @GetMapping("/speech")
    String spech(@RequestParam("message") String message) throws IOException {
        byte[] audioBytes = speechModel.call(message);
        Path path = Paths.get("output.mp3");
        Files.write(path, audioBytes);
        return "MP3 salvato con successo in " + path.toAbsolutePath();
    }

}