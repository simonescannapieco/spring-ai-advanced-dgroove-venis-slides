
    ...

    @PostMapping("/gemini/ask/help-desk-tools/help-desk")
    public Answer getGeminiHelpDeskToolAnswer(@RequestHeader("username") String username,
            @RequestParam("message") String message) {
        return new Answer(
            this.geminiHelpDeskToolsChatClient.prompt()
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, username))
                .user(message)
                .toolContext(Map.of("username", username))
                .call().content()
            );
    }

    @PostMapping("/ollama/ask/help-desk-tools/help-desk")
    public Answer getOllamaHelpDeskToolAnswer(@RequestHeader("username") String username,
            @RequestParam("message") String message) {
        return new Answer(
            this.ollamaHelpDeskToolsChatClient.prompt()
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, username))
                .user(message)
                .toolContext(Map.of("username", username))
                .call().content()
            );
    }

}
