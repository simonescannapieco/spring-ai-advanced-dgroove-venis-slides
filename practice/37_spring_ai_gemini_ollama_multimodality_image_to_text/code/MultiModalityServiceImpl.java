package it.venis.ai.spring.demo.services;

import javax.print.attribute.standard.Media;

...

@Service
public class MultiModalityServiceImpl implements MultiModalityService {

    private final ChatClient geminiChatClient;

    public MultiModalityServiceImpl(@Qualifier("geminiChatClient") ChatClient geminiChatClient) {

        this.geminiChatClient = geminiChatClient;

    }
    ...
    @Override
    public Answer getDescriptionFromImage(Resource imageFile) {

        String contentType = getContentType(imageFile);

        Media imageMedia = new Media(MimeTypeUtils.parseMimeType(contentType), imageFile);

        return new Answer(this.geminiChatClient.prompt()
                .user(u -> u.text("Descrivi in lingua italiana la seguente immagine: ").media(imageMedia))
                .call()
                .content());

    }

    ...