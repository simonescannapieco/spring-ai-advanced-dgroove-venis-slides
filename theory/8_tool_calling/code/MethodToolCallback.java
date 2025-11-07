Method method = MethodToolCallbackReflectionUtils.findMethod(TimeTools.class, "getCurrentLocalTime");
ToolCallback toolCallback = MethodToolCallback.builder()
    .toolDefinition(ToolDefinitions.builder(method)
            .description("Ottieni l'ora corrente nel fuso orario dell'utente.")
            .build())
    .toolMethod(method)
    .toolObject(new TimeTools())
    .build();