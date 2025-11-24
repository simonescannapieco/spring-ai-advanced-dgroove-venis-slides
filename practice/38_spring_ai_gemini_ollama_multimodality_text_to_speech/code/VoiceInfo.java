package it.venis.ai.spring.demo.model;

import java.util.List;

public class VoiceInfo {
    private String name;
    private List<String> languageCodes;
    private String gender;

    public VoiceInfo(String name, List<String> languageCodes, String gender) {
        this.name = name;
        this.languageCodes = languageCodes;
        this.gender = gender;
    }

    ...
    
}