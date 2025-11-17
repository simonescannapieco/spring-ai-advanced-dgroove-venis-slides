package it.venis.ai.spring.demo.services;

...

@Service
public class MultiModalityServiceImpl implements MultiModalityService {

    private final ChatClient geminiChatClient;

    public MultiModalityServiceImpl(@Qualifier("geminiChatClient") ChatClient geminiChatClient) {

        this.geminiChatClient = geminiChatClient;

    }

    @Override
    public Answer getTranscriptionFromAudioFile(Resource audioFile) {
        
        String contentType = getContentType(audioFile);

        Media audioMedia = new Media(
            MimeTypeUtils.parseMimeType(contentType), audioFile
        );

        return new Answer(this.geminiChatClient.prompt()
        .user(u -> u.text("Trascrivi il seguente file audio: ").media(audioMedia))
        .call()
        .content()
        );
        
    }

    ...