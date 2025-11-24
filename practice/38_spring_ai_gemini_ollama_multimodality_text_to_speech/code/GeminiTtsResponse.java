package it.venis.ai.spring.demo.model;

public class GeminiTtsResponse {
    private String audioBase64;
    private String mimeType;
    private String message;

    public GeminiTtsResponse(String audioBase64, String mimeType, String message) {
        this.audioBase64 = audioBase64;
        this.mimeType = mimeType;
        this.message = message;
    }

    ...
}